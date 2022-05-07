package com.order.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.order.domain.Order;


public class OrderDao {

	public List<Order> findAll()
	{
		List<Order> orderList=new ArrayList<Order>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1 加载数据驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url,u,p);
			
			String sql = "select * from order_table";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setCreate_time(rs.getString("create_time"));
				order.setBook_id(rs.getInt("book_id"));
				order.setNumbers(rs.getInt("numbers"));
				order.setUser_id(rs.getInt("user_id"));
				order.setPrices(rs.getInt("prices"));
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6 关闭连接
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}
	public List<Order> findByPage(int startIndex, int pageSize)
	{
		List<Order> orderList=new ArrayList<Order>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1 加载数据驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url,u,p);
			
			String sql = "select * from order_table limit ? , ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setCreate_time(rs.getString("create_time"));
				order.setBook_id(rs.getInt("book_id"));
				order.setNumbers(rs.getInt("numbers"));
				order.setUser_id(rs.getInt("user_id"));
				order.setPrices(rs.getInt("prices"));
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6 关闭连接
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}
	
    private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//添加订单
	public void add_list(int bookid,int userid,int numbe)
	{	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//1 加载数据驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url,u,p);
			
			String sql="select * from book where book_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			rs = pstmt.executeQuery();
			int prices=0;
			int cnt=0;
			while(rs.next())
			{
				prices=Integer.parseInt(rs.getString("book_price"));
				cnt=Integer.parseInt(rs.getString("book_num"));
			}
			System.out.println(prices+" "+cnt);
			
			sql = "insert into order_table values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid*1000+userid*100+numbe);
			Date date=new Date();
			pstmt.setString(2,sdf.format(date));
			pstmt.setInt(3, bookid);
			pstmt.setInt(4, userid);
			pstmt.setInt(5, prices*numbe);
			pstmt.setInt(6, numbe);
		    pstmt.executeUpdate();
		    
		    sql="update book set book_num=? where book_id=?";
		    pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cnt-numbe);
			pstmt.setInt(2,bookid);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6 关闭连接
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
