<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<title>添加用户</title>
</head>
<body>
	<form style="width: 90%;margin: 5%" action="user_add_servlet"  method="post"> 
		<!-- 提交到添加用户servlet -->
		<div class="form-group">
			<label for="exampleInput">用户名</label>
			<input type="text" name="user_name" class="form-control user_name">
		</div>
		<div class="form-group">
			<label for="exampleInput">密码</label>
			<input type="text" name="password" class="form-control password">
		</div>
		<div class="form-group">
			<label for="exampleInput">电话</label>
			<input type="text" name="contact" class="form-control contact">
		</div>
		<div class="form-group">
			<label for="exampleInput">邮箱</label>
			<input type="text" name="address" class="form-control address">
		</div>
		<button type="submit" class="btn btn-default form-control" style="margin-top: 20px">提交</button>
	</form>

	<script type="text/javascript">
//获取url中的参数值
var update,user_id,user_name ,password,power,address,page;
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
     user_id = $.getUrlParam('user_id');
     user_name = $.getUrlParam('user_name');
     password = $.getUrlParam('password');
     contact = $.getUrlParam('contact');
     address = $.getUrlParam('address');
     page = $.getUrlParam('page');
     
     if(update==1)  $('form').attr('action','user_update_servlet?user_id='+user_id+"&page="+page);
     // 如果是更新，改变form表单跳转的servlet
     
});
$(document).ready(function(){
	$('.user_name').attr('value',user_name);
	$('.password').attr('value',password);
	$('.contact').attr('value',contact);
	$('.address').attr('value',address);
	//$('.address').val(address);
	// $('.up_dept').attr('value',up_dept);
});
	</script>
</body>
</html>