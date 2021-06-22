package com.itheima.web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.UserService;


@WebServlet("/user_update_servlet")
public class user_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public user_update_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int  uid= Integer.parseInt(request.getParameter("user_id"));
		String page=request.getParameter("page");
		String uname = request.getParameter("user_name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
//		int  power= Integer.parseInt(request.getParameter("power"));
		String contact = request.getParameter("contact");
		UserService userService = new UserService();
		request.setAttribute("page", page);
		userService.user_update(uid, uname, password, contact, address);
		request.getRequestDispatcher("/user_list_servlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
