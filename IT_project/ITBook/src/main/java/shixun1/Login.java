package shixun1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest reqs, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println(resq.getParameter("username"));
		String lic[]=new String[2];
		String li[] =new String[2];
		lic[0]="UserName";lic[1]="pawd";
		li[0]=reqs.getParameter("username");
		li[1]=reqs.getParameter("password");
		String tab="userinfo";
//		System.out.println(li[0]+"   "+li[1]);
		if(CheckItem.getItem(lic, li, tab)) 
			resp.sendRedirect("index.jsp");
		else resp.sendRedirect("login.html");
		resp.getWriter().append("Served at: ").append(reqs.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
