package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePwd extends HttpServlet {
	private HttpSession session;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String pwd=request.getParameter("npwd");
	session=request.getSession();
	int accno=(int) session.getAttribute("accno");
	
	try {
 		Model m=new Model();
 		m.setPwd(pwd);
 		m.setAccno(accno);
 		boolean b=m.changePwd();
 		if(b==true) {
 			response.sendRedirect("/BankApp/ChangeSuccess.html");
 		}
 		else {
 			response.sendRedirect("/BankApp/ChangeFailed.html");
 		}
	}
 		catch(Exception e) {
 	 		e.printStackTrace();
 	 	}
	}
}
