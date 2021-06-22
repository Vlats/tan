<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>登录</title>
	<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
	<style type="text/css">
		*{margin: 0;
			padding: 0;}
		form div{
			width: 100%;
			height: 40px;
			margin-bottom: 30px;
	/*		border: 1px solid red;*/
			position: relative;
		}
		.submit{
			width: 100%;
			height: 100%;
			text-align: center;
			line-height: 100%; 
			background-color: #00ff0080;
		}
		input{
			position: absolute;
			right: 0px;
			width: 85%;
			height: 100%;
			border: 0px;
			font-size: 18px;
		/*	color: #00000050;*/
		}
		.title a{
			height: 40px;
			width:50%;
			background-color: #000000a0;
			display: inline-block;
			color: #fff;
			/*font-size: 22px;*/
			text-align: center;
			line-height: 40px;
			text-decoration: none;			
		}
		.title .logon{
			background-color: #00000050;

		}
		.title .login{
			cursor: auto;

		}
		div span{
			width:15%;
			height: 100%;
			background-color:#00000050;
			display: inline-block;
			position: absolute;
			background-size: 60% 60%;
			background-position: center;
			background-repeat: no-repeat;
			top: 0px;
			text-align: center;
			line-height: 40px; 
			color:#fff;
			
		}
		.tips{
			display: none;
			width: 200px;
			height: 30px;
			background-color: #00000050;
			color: #fff;
			position: absolute;
			left: 43%;
			text-align: center;
			line-height: 30px;
			top: 90px;

		}
	</style>

</head>
<body >
	<div style="background-image: url(img/background.jpg);background-size: 100% 100%;background-repeat: no-repeat; position:absolute; top: 0px;bottom: 0px;width: 100%"></div>
	<div style="position: relative;margin:0px auto ;top: 150px;width: 300px;height: 250px;/*border: 1px solid red;*/background-color: #ffffff40">
		<form method="post" action="loginservlet">
			<div class="title"><a class="login" href="javascript:;">登录</a><a class="logon" href="logon.jsp">注册</a></div>
			<div><span >用户</span><input class="user" type="text" name="user" value="" ></div>
			<div><span ">密码</span><input class="password" type="password" name="password"></div>
			<div><input class="submit" type="submit" value="登录"></div>
			
		</form>
	</div>
		<div class="tips" id="${is_true}">用户名/密码错误</div>
	<script type="text/javascript">
		function tip_none(){
			$(".tips").text("用户名/密码不能为空");
			$(".tips").css("display","inline-block");
			
			setTimeout(function(){
				$(".tips").css("display","none");
				$(".tips").text("用户名/密码错误");
			},3000);
		};
		function tip_error(){
			$(".tips").css("display","inline-block");
			setTimeout(function(){
				$(".tips").css("display","none");
			},3000);
		};


		$(document).ready(function(){
			$(".submit").click(function(){
				 if ($(".user").val()&&$(".password").val()) return ture;
				 else {
					tip_none();
					return false;
				 };
			});
		});
		
		if($("#0").length){
			tip_error();
		} 
	</script>
</body>
</html>