package shixun1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String li[]=new String[3];
		li[1]=req.getParameter("username");
		li[2]=req.getParameter("password");
		li[0]=req.getParameter("repassword");
		if(li[0].equalsIgnoreCase(li[2])==false) 
			resp.sendRedirect("register.html?wrongPassWord=1");
		CheckItem.regisUser(li[1],li[2]);
		resp.sendRedirect("login.html");
	}

}
