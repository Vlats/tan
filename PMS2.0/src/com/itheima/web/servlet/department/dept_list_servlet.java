package com.itheima.web.servlet.department;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Department;
import com.itheima.service.DepartmentService;


@WebServlet("/dept_list_servlet")
public class dept_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public dept_list_servlet() {
        super();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DepartmentService departmentService = new DepartmentService();
		List<Department> departments = null;
		departments = departmentService.dept_find_all();
		request.setAttribute("departments", departments);
		request.getRequestDispatcher("/dept_list.jsp").forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
