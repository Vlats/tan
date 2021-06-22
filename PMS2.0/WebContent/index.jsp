<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>人事管理系统</title>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="iconfont/iconfont.css">
	<!-- 导入图标 -->
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>	
	<div class="left-body">
		<div class="logo">人事管理系统</div>
	 	<ul class="nav nav-divider" >
			<li>
				<a href="home_servlet" target="iframe_content"><span class="iconfont icon-19 text-left" ></span><span class="manage">主页</span></a></li>
		<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" ><span class="iconfont icon-17 " ></span><span class="manage">部门管理</span><span class="caret " ></span></a>
				<ul class="dropdown-menu ">
				<li><a href="dept_list_servlet" target="iframe_content">部门列表</a></li>
				<li ><a  href="dept_add_init" target="iframe_content">增加部门</a></li>
				<li><a href="dept_detail_servlet" target="iframe_content">部门信息</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" ><span class="iconfont icon-" ></span><span class="manage">员工管理</span><span class="caret" ></span></a>
				<ul class="dropdown-menu ">
				<li ><a  href="stafflist" target="iframe_content">员工列表</a></li>
				<li><a href="staff_add.jsp" target="iframe_content">员工入职</a></li>
				<!-- <li><a href="home.html" target="iframe_content">员工离职</a></li> -->
				<li><a href="staff_detail.jsp" target="iframe_content">员工信息</a></li>
				</ul>
			</li>
			
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" ><span class="iconfont icon-10 " ></span><span class="manage">用户管理</span><span class="caret " ></span></a>
				<ul class="dropdown-menu ">
				<li ><a  href="user_list_servlet" target="iframe_content">用户列表</a></li>
				<li><a href="user_add.jsp" target="iframe_content">添加用户</a></li>
		<!-- 		<li><a href="company_detail.html" target="iframe_content">个人用户</a></li> -->
				</ul>
			</li>
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" ><span class="iconfont icon-6" ></span><span class="manage">考勤管理</span><span class="caret " ></span></a>
				<ul class="dropdown-menu ">
				<li ><a  href="attendancelist" target="iframe_content">考勤列表</a></li>
				<li><a href="atendance_add.jsp" target="iframe_content">考勤申请</a></li>
				<!-- <li><a href="attendance_examine.html" target="iframe_content">考勤审核</a></li> -->
				</ul>
			</li>
			
		</ul> 
		
	</div>

	<div class="right-body">
		<div class="top-nav" style="height: 50px;background-color:#fff;border-bottom: 2px solid #f2f2f2f2;position: relative;">
			<ul class="nav nav-pills" style="position: absolute; right: 0px;bottom: 0px">
				<li><a href="login.jsp"  >登陆</a></li>
				<li><a href="logon.jsp" >注册</a></li>
				<li><a href="javascript:;" target="iframe_content">${user.uname}</a></li>
				<li><a href="login.jsp" class="iconfont icon-4" >退出</a></li>
			</ul>
		</div>
		<div id="content" style="width: 100%; background-color: #f2f2f2f2">
			<iframe name="iframe_content" id="iframe_content" src="home_servlet" ></iframe>
		</div>
	</div>
	<script type="text/javascript">		
  		$('.dropdown-menu').click(function(e) {     
 		 	e.stopPropagation();  //取消点击子菜单，跳转后收缩
		});
	</script>
</body>
</html>