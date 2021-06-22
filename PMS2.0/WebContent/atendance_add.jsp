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
	<title>考勤申请</title>
</head>
<body>
	<form style="width: 90%;margin: 5%"  action="updateattendance?aid=${attendance_id}"  method="post" > 
		<!-- 提交到添加部门servlet -->
		<div class="form-group sname">
			<label for="exampleInput">员工姓名</label>
			<input type="text" value="${attendance.sname}" name="staff_name" class="form-control staff_name" >
			
		</div>
		<div class="form-group sattendance">
			<label for="exampleInput">考勤类型</label>
			<select name="type" class="form-control type" >
					<option value="请假">请假</option>
					<option value="加班">加班</option>
					<option value="迟到">迟到</option>
				</select>
		</div>
		<div class="form-group sreason">
			<label for="exampleInput">原因</label>
			<input type="text" value="${attendance.reason}" name="reason" class="form-control reason">
		</div>
		<div class="form-group sdate">
			<label for="exampleInput">时间</label>
			<input type="text" name="time" value="${attendance.time}" class="form-control time">
		</div>
		
		<button type="submit" class="btn btn-default form-control" style="margin-top: 20px">提交</button>
	</form>

	<script type="text/javascript">
//获取url中的参数值
var update,attendance_id;
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
     attendance_id = $.getUrlParam('attendance_id');
   /*  if(attendance_id!=null)  $('form').attr('action',"updateattendance?aid="+attendance_id);
     // 如果是更新，改变form表单跳转的servlet
     console.log(dept_name+" "+dept_grade +" "+up_dept); */
});
$(document).ready(function(){
 	$('.staff_name').attr('value"',staff_name);
	$('.time').attr('value',time); 
	$('.type').val("${attendance.type}");
/* 	$('.sreason').val("${attendance.reason}");
	$('.stype').val("${attendance.type}");
	$('.sdate').val("${attendance.time}");
	$('.sname').val("${attendance.sname}"); */
	
});
	</script>
</body>
</html>