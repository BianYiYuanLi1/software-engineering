package com.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.domain.Book;
import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;

@WebServlet("/FindByNameServlet")
public class FindByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BookService service=new BookServiceImpl();
		String bookName=req.getParameter("name");
		String bookWriter=req.getParameter("writer");
		List<Book> list=service.FindBook(bookName,bookWriter);
		req.setAttribute("list", list);
		req.getRequestDispatcher("book/booksingle.jsp").forward(req, res);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
