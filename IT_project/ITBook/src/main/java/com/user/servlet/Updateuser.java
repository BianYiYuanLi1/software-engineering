package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.user.Newuser.*;
import com.user.service.Uservice;
import com.user.service.Userviceimp;

/**
 * Servlet implementation class Updateuser
 */
@WebServlet("/Updateuser")
public class Updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		int id = new UpdateTouser().sentid();//通过UpdateTouser获取需要修改的用户id
		User user = new User();
		user.setId(id);
		try {
			int ugrade;
			if(req.getParameter("ugrade")=="" ||Integer.parseInt(req.getParameter("ugrade"))<0)//如果upgrade输入框内无输入，则设默认值为1
				ugrade=1;
			else
				ugrade = Integer.parseInt(req.getParameter("ugrade"));//获取要修改的ugrade
			String uname=req.getParameter("uname"),upwd=req.getParameter("upwd");
			if(uname==""||upwd=="")//如果uname和upwd中有一者的输入框为空，则抛出数据格式不匹配的异常，输出错误提示
				throw new NumberFormatException();
			String uaddr=req.getParameter("uaddr");
			String utel=req.getParameter("utel");
			user.setPassword(upwd);
			user.setUaddress(uaddr);
			user.setUname(uname);
			user.setUtel(utel);
			user.setUgrade(ugrade);
			Uservice s = new Userviceimp();
			s.s_update(user);
			resp.sendRedirect("Jmppage");
		} catch (NumberFormatException e) {//如果格式错误，则跳转到更新界面输出提示并重新输入
			req.setAttribute("flag",true);
			req.setAttribute("id",id);
			req.getRequestDispatcher("user/userupdate.jsp").forward(req,resp);
		}

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
