package com.itheima.web.servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.DepartmentService;


@WebServlet("/dept_add_servlet")
public class dept_add_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public dept_add_servlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String dname =request.getParameter("dept_name") ;
		
		int dgrade = Integer.parseInt(request.getParameter("dept_grade"));
		String get_dgrade = request.getParameter("dept_grade");
		String dup = request.getParameter("up_dept");
		DepartmentService departmentService = new DepartmentService();
		departmentService.dept_add(dname,dgrade,dup);
		request.getRequestDispatcher("/dept_list_servlet").forward(request, response);
	    
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
