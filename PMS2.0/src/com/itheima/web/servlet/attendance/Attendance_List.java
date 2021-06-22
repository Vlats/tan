package com.itheima.web.servlet.attendance;//这行代码用于自动识别包，并导包

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Attendance;
import com.itheima.service.AttendanceService;
import com.itheima.utils.PageInfo;
@WebServlet("/attendancelist")
public class Attendance_List extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page=request.getParameter("page");
		if(page==null) page="1";
		Integer page2=new Integer(page).intValue();
		int page1=page2.intValue();
		List<Attendance> attendancelist=null;
		AttendanceService service2 = new AttendanceService();
		attendancelist=service2.findallAttendance(page1);
		
		int total = 0;
		total= service2.findCount();		
		PageInfo pageinfo = new PageInfo(page1,total);
		request.setAttribute("pageinfo",pageinfo);
		
		request.setAttribute("attendancelist", attendancelist);
		request.getRequestDispatcher("/attendance_list.jsp").forward(request, response);
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