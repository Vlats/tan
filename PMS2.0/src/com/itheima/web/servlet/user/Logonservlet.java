package com.itheima.web.servlet.user;//这行代码用于自动识别包，并导包

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.MailUtils;
@WebServlet("/logonservlet")
public class Logonservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//读取注册信息
		String address = request.getParameter("address");
		String user = request.getParameter("user");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		UserService service = new UserService();	
		service.addUser(user,contact,password,address);
//		//发送邮箱
//		int id = 0;
//		UserDao dao=new UserDao();
//		try {
//			id = dao.findUid();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		String Mid = String.valueOf(id);
//		String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户"
//				+ "<a href='http://localhost:8080/PMS/authentication?Uid="+Mid+"'>"
//						+ "http://localhost:8080/PMS/authentication?Uid="+Mid+"</a>";
//		try {
//			MailUtils.sendMail(address, emailMsg);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
		
		//跳转到登陆界面
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//对于post请求，设置请求编码，防止乱码
		request.setCharacterEncoding("utf-8");
		//设置响应正文的编码和浏览器解码采用的编码
		response.setContentType("text/html;charset=utf-8");
	}
}