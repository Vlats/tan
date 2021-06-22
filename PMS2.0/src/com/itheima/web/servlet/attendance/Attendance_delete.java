package com.itheima.web.servlet.attendance;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.AttendanceService;
import com.itheima.service.DepartmentService;

/**
 * Servlet implementation class Attendance_delete
 */
public class Attendance_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Attendance_delete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aid =request.getParameter("aid") ;
		String page= request.getParameter("page");
		request.setAttribute("page", page);
	    if(aid == null) {
	    	request.getRequestDispatcher("/attendancelist").forward(request, response);
	    	System.out.println("false");
	    }
	    
	    else {
	    	AttendanceService aservice = new AttendanceService();
	    	aservice.delectbyid(Integer.parseInt(aid));
	    	
	    }
	    
		request.getRequestDispatcher("/attendancelist").forward(request, response);
	    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
