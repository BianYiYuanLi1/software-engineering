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

@WebServlet("/Addbookservlet")
public class Addbookservlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name=req.getParameter("bookName");
		String writer=req.getParameter("bookWriter");
		String price=req.getParameter("bookPrice");
		String num=req.getParameter("bookNum");
		if(name!=""&&writer!=""&&price!=""&&num!=""&&Integer.parseInt(price)>0&&Integer.parseInt(num)>0) {
			Book book=new Book();
			book.setBookName(name);
			book.setBookWriter(writer);
			book.setBookPrice(Integer.parseInt(price));
			book.setBookNum(Integer.parseInt(num));
			BookService service=new BookServiceImpl();
			service.addBook(book);
			res.sendRedirect(req.getContextPath()+"/booklistservlet");
		}
		else {
			req.getRequestDispatcher("book/book_add_wrong.jsp").forward(req, res);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
