package com.itheima.web.servlet.attendance;//这行代码用于自动识别包，并导包

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Attendance;
import com.itheima.service.AttendanceService;
@WebServlet("/attendancechang")
public class Attendance_Chang extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String aid2=request.getParameter("attendance_id");
		Integer aid1 = new Integer(aid2).intValue();
		int aid=aid1.intValue();
		Attendance attendance=new Attendance();
		AttendanceService service=new AttendanceService();
		attendance=service.Attendancechangebyid(aid);
		request.setAttribute("attendance_id",aid2);
		
		request.setAttribute("attendance", attendance);
		request.getRequestDispatcher("/atendance_add.jsp").forward(request, response);
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