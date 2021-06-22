package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Staff;
import com.itheima.utils.DataSourceUtils;

public class StaffDao {

	public List<Staff> findallstaff(int page) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from staff  limit ?,?";
		return runner.query(sql, new BeanListHandler<Staff>(Staff.class),(page-1)*10,10);
	}
	
	public List<Staff> findall() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from staff ";
		return runner.query(sql, new BeanListHandler<Staff>(Staff.class));
	}
	

	public List<Staff> find_by_department(String department_name) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from staff  WHERE sdepartment = ?";
		return runner.query(sql, new BeanListHandler<Staff>(Staff.class),department_name);
	}




	public int findmostsid() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select sid from staff order by sid desc limit 0,1";
		return (int) runner.query(sql,new ScalarHandler());
	}

	//查询所有员工数量
	public int staff_count() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*)  from staff";
		Number count = (Number) runner.query(sql, new ScalarHandler());
		return count.intValue();
			
	}	

	public void insertstaff(int sid, String staff_name, int age, String telephone, String join_time, String sex,String dept,int salary) throws SQLException {
	String s="0";
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	String sql = "insert into staff values(?,?,?,?,?,?,?,?,?)";
	runner.update(sql,sid,staff_name,age,telephone,sex,join_time,s,dept,salary);
		
	}
	public void updatestaff(int sid, String staff_name, int age, String telephone, String join_time, String sex,String dept,int salary) throws SQLException {
		String s="0";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update staff set sname=?,sage=?,sphone=?,ssex=?,sdate=?,sattendance=?,sdepartment=?,swage=? where sid=? ";
		runner.update(sql,staff_name,age,telephone,sex,join_time,s,dept,salary,sid);
			
		}





	public Staff findstaffbyid(String sname) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from staff where sname=?  limit 0,1";
		return runner.query(sql, new BeanHandler<Staff>(Staff.class), sname);
	}






	public void delectbyid(int delectid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "DELETE from staff where sid=?";
		runner.update(sql,delectid);
	}






	public int findidbyname(String staff_name) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select sid from staff where sname=? order by sid desc limit 0,1";
		return (int) runner.query(sql,new ScalarHandler(),staff_name);
	}






	public Staff staffchangebyid(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from staff where sid=?  limit 0,1";
		return runner.query(sql, new BeanHandler<Staff>(Staff.class), sid);
	}

}
