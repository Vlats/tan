<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="iconfont/iconfont.css">
	<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<!-- 导入图标 -->
	<title>部门列表</title>
	<style type="text/css">
		.delete{
			color: #337ab7;
			cursor: pointer;
		}
	</style>
</head>
<body>
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
			<c:forEach items="${departments}" var="newPro">


				<tr>
					<td>${newPro.dname}</td>
					<td>${newPro.dgrade }</td>
					<td>${newPro.sum }</td>
					<td>${newPro.dup }</td>	
					<td><span data-toggle="modal" data-target="#myModal" class=" iconfont icon-13 delete" id="${newPro.did}"></span></td>
					<td><a href="dept_add_init?update=1&dept_id=${newPro.did}&dept_name=${newPro.dname}&dept_grade=${newPro.dgrade}&up_dept=${newPro.dup}" class="iconfont icon-12"></a></td>
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
                <a href="dept_list.html?dept_id=" class="btn btn-primary delete_sure">确定</a>
                <!-- 按确定跳转到删除servlet -->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
 <script type="text/javascript">
	 $(document).ready(function(){
	 	$(".delete").click(function(){
		$('.delete_sure').attr('href','dept_delete?did='+this.id);
			// 改变弹出框中确定按钮的跳转路径，携带部门id
			
		});
	 });
</script> 

</body>
</html>