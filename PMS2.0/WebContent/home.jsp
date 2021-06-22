<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>主页</title>
	<meta charset="utf-8">
	<style type="text/css">
		/*div{
			display: inline-block;
		}*/
		.title{
			border-bottom: 1px solid #f2f2f2f2;
			margin-bottom: 10px;
			padding-bottom: 5px;
		}
		.bar{
			width: 37%;
			height: 80px;
			display: inline-block;
			margin-left: 40px;

		}
		.pic{
			display: inline-block;
			width: 50px;
			height: 50px;
			background-size: 100% 100%;
			margin-left: 10px;
		}
		.bar>div{
			display: inline-block;
			font-size: 20px;

		}
		ul{
			list-style: none;

		}
		ul li {
			display: inline-block;
			width: 40%;
			height: 100px;
			margin-right: 0px;
		}
		.tail{
			width:10%
		}
		a{
			text-decoration: none;
			color: #000;
		}

	</style>
</head>
<body>
	<div>
		<div class="title" ><strong>企业统计</strong></div>
			<div class="bar" style="margin-Left:20%;width:10%">
				<div class="pic" style="background-image: url(img/dept.png);"></div>
				<div><div>部门数量</div>
					<div style="margin-Left:25px">${department_num }</div>
				</div>
			</div>
			<div class="bar" style="margin-Left:30%;width:10%">
				<div class="pic" style="background-image: url(img/staff.png);"></div>
				<div><div>员工数量</div>
					<div style="margin-Left:25px">${staff_num}</div>
				</div>
			</div>
	</div>

	<div>
		<div class="title"><strong>部门管理</strong></div>
		<ul>
			<li>
				<div><a href="dept_list_servlet">
					<div class="pic" style="background-image: url(img/work1.png);"></div>
				<!-- 	<div style="text-align: center;">0</div> -->
					<div>部门列表</div></a>
				</div>
			</li>
			<li>
				<div><a href="dept_add_init">
					<div class="pic" style="background-image: url(img/work2.png);"></div>
					<!-- <div style="text-align: center;">0</div> -->
					<div>部门增加</div></a>
				</div>
			</li>
			<li class="tail">
				<div><a href="dept_detail_servlet">
					<div class="pic" style="background-image: url(img/work3.png);"></div>
					<!-- <div style="text-align: center;">0</div> -->
					<div>部门详情</div></a>
				</div>
			</li>
		
		</ul>
	</div>

	<div>
		<div class="title"><strong>员工管理</strong></div>
					<ul>
			<li>
				<div><a href="stafflist">
					<div class="pic" style="background-image: url(img/staff1.png);"></div>
					<div>员工列表</div></a>
				</div>
			</li>
			<li>
				<div><a href="staff_add.jsp">
					<div class="pic" style="background-image: url(img/staff2.png);"></div>
					<!-- <div style="text-align: center;">0</div> -->
					<div>员工入职</div></a>
				</div>
			</li>
			<li class="tail">
				<div ><a href="staff_detail.jsp">
					<div class="pic" style="background-image: url(img/staff3.png);"></div>
					<!-- <div style="text-align: center;">0</div> -->
					<div>员工信息</div></a>
				</div>
			</li>
			
		</ul>			
	</div>
	<div>
		<div class="title"><strong>快捷入口</strong></div>
					<ul>
			<li>
				<div><a href="user_list_servlet">
					<div class="pic" style="background-image: url(img/quick1.png);"></div>
					<div>用户列表</div></a>
				</div>
			</li>
			<li>
				<div><a href="user_add.jsp">
					<div class="pic" style="background-image: url(img/quick2.png);"></div>
					<div>用户增加</div></a>
				</div>
			</li>
			<li class="tail">
				<div>
					<a href="attendancelist">
					<div class="pic" style="background-image: url(img/quick3.png);"></div>
					<div>考勤列表</div></a>
				</div>
			</li>
			
		</ul>			
	</div>

</body>
</html>