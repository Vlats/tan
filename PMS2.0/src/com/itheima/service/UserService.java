package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.StaffDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {
	
	//添加用户
	public void addUser(String user, String contact, String password, String eamil) {
		UserDao dao = new UserDao();
		try {
			dao.addUser(user,contact,password,eamil);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询是否验证了
	public void istrue(String uid) {
		UserDao dao=new UserDao();
		try {
			dao.istrue(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询是否可以登陆
	public int cheaklogin(String uname, String upassword) {
		UserDao dao=new UserDao();
		String password = "";
		String is_true = "";
		try {
			password =  dao.findpasswordByname(uname);
			is_true=dao.finis_trueByname(uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String i="1";
		
		/*if(user.getUpassword().equals(upassword)&&user.getUproductlist().equals(i)) */
		if(is_true==null) return 0;
		else {
		 if(/*is_true.equals(i)&&*/password.equals(upassword)) return 1;
		else return 0;
		}
	}
	public User findUserByid(String id1) {
		User user= new User();
		UserDao dao=new UserDao();
		int Uid=Integer.parseInt(id1);
		try {
			user=dao.findUserByid(Uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public int findCount() {
		UserDao dao=new UserDao();
		int count = -1;
		try {
			 count=dao.user_count();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	
	public User findUserByname(String uname) {
		User user= new User();
		UserDao dao=new UserDao();
		try {
			user=dao.findUserByname(uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public List<User> user_find_all(){
		UserDao UserDao = new UserDao();
		List<User> user_all = null;
		try {
			
			user_all = UserDao.user_all();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user_all;
		
	}
	public List<User> user_find_page(int start){
		UserDao UserDao = new UserDao();
		List<User> user_page = null;
		try {
			
			user_page = UserDao.user_page(start,10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user_page;
		
	}

	
//	李
	public User user_find_by_name(String uname) {
		UserDao UserDao = new UserDao();
		User user= null;
		try {
			user = UserDao.user_select(uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public  void user_add(String uname,String password,String contact,String email) {
		UserDao UserDao = new UserDao();
		try {
			UserDao.user_add(uname,password, contact, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  void user_update(int uid,String uname,String password,String contact, String email) {
		UserDao UserDao = new UserDao();
		try {
			UserDao.user_update(uid,uname,password, contact, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public  void user_delete(int uid) {
		UserDao UserDao = new UserDao();
		try {
			UserDao.user_delete(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
