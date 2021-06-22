<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>注册</title>
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
		.title .login{
			background-color: #00000050;

		}
		.title .logon{
			cursor: auto;

		}
		div span{
			width:15%;
			height: 40px;
			line-height: 40px;
			color: #fff;
			background-color:#00000050;
			display: inline-block;
			position: absolute;
			background-size: 60% 60%;
			background-position: center;
			background-repeat: no-repeat;
			top: 0px;
			text-align: center;
		}
		.home{
			display: inline-block;
			width: 60px;
			height: 160px;
			font-size: 60px;
			text-decoration: none;
			color: #fff;
			position: absolute;
			left: 15%;
			top: 140px;
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
	<div style="position: relative;margin:0px auto ;top: 150px;width: 300px;height: 350px;/*border: 1px solid red;*/background-color: #ffffff40">
		<form method="get" action="logonservlet">
			<div class="title"><a class="login" href="login.jsp">登录</a><a class="logon" href="javascript:;">注册</a></div>
			<div><span>邮箱</span><input class="address" type="text" name="address" value="" ></div>
			<div><span>名称</span><input class="user" type="text" name="user" value="" ></div>
			<div><span>手机</span><input class="contact" type="text" name="contact" value=""></div>
			<div><span>密码</span><input class="password" type="password" name="password"></div>
			<div><span>密码</span><input class="password2" type="password" name="password2"></div>
			<div><input class="submit" type="submit" value="注册"></div>
			
		</form>
	</div>
		<div class="tips">输入框不能为空</div>
		<script type="text/javascript">
		function tip_none(){
			$(".tips").css("display","inline-block");
			setTimeout(function(){
				$(".tips").css("display","none");
			},3000);
		};
		function tip_user_error(){
			$(".tips").css("display","inline-block");
			$(".tips").text("用户名已存在");
			setTimeout(function(){
				$(".tips").css("display","none");
				$(".tips").text("输入框不能为空");
			},3000);
		};
		function tip_password_error(){
			$(".tips").css("display","inline-block");
			$(".tips").text("密码不一致");
			setTimeout(function(){
				$(".tips").css("display","none");
				$(".tips").text("输入框不能为空");
			},3000);
		};
		


		$(document).ready(function(){
			$(".submit").click(function(){
				if($(".password").val()!=$(".password2").val()){
					tip_password_error();
					return false;
				}

				 if ($(".address").val()&&$(".user").val()&&$(".password").val()&&$(".password2").val()) 
				 {
				 	
				 	alert("注册成功，请前往登录");
				 	return ture;
				 
				 }
				 	
				 else {
					tip_none();
					return false;
				 };
			});
		});

	</script>
</body>
</html>