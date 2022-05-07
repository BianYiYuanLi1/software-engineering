package com.sale.controller;

import java.io.IOException;
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
 * Servlet implementation class BookRankListServlet
 */
@WebServlet("/BookRankListServlet")
public class BookRankListServlet extends HttpServlet {
	/**
	 * ͼ���ܵ����а�
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookRankService bookrank = new BookRankServiceImpl();
		String date = null;
		String pageCur = req.getParameter("pageCur");//��ȡ��ǰ����ҳ��
		int pageCur1 = 0;
		if(pageCur == null) {
			pageCur1 = 1;
		}else {
			pageCur1 = Integer.parseInt(pageCur);
		}
		int totalPage = 0 ;//��ҳ��
		int pageSize = 10;//ÿҳ��¼��
		int totalCount = bookrank.findAll(date);//�ܼ�¼��
		if(totalCount == 0) {
			totalPage = 0;
		}else {
			totalPage = (int)Math.ceil((double)totalCount/pageSize);//������ҳ��
		}
		int startIndex = (pageCur1 -1)*10;
		
		List<BookRank> bookranklist = bookrank.findByPage(startIndex, pageSize, date);
		req.setAttribute("totalCount", totalCount);//���ܼ�¼��
		req.setAttribute("totalPage", totalPage);//����ҳ��
		req.setAttribute("pageCur1", pageCur1);//����ǰҳ��
		req.setAttribute("bookranklist", bookranklist);//��ÿҳ�ı�
		int index = pageSize * (pageCur1-1);//��¼�������Ա���һҳ��������
		req.setAttribute("index", index);
		//����ת��
		req.getRequestDispatcher("sale/p3.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
