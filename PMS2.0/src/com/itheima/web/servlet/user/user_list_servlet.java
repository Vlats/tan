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
import com.itheima.utils.PageInfo;

@WebServlet("/user_list_servlet")
public class user_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public user_list_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String page = request.getParameter("page");
		int start =0,total=0;
		
		if(page!=null&&page!="1") {
			if(page=="") page="1";
			start = (Integer.parseInt(page) -1)*10; 
		}
		UserService userService = new UserService();
		if(page==null||page=="") {
			page="1";
		}
		int current_page =Integer.parseInt(page);
		List<User> users= null;
		
		total= userService.findCount();		
		users = userService.user_find_page(start);
		PageInfo pageinfo = new PageInfo(current_page,total);
		
		request.setAttribute("users", users);
		request.setAttribute("pageinfo",pageinfo);
//		System.out.println(pageinfo.getCurrent()+" "+pageinfo.getTotal()+" "+pageinfo.getStart()+" "+pageinfo.getEnd()+" "+pageinfo.getPage_num());
		request.getRequestDispatcher("/user_list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
