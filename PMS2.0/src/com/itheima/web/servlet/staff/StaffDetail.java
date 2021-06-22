package com.itheima.web.servlet.staff;//这行代码用于自动识别包，并导包

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Attendance;
import com.itheima.domain.Staff;
import com.itheima.service.AttendanceService;
import com.itheima.service.StaffService;
@WebServlet("/staffdetail")
public class StaffDetail extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StaffService service = new StaffService();	
		AttendanceService service3=new AttendanceService();
		
		String delectid2 = request.getParameter("delete_id");
		if(delectid2!=null) {
			Integer delectid1=new Integer(delectid2).intValue();
			int delectid=delectid1.intValue();
			service.delectbyid(delectid);
		}
		
		String delectid22 = request.getParameter("delete_id2");
		if(delectid22!=null) {
			Integer delectid21=new Integer(delectid22).intValue();
			int delectid20=delectid21.intValue();
			service3.delectbyid(delectid20);
		}
		
		String sname=request.getParameter("staff_name");
		Staff staff =new Staff();
		staff=service.findstaffbysid(sname);
		request.setAttribute("staff", staff);
		
		List<Attendance> attendancelist=null;
		AttendanceService service2 = new AttendanceService();
		attendancelist=service2.findAttendancebynname(sname);
		request.setAttribute("attendancelist", attendancelist);
		request.getRequestDispatcher("/staff_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//对于post请求，设置请求编码，防止乱码
		request.setCharacterEncoding("utf-8");
		//设置响应正文的编码和浏览器解码采用的编码
		response.setContentType("text/html;charset=utf-8");
	}
}