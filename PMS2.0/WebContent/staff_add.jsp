<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<title>员工入职</title>
	<style type="text/css">
		.form-inline .form-group{
			display: block;
			margin-top: 20px;
		}
		.form-inline label{
			margin-right: 30px;
		}
	</style>
</head>
<body>
	<form  action="staffadd?sid=${staff.sid}" class="form-inline" style="margin-left: 40%;margin-top: 50px" method="post">
		<div class="form-group" style="display: block">
			<label for="exampleInput">姓名</label>
			<input type="text" value="${staff.sname }"  name="staff_name" class="form-control">
		</div>
		<div class="form-group">
			<label for="exampleInput">年龄</label>
			<input type="text" value="${staff.sage }" name="age" class="form-control">
		</div>
		<div class="form-group sex">
			<label for="exampleInput">性别</label>
			<label for="exampleInput"><input type="radio" name="sex" class="form-control" value="男" checked="checked">男</label>
			<label for="exampleInput"><input type="radio" name="sex" class="form-control" value="女">女</label>
		</div>
		<div class="form-group">
			<label for="exampleInput">手机</label>
			<input type="text" value="${staff.sphone }"name="telephone" class="form-control">
		</div>
		<div class="form-group">
			<label for="exampleInput" style="margin-right: 0px;">入职时间</label>
			<input type="text"value="${staff.sdate}" name="join_time" class="form-control" >
		</div>
		<div class="form-group">
			<label for="exampleInput">部门</label>
			<select  name="dept" class="form-control dept" >
					<option value="无" >无</option>
					<option value="总裁" >总裁</option>
					<option value="行政管理部">行政管理部</option>
					<option value="项目执行部">项目执行部</option>
					<option value="营销策划部">营销策划部</option>
					<option value="财务部">财务部</option>
				</select>
		</div>
		<div class="form-group">
			<label for="exampleInput">薪酬</label>
			<input type="text" value="${staff.swage }" name="salary" class="form-control">
		</div>
		
		<button type="submit" class="btn btn-default form-control" style="margin-top: 20px;margin-left: 100px;" >提交</button>
	</form>

	<script type="text/javascript">
//获取url中的参数值
var staff_id,update=0;
$(function () {
   (function ($) {
        $.getUrlParam = function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) 
            	// return unescape(r[2]); 不能传输中文
            	return decodeURI(r[2]); 
            return null;
        }
    })(jQuery);
    update = $.getUrlParam('update');
     staff_id = $.getUrlParam('staff_id');
     //如果是修改用户，改变表单提交地址
    /*  if(staff_id!=null) $("form").attr('href','update_staff_servlet'); */
     
     
});
$(document).ready(function(){
	$(".dept").val("${staff.sdepartment}");
	$(".sex").val("${staff.ssex}");
	// $('.up_dept').attr('value',up_dept);
});
	</script>
</body>
</html>