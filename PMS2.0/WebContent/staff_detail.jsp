<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>部门信息</title>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="iconfont/iconfont.css">
	<!-- 导入图标 -->
	<style type="text/css">
		 .navbar-form {
		 	margin-left: 40%;
		 }
		 .delete{
			color: #337ab7;
			cursor: pointer;
		}
	</style>
</head>
<body>
     
     
      <form class="navbar-form navbar-left" action="staffdetail">
        <div class="form-group">
          <input type="text" name="staff_name" class="form-control" placeholder="员工姓名">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form>  
   <table class="table table-striped table-bordered table-hover">
   		<caption>员工信息</caption>
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
				<th width="10%">删除</th>
				<th width="10%">编辑</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${staff.sid }</td>
				<td>${staff.sname }</td>
				<td>${staff.ssex }</td>
				<td>${staff.sage }</td>
				<td>${staff.sphone }</td>
				<td>${staff.sdate }</td>
				<td>${staff.sdepartment }</td>
				<td>${staff.swage }</td>
				
				<c:if test="${staff.sid ne null }">
          			<td><span data-toggle="modal" data-target="#myModal" class=" iconfont icon-13 delete" id="${staff.sid }"></span></td>
				<td><a href="staffchange?user_id=${staff.sid}" class="iconfont icon-12"></a></td></c:if>
				<c:if test="${staff.sid eq null }">
          		<td></td>
				<td></td>
          		</c:if>
				
				
				
				
			</tr>
		</tbody>
	</table>
	<table class="table table-striped table-bordered table-hover">
		<caption>考勤信息</caption>
		<thead>
			<tr>
				<th width="20%">时间</th>
				<th width="10%">分类</th>
				<th width="30%">原因</th>
				<th width="10%">删除</th>
				<th width="10%">编辑</th>
			</tr>
		</thead>
				<c:forEach items="${attendancelist}" var="newPro">
				<tbody>
					<tr>
				
				<td>${newPro.time}</td>
				<td>${newPro.type}</td>
				<td>${newPro.reason}</td>
				<td><span data-toggle="modal" data-target="#myModal" class=" iconfont icon-13 delete2" id="${newPro.aid}"></span></td>
				<td><a href="attendancechang?attendance_id=${newPro.aid}" class="iconfont icon-12"></a></td>
			
			</tr>
		</tbody>
	</c:forEach>
	</table>
  

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
                <a href="staffdetail?page=" class="btn btn-primary delete_sure">确定</a>
                <!-- 按确定跳转到删除servlet -->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script type="text/javascript">
 $(document).ready(function(){		
		$('.delete_sure').attr('href','staffdetail?page='+page);
		// 改变弹出框中确定按钮的跳转路径，携带当前页数		
	});
$(document).ready(function(){
    	 	$(".delete").click(function(){
    	 		$('.delete_sure').attr('href','staffdetail?delete_id='+this.id); //delect_id2="+this.id2
    	 		// 改变弹出框中确定按钮的跳转路径，携带部门id
    			
    	 	});
    	 });
$(document).ready(function(){
 	$(".delete2").click(function(){
 		$('.delete_sure').attr('href','staffdetail?delete_id2='+this.id); //delect_id2="+this.id2
 		// 改变弹出框中确定按钮的跳转路径，携带部门id
		
 	});
 });
    	 </script>
</body>
</html>