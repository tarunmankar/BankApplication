package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Credential1 extends HttpServlet {
	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		String email=(String) session.getAttribute("email");
		String npwd=request.getParameter("npwd");
		
		try {
	 		Model m=new Model();
	 		m.setEmail(email);
	 		m.setPwd(npwd);
	 		boolean b=m.forgetPwd();
	 		if(b==true) {
	 			response.sendRedirect("/BankApp/Success1.html");
	 		}
	 		else {
	 			response.sendRedirect("/BankApp/failed1.html");
	 		}
		}
	 		catch(Exception e) {
	 	 		e.printStackTrace();
	 	 	}
		
	}
	

}
