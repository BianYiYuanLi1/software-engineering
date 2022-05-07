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

@WebServlet("/DeleteSevlet")
public class DeleteSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int bookId=Integer.parseInt(req.getParameter("bookId"));
		BookService service=new BookServiceImpl();
		service.DeleteBook(bookId);
		req.getRequestDispatcher("booklistservlet").forward(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
