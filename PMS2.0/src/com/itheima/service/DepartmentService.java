package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.AttendanceDao;
import com.itheima.dao.DepartmentDao;
import com.itheima.domain.Department;

public class  DepartmentService {
	public List<Department> dept_find_all(){
		DepartmentDao departmentDao = new DepartmentDao();
		List<Department> dept_all = null;
		try {
			
			dept_all = departmentDao.dept_all();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept_all;
		
	}
	public List<String> dept_find_all_name(){
		DepartmentDao departmentDao = new DepartmentDao();
		List<String> dept_all_name = null;
		try {
			
			dept_all_name = departmentDao.dept_all_name();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept_all_name;
		
	}
	public int findCount() {
		DepartmentDao departmentDao = new DepartmentDao();
		int count = -1;
		try {
			 count=departmentDao.dept_count();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public Department dept_find_by_name(String dname) {
		DepartmentDao departmentDao = new DepartmentDao();
		Department dept= null;
		try {
			dept = departmentDao.dept_select(dname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
	}
	public  void dept_add(String dname,int dgrade,String dup) {
		DepartmentDao departmentDao = new DepartmentDao();
		try {
			departmentDao.dept_add(dname, dgrade, dup);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  void dept_update(int did,String dname,int dgrade,String dup) {
		DepartmentDao departmentDao = new DepartmentDao();
		try {
			departmentDao.dept_update(did, dname, dgrade, dup);;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public  void dept_delete(int did) {
		DepartmentDao departmentDao = new DepartmentDao();
		try {
			departmentDao.dept_delete(did);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}