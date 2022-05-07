package com.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.service.OrderService;
import com.order.service.Serviceimpl;


/**
 * Servlet implementation class OrderAdd
 */
@WebServlet("/OrderAddServlet")
public class OrderAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int bookid=Integer.valueOf(req.getParameter("bookid"));
		int userid=Integer.valueOf(req.getParameter("userid"));
		int numbe=Integer.valueOf(req.getParameter("number"));
		OrderService service=new Serviceimpl();
		service.add_list(bookid,userid,numbe);
		//×ª·¢
		req.getRequestDispatcher("order/order_add.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}