<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<title>部门增加</title>
</head>
<body>
	<form style="width: 90%;margin: 5%" action="/PMS/dept_add_servlet" method="post" > 
		<!-- 提交到添加部门servlet -->
		<div class="form-group">
			<label for="exampleInput">部门名称</label>
			<input type="text" name="dept_name" class="form-control dept_name">
		</div>
		<div class="form-group">
			<label for="exampleInput">部门等级</label>
			<input type="text" name="dept_grade" class="form-control dept_grade">
		</div>
		<div class="form-group">
			<label for="exampleInput">上级部门</label>
			<select name="up_dept" class="form-control up_dept" >
					<option value="无">无</option>
				<c:forEach items="${departments}" var="newPro">
					<option value="${newPro.dname}">${newPro.dname}</option>
				</c:forEach>
					
				</select>
		</div>
		<button type="submit" class="btn btn-default form-control" style="margin-top: 20px">提交</button>
	</form>

	<script type="text/javascript">
//获取url中的参数值
var update,dept_id,dept_name ,dept_grade,up_dept;
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
     dept_id = $.getUrlParam('dept_id');
     dept_name = $.getUrlParam('dept_name');
     dept_grade = $.getUrlParam('dept_grade');
     up_dept = $.getUrlParam('up_dept');

     if(!up_dept) up_dept="无";
     if(update==1)  $('form').attr('action','/PMS/dept_update_servlet?dept_id='+dept_id);
     // 如果是更新，改变form表单跳转的servlet
     console.log(dept_name+" "+dept_grade +" "+up_dept);
});
$(document).ready(function(){
	$('.dept_name').attr('value',dept_name);
	$('.dept_grade').attr('value',dept_grade);
	$('.up_dept').val(up_dept);
	// $('.up_dept').attr('value',up_dept);
});
	</script>
</body>
</html>