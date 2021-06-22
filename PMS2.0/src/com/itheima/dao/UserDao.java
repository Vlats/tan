package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import com.itheima.utils.MailUtils;

public class UserDao {
	//添加user
	public void addUser(String uname, String contact, String password,String email) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		UserDao dao=new UserDao();
		int Cid=dao.findUid()+1;
		String sql = "insert into user values(?,?,?,?,?,1,0)";
		runner.update(sql,Cid,uname,password, contact,email);
		
	}
	//找到最大的Uid
	public int findUid() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select Uid from user order by Uid desc limit 0,1";
		return (int) runner.query(sql,new ScalarHandler());
	}
	//查到是否注册了
	public void istrue(String uid) throws SQLException {
		Integer i = new Integer(uid).intValue();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set Uproduct=? where Uid=?";
		runner.update(sql, 1,i);
	}
	//通过名字找到password
	public String findpasswordByname(String uname) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select Upassword from user WHERE Uname=?  limit 0,1";
		return  (String) runner.query(sql,new ScalarHandler(),uname);
	}
	//通过名字找到是否注册了
	public String finis_trueByname(String uname) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select is_true from user WHERE Uname=?  limit 0,1;";
		return  (String) runner.query(sql,new ScalarHandler(),uname);
	}
	public User findUserByid(int uid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where Uid=?";
		return runner.query(sql, new BeanHandler<User>(User.class), uid);
	}
	public User findUserByname(String uname) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where Uname=?";
		return runner.query(sql, new BeanHandler<User>(User.class), uname);
	}
	
	//用户添加
			public void user_add(String uname,String password,String contact ,String email) throws SQLException {
				QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				String sql = "insert into user values(?,?,?,?,?,1,0);";
				runner.update(sql,null,uname, contact,password,email);
				
			}
			
			//根据名称查询用户
				public User user_select(String uname) throws SQLException {
					QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
					String sql = "select * from user where uname=?";
					return runner.query(sql,new BeanHandler<User>(User.class),uname);		
					
					
				}
				
			//查询所有用户
				public List<User> user_all() throws SQLException {
					QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
					String sql = "select * from user;";
					return runner.query(sql, new BeanListHandler<User>(User.class));
						
				}
				
				//查询所有用户数量
				public int user_count() throws SQLException {
					QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
					String sql = "select count(*)  from user";
					Number count = (Number) runner.query(sql, new ScalarHandler());
					return count.intValue();
					
						
				}	
				
				
			
//				查询分页用户
				public List<User> user_page(int start, int num) throws SQLException {
					QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
					String sql = "select * from user  order by Uid asc limit ?,?;";
					return runner.query(sql, new BeanListHandler<User>(User.class),start,num);
						
				}
				
			
				
		
			//修改用户信息
				public void user_update(int uid,String uname,String password,String contact, String email) throws SQLException {
					QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
					String sql = "update User set Uname=?,Upassword=?,Ucontact=?,Uemail=? where Uid=? ";
					 runner.update(sql,uname,password,contact,email,uid);		
				}
			//删除部门信息
				public void user_delete(int uid) throws SQLException {
					QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
					String sql = "delete from  User where uid=? ";
					 runner.update(sql,uid);		
				}


}
