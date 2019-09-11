package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	    private HttpSession session;
	    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String custid= request.getParameter("custid");
		String pwd= request.getParameter("pwd");
	
	try {
		Model m=new Model();
		m.setCustid(custid);
		m.setPwd(pwd);
		boolean b=m.login();
		if(b==true) {
			session.setAttribute("accno", m.getAccno());
			response.sendRedirect("/BankApp/Home.html");
		}
		else {
			response.sendRedirect("/BankApp/ErrorLogin.html");
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
  }
}