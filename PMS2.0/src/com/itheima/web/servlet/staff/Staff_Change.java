package com.itheima.web.servlet.staff;//这行代码用于自动识别包，并导包

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Staff;
import com.itheima.service.StaffService;
@WebServlet("/staffchange")
public class Staff_Change extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid2=request.getParameter("user_id");
		Integer sid1 = new Integer(sid2).intValue();
		int sid=sid1.intValue();
		Staff staff=new Staff();
		StaffService service=new StaffService();
		staff=service.staffchangebyid(sid);
		request.setAttribute("staff", staff);
		request.getRequestDispatcher("/staff_add.jsp").forward(request, response);
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