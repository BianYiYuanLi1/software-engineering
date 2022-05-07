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

//图书列表功能
@WebServlet("/booklistservlet")
public class Booklistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//设置字符串编码，防止页面出现乱码
		BookService service =new BookServiceImpl();
		String pageCur=req.getParameter("pageCur");//传回来的页数值
		int pageCur1=0;//当前页面的值
		//对传回来的页数值进行判断,如果是第一次进入界面，则传回来的页数为空，此时是首页，将pageCur1的值设置为1
		if(pageCur==null) {
			pageCur1=1;
		}
		else {
			pageCur1=Integer.parseInt(pageCur);
		}
		//totalPage为总页数，pageSize为每页的数据条数，totalCount为总数据条数,
		int totalPage=0;
		int pageSize=10;
		int totalCount=service.findAll();
		if(totalCount==0) {
			totalPage=0;
		}
		//计算总页数，用总记录数除以每一页的记录数得到总页数
		else {
			totalPage=(int)Math.ceil((double) totalCount/pageSize);
		}

		//从startIndex开始查询，用当前页数减1（即当前页以前）乘每页的记录数，得到开始查询的标记数
		int startIndex=(pageCur1-1)*pageSize;
		List <Book> booklist=service.findByPage(startIndex, pageSize);//调用接口的findByPage实现来获取当前页面的图书记录
		req.setAttribute("booklist", booklist);//使用setAttribute方法获取booklist的值
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("pageCur1", pageCur1);
		req.getRequestDispatcher("book/booklist.jsp").forward(req, res);//getRequestDispatcher方法跳转到参数的界面，forward将参数带过去
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
