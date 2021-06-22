<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>部门信息</title>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="iconfont/iconfont.css">
	<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<style type="text/css">
		 .navbar-nav{
		 	margin-left: 20%;
		 }
		 .detail{
		 	width: 80%;
		 	margin-left: 20%;
		 	margin-bottom: 20px;
		 }
		 .detail>span{
		 	display: inline-block;
		 	width: 20%;
		 	font-size: 16px;


		 }
		 .detail>span>span{
		 	margin-left: 20px;	
		 }
	</style>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">一级部门<span class="caret"></span></a>
          <ul class="dropdown-menu">
          	<c:forEach items="${departments }" var="newPro">
          		<c:if test="${newPro.dgrade eq 1 }">
          			<li><a href="dept_detail_servlet?dept_name=${newPro.dname }">${newPro.dname }</a></li>
          		</c:if>
          	</c:forEach>
            
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">二级部门<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <c:forEach items="${departments }" var="newPro">
          		<c:if test="${newPro.dgrade eq 2 }">
          			<li><a href="dept_detail_servlet?dept_name=${newPro.dname}">${newPro.dname }</a></li>
          		</c:if>
          	</c:forEach>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">三级部门<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <c:forEach items="${departments }" var="newPro">
          		<c:if test="${newPro.dgrade eq 3 }">
          			<li><a href="dept_detail_servlet?dept_name=${newPro.dname}">${newPro.dname }</a></li>
          		</c:if>
          	</c:forEach>
          </ul>
        </li>
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他部门<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <c:forEach items="${departments }" var="newPro">
          		<c:if test="${newPro.dgrade > 3 }">
          			<li><a href="dept_detail_servlet?dept_name=${newPro.dname}">${newPro.dname }</a></li>
          		</c:if>
          	</c:forEach>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" action="/PMS/dept_detail_servlet">
        <div class="form-group">
          <input type="text" name="dept_name" class="form-control" placeholder="部门名称">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form>  
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


		<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th width="25%">部门名称</th>
				<th width="15%">部门等级</th>
				<th width="15%">人数</th>
				<th width="25%">上级部门</th>
				<th width="10%">删除</th>
				<th width="10%">编辑</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${department.dname}</td>
				<td>${department.dgrade }</td>
				<td>${department.sum }</td>
				<td>${department.dup }</td>	
				<c:if test="${department.dname ne null }">
          			<td><span data-toggle="modal" data-target="#myModal" class=" iconfont icon-13 delete" id="1"></span></td>
				<td><a href="dept_add_init?update=1&dept_id=${department.did}&dept_name=${department.dname}&dept_grade=${department.dgrade}&up_dept=${department.dup}" class="iconfont icon-12"></a></td>
          		</c:if>
				<c:if test="${department.dname eq null }">
          		<td></td>
				<td></td>
          		</c:if>
				
			</tr>
</tbody>
</table>
		<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th width="10%">员工编码</th>
				<th width="10%">姓名</th>
				<th width="5%">性别</th>
				<th width="5%">年龄</th>
				<th width="15%">手机号</th>
				<th width="15%">入职时间</th>
				<th width="10%">部门</th>
				<th width="10%">薪酬</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Stafflist}" var="newPro">

					<tr>
				<td>${newPro.sid}</td>
				<td>${newPro.sname}</td>
				<td>${newPro.ssex}</td>
				<td>${newPro.sage}</td>
				<td>${newPro.sphone}</td>
				<td>${newPro.sdate}</td>
				<td>${newPro.sdepartment}</td>
				<td>${newPro.swage}</td>
				
			</tr>

					</c:forEach>
		</tbody>
	</table>
	<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">敏感操作</h4>
            </div>
            <div class="modal-body">是否确定删除</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a href="dept_delete?did=${department.did}" class="btn btn-primary delete_sure">确定</a>
                <!-- 按确定跳转到删除servlet -->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>