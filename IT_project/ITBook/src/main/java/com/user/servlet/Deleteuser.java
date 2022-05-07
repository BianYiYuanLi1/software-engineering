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
 * Servlet implementation class Deleteuser
 */
@WebServlet("/Deleteuser")
public class Deleteuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(req.getParameter("id"));//获取要删除的用户id值
		Uservice s=new Userviceimp();
		s.s_delete(id);//根据id连接数据库删除用户
		resp.sendRedirect("Jmppage");//跳转到输出页面
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
