package com.user.servlet;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.Newuser.User;
import com.user.service.Uservice;
import com.user.service.Userviceimp;

/**
 * Servlet implementation class Jmppage
 */
@WebServlet("/Jmppage")
public class Jmppage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Uservice s=new Userviceimp();
		int count=s.s_num();//查询数据库记录总数
		int currentpage=0;//页面将要显示的页数
		System.out.println(req.getParameter("topage"));
		if(req.getParameter("topage")==null||req.getParameter("topage")=="")//当打开页面时输入框无输入时，此时为第一页
			currentpage=1;
		else
			currentpage=Integer.parseInt(req.getParameter("topage"));//当输入框有跳转页面时，将要显示的时跳转后的页面
		int totalpage;//总页数
		int pnum=5;//每页显示5个用户
		if(count==0)//当总页数为0
			totalpage=0;
		else
			totalpage=(int)Math.ceil(count*1.0/pnum);//计算总页数
		
		int start=(currentpage-1)*pnum;
		List<User>userlist=s.s_page(start,pnum);
	    req.setAttribute("pnum", pnum);//传入总页数
		req.setAttribute("userlist",userlist);//跳转的下一页内容
		req.setAttribute("currentpage",currentpage);//将要显示的页数
		req.setAttribute("totalpage",totalpage);//总页数
		req.getRequestDispatcher("user/totaluser.jsp").forward(req,resp);//跳转到输出界面
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
