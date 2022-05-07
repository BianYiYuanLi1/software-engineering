package com.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.domain.Order;
import com.order.service.OrderService;
import com.order.service.Serviceimpl;


/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderService orderService = new Serviceimpl();
		resp.setContentType("text/html;charset=utf-8");
		//转发
		
		String pageCur = req.getParameter("pageCur");//获取当前所在页数
		int pageCur1 = 0;
		if(pageCur == null) {
			pageCur1 = 1;
		}else {
			pageCur1 = Integer.parseInt(pageCur);
		}
		int totalPage = 0 ;//总页数
		int pageSize = 10;//每页记录数
		int totalCount = orderService.findAll().size();//总记录数
		if(totalCount == 0) {
			totalPage = 0;
		}else {
			totalPage = (int)Math.ceil((double)totalCount/pageSize);//计算总页数
		}
		int startIndex = (pageCur1 -1)*10;
		List<Order> list = orderService.findByPage(startIndex, pageSize);
		req.setAttribute("totalCount", totalCount);//传总记录数
		req.setAttribute("totalPage", totalPage);//传总页数
		req.setAttribute("pageCur1", pageCur1);//传当前页数
		req.setAttribute("list", list);//传每页的表
		req.getRequestDispatcher("order/orderList.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
