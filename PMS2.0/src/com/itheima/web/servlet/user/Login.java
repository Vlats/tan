package com.itheima.web.servlet.user;//这行代码用于自动识别包，并导包

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.User;
import com.itheima.service.UserService;
@WebServlet("/loginservlet")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user1 =new User();
		String Uname=request.getParameter("user");
		String Upassword=request.getParameter("password");
		UserService service=new UserService();
		int is_true = 0;
		is_true=service.cheaklogin(Uname,Upassword);
		System.out.print(is_true);
		
		if(is_true==0) {
			request.setAttribute("is_true", is_true);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}
		else {
			user1 = service.findUserByname(Uname);
			request.setAttribute("user", user1);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//对于post请求，设置请求编码，防止乱码
		request.setCharacterEncoding("utf-8");
		//设置响应正文的编码和浏览器解码采用的编码
		response.setContentType("text/html;charset=utf-8");
		doGet(request,response);
	}
}