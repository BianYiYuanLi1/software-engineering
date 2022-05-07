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

/**
 * Servlet implementation class booklistservlet
 */

//ͼ���б���
@WebServlet("/booklistservlet")
public class Booklistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//�����ַ������룬��ֹҳ���������
		BookService service =new BookServiceImpl();
		String pageCur=req.getParameter("pageCur");//��������ҳ��ֵ
		int pageCur1=0;//��ǰҳ���ֵ
		//�Դ�������ҳ��ֵ�����ж�,����ǵ�һ�ν�����棬�򴫻�����ҳ��Ϊ�գ���ʱ����ҳ����pageCur1��ֵ����Ϊ1
		if(pageCur==null) {
			pageCur1=1;
		}
		else {
			pageCur1=Integer.parseInt(pageCur);
		}
		//totalPageΪ��ҳ����pageSizeΪÿҳ������������totalCountΪ����������,
		int totalPage=0;
		int pageSize=10;
		int totalCount=service.findAll();
		if(totalCount==0) {
			totalPage=0;
		}
		//������ҳ�������ܼ�¼������ÿһҳ�ļ�¼���õ���ҳ��
		else {
			totalPage=(int)Math.ceil((double) totalCount/pageSize);
		}

		//��startIndex��ʼ��ѯ���õ�ǰҳ����1������ǰҳ��ǰ����ÿҳ�ļ�¼�����õ���ʼ��ѯ�ı����
		int startIndex=(pageCur1-1)*pageSize;
		List <Book> booklist=service.findByPage(startIndex, pageSize);//���ýӿڵ�findByPageʵ������ȡ��ǰҳ���ͼ���¼
		req.setAttribute("booklist", booklist);//ʹ��setAttribute������ȡbooklist��ֵ
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("pageCur1", pageCur1);
		req.getRequestDispatcher("book/booklist.jsp").forward(req, res);//getRequestDispatcher������ת�������Ľ��棬forward����������ȥ
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
