package com.itheima.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Department;
import com.itheima.domain.Staff;
import com.itheima.domain.User;
import com.itheima.service.DepartmentService;
import com.itheima.service.StaffService;
import com.itheima.service.UserService;


public class home_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public home_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		DepartmentService departmentService = new DepartmentService();
		List<Department> departments = null;
		departments = departmentService.dept_find_all();
		request.setAttribute("department_num", departments.size());
		
		StaffService service = new StaffService();	
		List<Staff> Stafflist=service.findall();
		request.setAttribute("staff_num", Stafflist.size());
		
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
