package com.sale.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sale.domain.BookRank;
import com.sale.service.BookRankService;
import com.sale.service.impl.BookRankServiceImpl;

/**
 * Servlet implementation class DaySalesServlet
 */
@WebServlet("/DayServlet")
public class DayServlet extends HttpServlet {
	/**
	 * 本日图书销售排行榜
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookRankService bookrank = new BookRankServiceImpl();
		String date = "today";
		String pageCur = req.getParameter("pageCur");//获取当前所在页数
		int pageCur1 = 0;
		if(pageCur == null) {
			pageCur1 = 1;
		}else {
			pageCur1 = Integer.parseInt(pageCur);
		}
		int totalPage = 0 ;//总页数
		int pageSize = 5;//每页记录数
		int totalCount = bookrank.findAll(date);//总记录数
		if(totalCount == 0) {
			totalPage = 0;
		}else {
			totalPage = (int)Math.ceil((double)totalCount/pageSize);//计算总页数
		}
		int startIndex = (pageCur1 -1)*5;
		
		List<BookRank> bookranklist = bookrank.findByPage(startIndex, pageSize, date);
		req.setAttribute("totalCount", totalCount);//传总记录数
		req.setAttribute("totalPage", totalPage);//传总页数
		req.setAttribute("pageCur1", pageCur1);//传当前页数
		req.setAttribute("bookranklist", bookranklist);//传每页的表
		//请求转发
		req.getRequestDispatcher("sale/p3.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
