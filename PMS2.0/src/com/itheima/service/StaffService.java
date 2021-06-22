package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.AttendanceDao;
import com.itheima.dao.StaffDao;
import com.itheima.domain.Staff;

public class StaffService {

	public List<Staff> findallstaff(int page){
		StaffDao dao=new StaffDao();	
		List<Staff> stafflist=null;
		try {
			stafflist = dao.findallstaff(page);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stafflist;
}
	
	public List<Staff> findall(){
		StaffDao dao=new StaffDao();	
		List<Staff> stafflist=null;
		try {
			stafflist = dao.findall();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stafflist;
}
	public int findCount() {
		StaffDao dao=new StaffDao();
		int count = -1;
		try {
			 count=dao.staff_count();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	
	public List<Staff> find_by_department(String department_name){
		StaffDao dao=new StaffDao();	
		List<Staff> stafflist=null;
		try {
			stafflist = dao.find_by_department(department_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stafflist;
}

	public void insertstaff(int sid,String staff_name, int age, String telephone, String join_time, String sex, String dept,int salary) throws SQLException {
			StaffDao dao=new StaffDao();
			dao.insertstaff(sid,staff_name,age,telephone,join_time,sex,dept,salary);
		
	}
	public void updatestaff(int sid,String staff_name, int age, String telephone, String join_time, String sex, String dept,int salary) throws SQLException {
		StaffDao dao=new StaffDao();
		dao.updatestaff(sid, staff_name, age, telephone, join_time, sex, dept, salary);	
}

	public Staff findstaffbysid(String sname) {
		StaffDao dao =new StaffDao();
		Staff staff =new Staff();
		try {
			staff=dao.findstaffbyid(sname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;
	}

	public void delectbyid(int delectid) {
		StaffDao dao =new StaffDao();
		try {
			dao.delectbyid(delectid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int findidbyname(String staff_name) {
		StaffDao dao =new StaffDao();
		int sid=0;
		try {
			sid=dao.findidbyname(staff_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sid;
	}

	public Staff staffchangebyid(int sid) {
		StaffDao dao =new StaffDao();
		Staff staff=new Staff();
		try {
			staff=dao.staffchangebyid(sid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;
	}

	public int findmostsid() {
		StaffDao dao=new StaffDao();
		int sid=0;
		try {
			sid=dao.findmostsid()+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sid;
	}

}