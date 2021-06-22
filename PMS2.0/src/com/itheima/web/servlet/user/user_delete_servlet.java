package com.itheima.web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.DepartmentService;
import com.itheima.service.UserService;

@WebServlet("/user_delete_servlet")
public class user_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public user_delete_servlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String get_uid =request.getParameter("user_id") ;
	    if(get_uid == null) {
	    	request.getRequestDispatcher("/user_list_servlet").forward(request, response);
	    	System.out.println("false");
	    }
	    
	    else {
	    	
	    int uid = Integer.parseInt(get_uid);
	    UserService userService = new UserService();
	    userService.user_delete(uid);
		
		request.getRequestDispatcher("/user_list_servlet").forward(request, response);
	    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
