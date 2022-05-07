package com.library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.domain.Book;
import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;

@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int bookId=Integer.parseInt(req.getParameter("bookId"));
		String bookName=req.getParameter("bookName");
		String bookWriter=req.getParameter("bookWriter");
		int bookPrice=Integer.parseInt(req.getParameter("bookPrice"));
		int bookNum=Integer.parseInt(req.getParameter("bookNum"));
		if(bookPrice>0&&bookNum>0) {
				Book book=new Book();
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setBookWriter(bookWriter);
		book.setBookPrice(bookPrice);
		book.setBookNum(bookNum);
		BookService service=new BookServiceImpl();
		service.EditBook(book);
		req.getRequestDispatcher("booklistservlet").forward(req, res);
		}else {
			req.getRequestDispatcher("book/book_edit_wrong.jsp").forward(req, res);
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
