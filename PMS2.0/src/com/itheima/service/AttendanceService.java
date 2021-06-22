package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.AttendanceDao;
import com.itheima.dao.StaffDao;
import com.itheima.domain.Attendance;
import com.itheima.domain.Staff;

public class AttendanceService {


	public List<Attendance> findAttendancebynname(String sname) {
		AttendanceDao dao =new AttendanceDao();
		List<Attendance> attendancelist =null;
		try {
			attendancelist=dao.findAttendancebynname(sname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attendancelist;
	}

	public void delectbyid(int delectid20) {
		AttendanceDao dao=new AttendanceDao();
		try {
			dao.delectbyid(delectid20);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public List<Attendance> findallAttendance(int page1) {
		AttendanceDao dao =new AttendanceDao();
		List<Attendance> attendancelist =null;
		try {
			attendancelist=dao.findallAttendance(page1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attendancelist;
	}
	
	public int findCount() {
		AttendanceDao dao =new AttendanceDao();
		int count = -1;
		try {
			 count=dao.attendance_count();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public void addAttendance(String staff_name, String type, String reason, String time) {
		// TODO Auto-generated method stub
		StaffService service=new StaffService();
		int sid=service.findidbyname(staff_name);
		System.out.println(sid);
		AttendanceDao dao=new AttendanceDao();
		try {
			dao.addAttendance(sid, staff_name,type,reason,time);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateAttendance(int aid,int sid, String type, String reason, String time) {
		// TODO Auto-generated method stub
		
		AttendanceDao dao=new AttendanceDao();
		try {
			dao.updateAttendance(aid, sid, type, reason, time);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Attendance Attendancechangebyid(int sid) {
		AttendanceDao dao =new AttendanceDao();
		Attendance Attendance=new Attendance();
		try {
			Attendance=dao.Attendancechangebyid(sid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Attendance;
	}

}
