package com.sale.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sale.domain.BookRank;
import com.sale.domain.Sales;
import com.sale.service.BookRankService;
import com.sale.service.SalesService;
import com.sale.service.impl.BookRankServiceImpl;
import com.sale.service.impl.SalesServiceImpl;

/**
 * Servlet implementation class ChartServlet
 */
@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet {

	/**
	 * 获取近7天的销售额和销售量，用于制作统计图
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//销售额统计表
		SalesService sales = new SalesServiceImpl();
		List<Sales> saleslist = sales.seven();
		String[] date = new String[7];//保存近7天的日期
		int[] income = new int[7];//保存近7天的销售额
		int d=Math.min(7, saleslist.size());
		for (int i = 0; i < d; i++) {
			date[i] = saleslist.get(i).getDate();//获取近7天的日期
			income[i] = saleslist.get(i).getIncome();//获取近7天的销售额
		}
		//传日期
		req.setAttribute("date1", date[0]);
		req.setAttribute("date2", date[1]);
		req.setAttribute("date3", date[2]);
		req.setAttribute("date4", date[3]);
		req.setAttribute("date5", date[4]); 
		req.setAttribute("date6", date[5]);
		req.setAttribute("date7", date[6]); 
		//传日销售额
		req.setAttribute("income1", income[0]);
		req.setAttribute("income2", income[1]);
		req.setAttribute("income3", income[2]);
		req.setAttribute("income4", income[3]);
		req.setAttribute("income5", income[4]);
		req.setAttribute("income6",income[5]); 
		req.setAttribute("income7", income[6]);
		 
		//Chart2销售量统计表
		 BookRankService books = new BookRankServiceImpl();
		List<BookRank> bookslist = books.findseven();
		int[] num = new int[7];
		for (int i = 0; i < d; i++) {
			num[i] = bookslist.get(i).getNumber();
		}
		//传日销售量
		req.setAttribute("num1", num[0]);
		req.setAttribute("num2", num[1]);
		req.setAttribute("num3", num[2]);
		req.setAttribute("num4", num[3]);
		req.setAttribute("num5", num[4]);
		req.setAttribute("num6",num[5]); 
		req.setAttribute("num7", num[6]);
			 
		// 请求转发
		req.getRequestDispatcher("sale/p2.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
