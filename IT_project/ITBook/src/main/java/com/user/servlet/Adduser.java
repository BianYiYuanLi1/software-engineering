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
 * Servlet implementation class Adduser
 */
@WebServlet("/Adduser")
public class Adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		User user = new User();
		boolean f = true;
		try {
			int ugrade;
			if (req.getParameter("ugrade") == "" || Integer.parseInt(req.getParameter("ugrade")) < 0)
				ugrade = 1;
			else
				ugrade = Integer.parseInt(req.getParameter("ugrade"));
			String uname = req.getParameter("uname"), upwd = req.getParameter("upwd");
			if (uname == "" || upwd == "")
				throw new Exception();
			user.setUname(uname);
			user.setPassword(upwd);
			user.setUtel(req.getParameter("utel"));
			user.setUaddress(req.getParameter("uaddr"));
			user.setUgrade(ugrade);
			Uservice a = new Userviceimp();
			a.s_add(user);
		} catch (Exception e)// 如果输入的数据类型不匹配则重新跳转到本页面提示重新输入
		{
			f = false;
			req.setAttribute("flag", true);
			req.getRequestDispatcher("useradd.jsp").forward(req, resp);
		}
		if (f)
			resp.sendRedirect("Jmppage");// 如果输入的数据类型正确则跳转到Jmppage全部显示
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
