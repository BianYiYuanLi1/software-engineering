package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.Newuser.User;
import com.user.service.Uservice;
import com.user.service.Userviceimp;

/**
 * Servlet implementation class UpdateTouser
 */
@WebServlet("/UpdateTouser")
public class UpdateTouser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int id;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//1.查找出要修改的用户的现有信息
		//2.跳转到userupdate界面输入要修改的内容，以现有信息为参照
		id=Integer.parseInt(req.getParameter("id"));//获取要修改的id信息
		Uservice s=new Userviceimp();
		User user=s.s_search(id);//查找该用户的信息
		req.setAttribute("user",user);
		
		req.getRequestDispatcher("user/userupdate.jsp").forward(req,resp);//跳转到更新页面
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public int sentid()
	{
		return id;//保存初始的id值
	}
}
