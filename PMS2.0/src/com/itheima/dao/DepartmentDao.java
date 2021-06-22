package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Department;
import com.itheima.utils.DataSourceUtils;

public class DepartmentDao {
	//部门添加
	public void dept_add(String dname,int dgrade,String dup) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into department values(?,?,?,?);";
		runner.update(sql,null,dname,dup,dgrade);
		
	}
	
	//根据名称查询部门
		public Department dept_select(String dname) throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select * from dept_view where dname=?";
			return runner.query(sql,new BeanHandler<Department>(Department.class),dname);		
			
			
		}
		
	//查询所有部门
		public List<Department> dept_all() throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select * from dept_view ";
			return runner.query(sql,new BeanListHandler<Department>(Department.class));		
		}
		
		//查询所有部门数量
		public int dept_count() throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select count(*)  from dept_view";
			Number count = (Number) runner.query(sql, new ScalarHandler());
			return count.intValue();
				
		}	
		
		
		//查询所有部门名称
				public List<String> dept_all_name() throws SQLException {
					QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
					String sql = "select dname from dept_view ";
					return runner.query(sql,new BeanListHandler<String>(String.class));		
				}
		
		//根据等级查询部门
			public List<Department> dept_dgrade(int dgrade) throws SQLException {
				QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				String sql = null;
				if(dgrade>3) 
					 sql ="select * from dept_view where dgrade > 3";
				else sql = "select * from dept_view where dgrade = ?";
				return runner.query(sql,new BeanListHandler<Department>(Department.class),dgrade);		
			}
	//修改部门信息
		public void dept_update(int did,String dname,int dgrade, String dup) throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "update department set dname=?,dgrade=?,dup=? where did=? ";
			 runner.update(sql,dname,dgrade,dup,did);		
		}
	//删除部门信息
		public void dept_delete(int did) throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "delete from  department where did=? ";
			 runner.update(sql,did);		
		}
	
	
}
