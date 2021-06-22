package com.itheima.web.servlet.staff;//这行代码用于自动识别包，并导包

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Staff;
import com.itheima.service.StaffService;
import com.itheima.utils.PageInfo;
@WebServlet("/stafflist")
public class StaffList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StaffService service = new StaffService();	
		String delectid2 = request.getParameter("delete_id");
		String page = request.getParameter("page");
		if(page==null) page="1";
		
		
		if(delectid2!=null) {
			Integer delectid1=new Integer(delectid2).intValue();
			int delectid=delectid1.intValue();
			service.delectbyid(delectid);
			
			
		}
		
		

		Integer page1=new Integer(page).intValue();
		int page2=page1.intValue();
		List<Staff> Stafflist=service.findallstaff(page2);
		int total = 0;
		total= service.findCount();		
		PageInfo pageinfo = new PageInfo(page2,total);
		request.setAttribute("pageinfo",pageinfo);
				
		request.setAttribute("Stafflist", Stafflist);	
		
		
		
		//跳转到classily
		request.getRequestDispatcher("/staff_list.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//对于post请求，设置请求编码，防止乱码
		request.setCharacterEncoding("utf-8");
		//设置响应正文的编码和浏览器解码采用的编码
		response.setContentType("text/html;charset=utf-8");
	}
}