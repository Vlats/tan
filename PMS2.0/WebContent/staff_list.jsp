<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="iconfont/iconfont.css">
	<!-- 导入图标 -->
	<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<title>员工列表</title>
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
				<td><span data-toggle="modal" data-target="#myModal" class=" iconfont icon-13 delete" id="${newPro.sid}"></span></td>
				<td><a href="staffchange?user_id=${newPro.sid}" class="iconfont icon-12"></a></td>
			</tr>

					</c:forEach>
		</tbody>
	</table>

	<nav aria-label="Page navigation">
  <ul class="pagination">
     <li><a href="javascript:;" aria-label="Previous" class="last_page"><span aria-hidden="true">&laquo;</span></a></li>
   <c:forEach  begin="${pageinfo.start }" end="${pageinfo.end }"  varStatus="status">
				 <li><a href="stafflist?page=${status.index}">${status.index}</a></li>		
		</c:forEach>
    <li>
      <a href="#" aria-label="Next" class="next_page">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
     <li ><span style="color:gray">总页数${pageinfo.page_num}</span></li>
  </ul>
</nav>
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
                <a href="stafflist?page=" class="btn btn-primary delete_sure">确定</a>
                <!-- 按确定跳转到删除servlet -->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script type="text/javascript">
	var page;
	var page_sum=${pageinfo.page_num};
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
	page = $.getUrlParam('page');
     if(!page) page=1;
     $('.next_page').attr('href','stafflist?page='+(page-1+2));
     if(page!=1) $('.last_page').attr('href','stafflist?page='+(page-1));
     
     if(page==page_sum) $('.next_page').attr('href','javascript:;');
     for(var i =1;i<$('.pagination a').length-1;i++)
     {
     	if($('.pagination a')[i].text==page){
     	$('.pagination li')[i].className = "active";
     	$('.pagination a')[i].href = "javascript:;";
     }
     };
});

    $(document).ready(function(){		
		$('.delete_sure').attr('href','staff_list.jsp?page='+page);
		// 改变弹出框中确定按钮的跳转路径，携带当前页数		
	});
    $(document).ready(function(){
    	 	$(".delete").click(function(){
    	 		$('.delete_sure').attr('href','stafflist?delete_id='+this.id+"&page="+page);
    	 		// 改变弹出框中确定按钮的跳转路径，携带员工id和当前页数
    			
    	 	});
    	 });
</script>

</body>
</html>