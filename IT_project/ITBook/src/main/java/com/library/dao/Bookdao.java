package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.library.domain.Book;

public class Bookdao {
/*
 * 根据页数查询图书记录并返回该页面应该有的记录
 */
	public  List<Book> findByPage(int startIndex,int pageSize){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Book> bookList=new ArrayList<Book>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=UTF-8";
			String u ="socktail";
			String p ="Aa999999";
			conn =DriverManager.getConnection(url,u	,p);
			String sql ="select * from book limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, pageSize);
			rs =pstmt.executeQuery();
			while(rs.next()) {
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookPrice(rs.getInt("book_price"));
				book.setBookNum(rs.getInt("book_num"));
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return bookList;
	}
	//查询数据库总记录数传到Servlet计算总页数
	
	public int findAll(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int totalCount=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=UTF-8";
			String u ="socktail";
			String p ="Aa999999";
			conn =DriverManager.getConnection(url,u	,p);
			String sql ="select * from book";
			pstmt = conn.prepareStatement(sql);
			rs =pstmt.executeQuery();
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
	
	/*
	 * 将图书添加到数据库
	 */
	public void addBook(Book book) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=UTF-8";
			String u ="socktail";
			String p ="Aa999999";
			conn =DriverManager.getConnection(url,u	,p);
			String sql ="insert into book(book_name,book_writer,book_price,book_num)values(?,?,?,?);";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getBookWriter());
			pstmt.setInt(3, book.getBookPrice());
			pstmt.setInt(4, book.getBookNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/*
	 * 根据id查询图书
	 */
	public Book FindByBookId(int bookId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Book book=new Book();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=UTF-8";
			String u ="socktail";
			String p ="Aa999999";
			conn =DriverManager.getConnection(url,u	,p);
			String sql ="select * from book where book_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			rs =pstmt.executeQuery();
			while(rs.next()) {
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookPrice(rs.getInt("book_price"));
				book.setBookNum(rs.getInt("book_num"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return book;
		
	}
	
	/*
	 * 修改图书 
	 */
	
	public Book EditBook(Book book) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=UTF-8";
			String u ="socktail";
			String p ="Aa999999";
			conn =DriverManager.getConnection(url,u	,p);
			String sql ="update book set book_name=?,book_writer=?,book_price=?,book_num=? where book_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,book.getBookName());
			pstmt.setString(2, book.getBookWriter());
			pstmt.setInt(3, book.getBookPrice());
			pstmt.setInt(4, book.getBookNum());
			pstmt.setInt(5, book.getBookId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return book;
		
	}
	
	/*
	 * 删除图书记录
	 */
	
	public void DeleteBook(int bookId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=UTF-8";
			String u ="socktail";
			String p ="Aa999999";
			conn =DriverManager.getConnection(url,u	,p);
			String sql="Delete from book where book_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			pstmt.executeUpdate();
			/*String sql1="alter table user AUTO_INCREMENT=1";
			pstmt = conn.prepareStatement(sql1);*/
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	/*
	 * 根据书名或作者查询图书
	 */
	
	public List<Book> FindBook(String bookName,String bookWriter) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Book> list=new ArrayList<Book>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun?characterEncoding=UTF-8";
			String u ="socktail";
			String p ="Aa999999";
			conn =DriverManager.getConnection(url,u	,p);
			String sql ="select * from book where book_name=? or book_writer=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName);
			pstmt.setString(2, bookWriter);
			rs =pstmt.executeQuery();
			while(rs.next()) {
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookPrice(rs.getInt("book_price"));
				book.setBookNum(rs.getInt("book_num"));
				list.add(book);
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
		return list;
	}
}
