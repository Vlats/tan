package com.itheima.web.servlet.attendance;//这行代码用于自动识别包，并导包

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.AttendanceService;
import com.itheima.service.StaffService;
@WebServlet("/updateattendance")
public class update_attendance_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String aid = request.getParameter("aid");
		String staff_name=request.getParameter("staff_name");
		String type=request.getParameter("type");
		String reason=request.getParameter("reason");
		String time=request.getParameter("time");
		String sid = request.getParameter("staff_id");
		
		StaffService service1=new StaffService();
		int sid2=service1.findidbyname(staff_name);
		System.out.println(aid);
		
		AttendanceService service = new AttendanceService();
		if(aid == "") {
			
			service.addAttendance(staff_name,type,reason,time);
		}
		else {
			
			service.updateAttendance(Integer.parseInt(aid), sid2, type, reason, time);
		}


		response.sendRedirect(request.getContextPath()+"/atendance_add.jsp");
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