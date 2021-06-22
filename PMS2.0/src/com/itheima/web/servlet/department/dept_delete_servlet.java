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


@WebServlet("/dept_delete")
public class dept_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public dept_delete_servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		request.getRequestDispatcher("/dept_list_servlet").forward(request, response);
		String get_did =request.getParameter("did") ;
	    if(get_did == null) {
	    	request.getRequestDispatcher("/dept_list_servlet").forward(request, response);
	    	System.out.println("false");
	    }
	    
	    else {
	    	System.out.print(get_did);
	    int did = Integer.parseInt(get_did);
	    System.out.println(" "+did);
		DepartmentService departmentService = new DepartmentService();
		departmentService.dept_delete(did);
		request.getRequestDispatcher("/dept_list_servlet").forward(request, response);
	    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
