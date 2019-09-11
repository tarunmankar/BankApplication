package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Loan extends HttpServlet {
	private HttpSession session;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	session=request.getSession();
	int accno= (int) session.getAttribute("accno");
	
	try {
 		Model m=new Model();
 		m.setAccno(accno);
 		boolean b=m.applyLoan();
 		if(b==true) {
 			session.setAttribute("name", m.getName());
 			session.setAttribute("email", m.getEmail());
 			response.sendRedirect("/BankApp/LoanSuccess.jsp");
 		}
 		else {
 			response.sendRedirect("/BankApp/LoanFail.html");
 		}
 	}
 	catch(Exception e) {
 		e.printStackTrace();
 	}
  }
}
