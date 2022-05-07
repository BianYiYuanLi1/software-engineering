package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.user.Newuser.*;

public class UDao {
     /**1.连接数据库
      * 2.编写sql语句并执行
      * 3.如果有执行结果则返回执行结果
      */
	
	

	/**
	 * 根据id查询用户
	 * 
	 * @param username 用户名
	 * @param pwd      密码
	 * @return
	 */
	public User u_search(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url ="jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=utf-8";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url, u, p);

			String sql = "select* from user where user_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("user_id"));
				user.setUname(rs.getString("user_name"));
				user.setPassword(rs.getString("user_pwd"));
				user.setUgrade(rs.getInt("user_grade"));
				user.setUtel(rs.getString("user_tel"));
				user.setUaddress(rs.getString("user_addr"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6 关闭连接

			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	/**
	 * 查询所有用户的信息
	 * 
	 * @return
	 */
	public List<User> u_findAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=utf-8";
			String user = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url, user, p);

			String sql = "select*from user";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("user_id"));
				u.setUname(rs.getString("user_name"));
				u.setPassword(rs.getString("user_pwd"));
				u.setUgrade(rs.getInt("user_grade"));
				u.setUtel(rs.getString("user_tel"));
				u.setUaddress(rs.getString("user_addr"));
				userList.add(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();//关闭连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userList;
	}

	
	/**
	 * 添加用户
	 */
	public void u_add(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=utf-8";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url, u, p);
			String sql = "insert into user(user_name,user_pwd,user_tel,user_addr,user_grade)"
					+ "values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getUtel());
			pstmt.setString(4, user.getUaddress());
			pstmt.setInt(5, user.getUgrade());
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {

				pstmt.close();
				conn.close();//关闭连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

	/**
	 * 更新用户信息
	 */
	public void u_update(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=utf-8";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url, u, p);
			String sql = "update user set user_grade=?,user_tel=?,user_addr=?,user_pwd=?,user_name=? where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUgrade());
			pstmt.setString(2,user.getUtel());
			pstmt.setString(3,user.getUaddress());
			pstmt.setString(4,user.getPassword());
			pstmt.setString(5,user.getUname());
			pstmt.setInt(6, user.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();//关闭连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 删除用户
	 */
	public void u_delete(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=utf-8";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url, u, p);
			String sql = "delete from user where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			sql = "alter table user AUTO_INCREMENT=1";//设置自动递增的初始值
			ps = conn.prepareStatement(sql);
			ps.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				ps.close();
				conn.close();//关闭连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 分页
	 * 1、获得数据库记录总数
	 * 2、一页显示五个人
	 * 3、下一页、上一页、首页、末页、跳转页面
	 */
	public int u_num() {
		Connection conn = null;
		Statement pstmt = null;
		
		ResultSet rs = null;
		int count=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=utf-8";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url, u, p);
			String sql = "select count(*)u from user";
			pstmt= conn.createStatement();
			rs=pstmt.executeQuery(sql);
			while(rs.next())
				count=rs.getInt("u");
			
           
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();//关闭连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return count;
	}
	
	
	//返回数据库中从start开始的end行记录
	public List<User> u_page(int start,int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User>list=new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=utf-8";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url, u, p);
			String sql = "select*  from user limit ?,?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1,start);
			pstmt.setInt(2,end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
			    User user=new User();
				user.setId(rs.getInt("user_id"));
				user.setUname(rs.getString("user_name"));
				user.setPassword(rs.getString("user_pwd"));
				user.setUgrade(rs.getInt("user_grade"));
				user.setUtel(rs.getString("user_tel"));
				user.setUaddress(rs.getString("user_addr"));
				list.add(user);
				
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();//关闭连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
}
