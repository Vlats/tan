package com.itheima.web.servlet.staff;//这行代码用于自动识别包，并导包

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.itheima.service.StaffService;
@WebServlet("/staffadd")
public class StaffAdd extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String staff_name = request.getParameter("staff_name");
		String sid2 = request.getParameter("sid");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String telephone = request.getParameter("telephone");
		String join_time = request.getParameter("join_time");
		String dept = request.getParameter("dept");
		String salary = request.getParameter("salary");
		Integer age1 = new Integer(age).intValue();
//		Integer telephone1 = new Integer(telephone).intValue();
		Integer salary1 = new Integer(salary).intValue();
		int age2=age1.intValue();
//		int telephone2=telephone1.intValue();
		String telephone2 = telephone;
		int salary2=salary1.intValue();
		StaffService service = new StaffService();
		int sid;
		if(sid2!="") {
		Integer sid1 = new Integer(sid2).intValue();
		sid =  sid1.intValue();}
		
		else { sid=service.findmostsid(); }
			
		try {
			
			if(sid2=="")
			service.insertstaff(sid,staff_name,age2,telephone2,join_time,sex,dept,salary2);
			else 
			{
				service.updatestaff(sid,staff_name,age2,telephone2,join_time,sex,dept,salary2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sid2!="")
			response.sendRedirect(request.getContextPath()+"/stafflist");
		else
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