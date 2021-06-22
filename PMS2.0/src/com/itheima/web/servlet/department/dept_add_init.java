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


@WebServlet("/dept_add_init")
public class dept_add_init extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public dept_add_init() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
//		String did = request.getParameter("dept_id");
				
		DepartmentService departmentService = new DepartmentService();
//		List<String> departments = null;
//		departments = departmentService.dept_find_all_name();
		List<Department> departments = null;
		departments = departmentService.dept_find_all();
		request.setAttribute("departments", departments);
		request.getRequestDispatcher("/dept_add.jsp").forward(request, response);
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
