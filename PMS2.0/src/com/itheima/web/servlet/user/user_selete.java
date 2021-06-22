package com.itheima.web.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;


@WebServlet("/user_selete_servlet")
public class user_selete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public user_selete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("user_name");
		
		UserService userService = new UserService();
		List<User> users= null;
		User user = userService.user_find_by_name(uname);
		users.add(user);
		request.setAttribute("users", users);
		request.getRequestDispatcher("/user_list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
