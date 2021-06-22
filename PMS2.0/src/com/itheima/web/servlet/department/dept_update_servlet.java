package com.itheima.web.servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.DepartmentService;

/**
 * Servlet implementation class dept_update_servlet
 */
@WebServlet("/dept_update_servlet")
public class dept_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dept_update_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		
//		获取页面传输的参数
		int did = Integer.parseInt(request.getParameter("dept_id"));
		String dname =request.getParameter("dept_name") ;		
		int dgrade = Integer.parseInt(request.getParameter("dept_grade"));
		String dup = request.getParameter("up_dept");
//		新建一个部门的Service
		DepartmentService departmentService = new DepartmentService();
//		使用DepartmentService中的dept_update方法修改数据库中的用户信息
		departmentService.dept_update(did,dname,dgrade,dup);
//		修改完成跳转到用户列表页面
		request.getRequestDispatcher("/dept_list_servlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
