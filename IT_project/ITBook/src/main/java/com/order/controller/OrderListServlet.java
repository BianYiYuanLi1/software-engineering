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
		//ת��
		
		String pageCur = req.getParameter("pageCur");//��ȡ��ǰ����ҳ��
		int pageCur1 = 0;
		if(pageCur == null) {
			pageCur1 = 1;
		}else {
			pageCur1 = Integer.parseInt(pageCur);
		}
		int totalPage = 0 ;//��ҳ��
		int pageSize = 10;//ÿҳ��¼��
		int totalCount = orderService.findAll().size();//�ܼ�¼��
		if(totalCount == 0) {
			totalPage = 0;
		}else {
			totalPage = (int)Math.ceil((double)totalCount/pageSize);//������ҳ��
		}
		int startIndex = (pageCur1 -1)*10;
		List<Order> list = orderService.findByPage(startIndex, pageSize);
		req.setAttribute("totalCount", totalCount);//���ܼ�¼��
		req.setAttribute("totalPage", totalPage);//����ҳ��
		req.setAttribute("pageCur1", pageCur1);//����ǰҳ��
		req.setAttribute("list", list);//��ÿҳ�ı�
		req.getRequestDispatcher("order/orderList.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
