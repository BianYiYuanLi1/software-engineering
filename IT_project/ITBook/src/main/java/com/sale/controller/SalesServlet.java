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
	 * ����ĳһ������۶�
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SalesService sales = new SalesServiceImpl();
		String date = req.getParameter("date");//��ȡ����ѯ������
		if(date !=null && !"".equals(date)) {
			req.setAttribute("totalCount", 1);
			req.setAttribute("totalPage", 1);
			req.setAttribute("pageCur1", 1);
			List<Sales> saleslist1 = sales.findOne(date);//�ҵ������ڵ����۶��¼
			req.setAttribute("list", saleslist1);
		}else {
			String pageCur = req.getParameter("pageCur");//��ȡҳ�洫���ĵ�ǰҳ��
			int pageCur1 = 0;
			if(pageCur == null) {
				pageCur1 = 1;
			}else {
				pageCur1 = Integer.parseInt(pageCur);
			}
			int totalPage = 0 ;
			int pageSize = 10;//ÿҳ��¼��
			int totalCount = sales.findAll();//��ȡ�ܼ�¼��
			if(totalCount == 0) {
				totalPage = 0;
			}else {
				totalPage = (int)Math.ceil((double)totalCount/pageSize);//����ҳ��
			}
			int startIndex = (pageCur1 -1)*10;
			
			List<Sales> saleslist2 = sales.findByPage(startIndex, pageSize);
			req.setAttribute("totalCount", totalCount);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("pageCur1", pageCur1);
			req.setAttribute("list", saleslist2);
		}
		//����ת��

		req.getRequestDispatcher("sale/p1.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
