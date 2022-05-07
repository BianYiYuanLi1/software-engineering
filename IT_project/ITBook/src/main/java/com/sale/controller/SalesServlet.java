package com.sale.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sale.domain.Sales;
import com.sale.service.SalesService;
import com.sale.service.impl.SalesServiceImpl;

/**
 * Servlet implementation class OneSaleServlet
 */
@WebServlet("/SalesServlet")
public class SalesServlet extends HttpServlet {
	/**
	 * 搜索某一天的销售额
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SalesService sales = new SalesServiceImpl();
		String date = req.getParameter("date");//获取所查询的日期
		if(date !=null && !"".equals(date)) {
			req.setAttribute("totalCount", 1);
			req.setAttribute("totalPage", 1);
			req.setAttribute("pageCur1", 1);
			List<Sales> saleslist1 = sales.findOne(date);//找到该日期的销售额记录
			req.setAttribute("list", saleslist1);
		}else {
			String pageCur = req.getParameter("pageCur");//获取页面传来的当前页数
			int pageCur1 = 0;
			if(pageCur == null) {
				pageCur1 = 1;
			}else {
				pageCur1 = Integer.parseInt(pageCur);
			}
			int totalPage = 0 ;
			int pageSize = 10;//每页记录数
			int totalCount = sales.findAll();//获取总记录数
			if(totalCount == 0) {
				totalPage = 0;
			}else {
				totalPage = (int)Math.ceil((double)totalCount/pageSize);//计算页数
			}
			int startIndex = (pageCur1 -1)*10;
			
			List<Sales> saleslist2 = sales.findByPage(startIndex, pageSize);
			req.setAttribute("totalCount", totalCount);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("pageCur1", pageCur1);
			req.setAttribute("list", saleslist2);
		}
		//请求转发

		req.getRequestDispatcher("sale/p1.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
