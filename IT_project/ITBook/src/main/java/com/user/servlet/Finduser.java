package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.Newuser.User;
import com.user.service.Uservice;
import com.user.service.Userviceimp;

/**
 * Servlet implementation class Finduser
 */
@WebServlet("/Finduser")
public class Finduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int id;
		try {
		id=Integer.parseInt(req.getParameter("uid"));//获取输入框内的用户id
		Uservice s=new Userviceimp();
		User user=s.s_search(id);//根据id搜索用户
		
		List<User>u=new ArrayList<>();
		u.add(user);
        req.setAttribute("userlist",u);//将查找到的用户传递到新页面
		req.getRequestDispatcher("usersearch.jsp").forward(req,resp);}//转到输出页面
		catch(NumberFormatException e)//如果搜索框内的信息不规范，则捕获异常，输出错误提示
		{
			req.setAttribute("flag",true);
			req.getRequestDispatcher("/Jmppage").forward(req,resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
