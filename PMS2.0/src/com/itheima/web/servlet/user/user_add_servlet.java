package com.itheima.web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.DepartmentService;
import com.itheima.service.UserService;

@WebServlet("/user_add_servlet")
public class user_add_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public user_add_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uname = request.getParameter("user_name");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		String page=request.getParameter("page");
		request.setAttribute("page", page);
//		int  power= Integer.parseInt(request.getParameter("power"));
		UserService userService = new UserService();
		userService.user_add(uname, password, contact, address);
		request.getRequestDispatcher("/user_list_servlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
