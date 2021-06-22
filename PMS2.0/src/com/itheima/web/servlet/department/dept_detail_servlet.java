package com.itheima.web.servlet.department;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Department;
import com.itheima.domain.Staff;
import com.itheima.service.DepartmentService;
import com.itheima.service.StaffService;


@WebServlet("/dept_detail_servlet")
public class dept_detail_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public dept_detail_servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String dname= request.getParameter("dept_name");

		DepartmentService departmentService = new DepartmentService();
		List<Department> departments = null;
		Department department = null;
		departments = departmentService.dept_find_all();
		
		if(dname == null) {
			department = departments.get(0);
			dname =department.getDname();
			
		}
		else {
			for(int i = 0; i<departments.size();i++)
			{
				if(departments.get(i).getDname().equals(dname))
				{
					department = departments.get(i);
					break;
				}
			}
//			System.out.println("无查到该部门"+department.getDname());
			
		}
		if(department!= null) {
			//读取该部门下的所有员工信息
			
//		Staff staffs = null;
			List<Staff> Stafflist = null;
			StaffService staffservice = new StaffService();
			Stafflist=	staffservice.find_by_department(dname);
			request.setAttribute("Stafflist",Stafflist);
			
		}
		
		
		
		request.setAttribute("department", department);
		request.setAttribute("departments", departments);
		request.getRequestDispatcher("/dept_detail.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
