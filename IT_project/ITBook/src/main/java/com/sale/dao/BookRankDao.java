package com.sale.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.sale.domain.BookRank;


public class BookRankDao {

	/**
	 * ��ѯָ�������ڣ�ÿ��ͼ�����������ͳ�Ƽ�¼��������
	 * @return
	 */
	public int findAll(String date){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCount = 0;//ͳ�Ƽ�¼��
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url,u,p);
			String sql = null;
			if(date == null) {
				sql="select SUM(numbers) from order_table group by book_id ";
			}else if(date.equals("today")) {
				sql="select SUM(numbers) from order_table WHERE TO_DAYS(create_time) = TO_DAYS(NOW()) group by book_id ";
			}else if(date.equals("week")) {
				sql="select SUM(numbers) from order_table WHERE DATE_SUB(CURDATE(),INTERVAL 7 DAY)<=DATE(create_time) group by book_id";
			}else if(date.equals("month")) {
				sql="select SUM(numbers) from order_table WHERE DATE_SUB(CURDATE(),INTERVAL 7 DAY)<=DATE(create_time) group by book_id";
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				totalCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalCount;
	}
	
	/**
	 * 
	 * ��ҳ��ѯָ�������ڣ�ÿ��ͼ���������
	 */
	public ArrayList<BookRank> findByPage(int startIndex,int pageSize,String date){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BookRank> bookList =  new ArrayList<BookRank>();//�����ѯ���ļ�¼
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url,u,p);
			String sql = null;
			if(date == null) {
				sql="select book.book_id, book_name,SUM(numbers) from order_table,book "
					+ "where order_table.book_id = book.book_id group by book_id order by SUM(numbers) desc limit ? ,?";
			}else if(date.equals("today")) {
				sql="select book.book_id, book_name,SUM(numbers) from order_table,book "
						+ "WHERE order_table.book_id = book.book_id and TO_DAYS(create_time) = TO_DAYS(NOW()) "
						+ "group by book_id order by SUM(numbers) desc limit ? ,?";
			}else if(date.equals("week")) {
				sql="select book.book_id, book_name,SUM(numbers) from order_table,book "
						+ "WHERE order_table.book_id = book.book_id and DATE_SUB(CURDATE(),INTERVAL 7 DAY)<=DATE(create_time) "
						+ "group by book_id order by SUM(numbers) desc limit ? ,?";
			}else if(date.equals("month")) {
				sql="select book.book_id, book_name,SUM(numbers) from order_table,book "
						+ "WHERE order_table.book_id = book.book_id and DATE_SUB(CURDATE(),INTERVAL 7 DAY)<=DATE(create_time) "
						+ "group by book_id order by SUM(numbers) desc limit ? ,?";
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();//�����
			while(rs.next()) {
				BookRank book = new BookRank();
				book.setId(rs.getInt("book_id"));//���ͼ��id
				book.setBookname(rs.getString("book_name"));//���ͼ������
				book.setNumber(rs.getInt("SUM(numbers)"));//���ͼ��������
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;
	}
	
	/**
	 * ��ѯ���7�죬ÿ���ͼ��������
	 * @return
	 */
	
	public ArrayList<BookRank> findseven(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookRank> bookList = new ArrayList<>();//�����¼
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
			String u = "socktail";
			String p = "Aa999999";
			conn = DriverManager.getConnection(url,u,p);
			String sql =" select SUM(numbers),DATE_FORMAT(create_time,'%Y-%m-%d') time "
					+ "from order_table group by DATE_FORMAT(create_time,'%Y-%m-%d')  "
					+ "order by DATE_FORMAT(create_time,'%Y-%m-%d') desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookRank book = new BookRank();
				book.setDate(rs.getString("time"));//������ڣ�������
				book.setNumber(rs.getInt("SUM(numbers)"));//���ͼ���ܵ�������
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;
	}
}
