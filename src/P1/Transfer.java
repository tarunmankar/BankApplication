package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Transfer extends HttpServlet {
	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acc=request.getParameter("accno1");
		Integer i=Integer.parseInt(acc);
		int accno1=i.intValue();
		session=request.getSession();
		String bal=request.getParameter("amount");
		Integer i1=Integer.parseInt(bal);
		int amount=i1.intValue();
		int accno= (int) session.getAttribute("accno");
		try {
	 		Model m=new Model();
	 		m.setAccno1(accno1);
	 		m.setAccno(accno);
	 		m.setBalance(amount);
	 		boolean b=m.transfer();
	 		if(b==true) {
	 			session.setAttribute("name", m.getName());
	 			session.setAttribute("amount", m.getBalance());
	 			response.sendRedirect("/BankApp/TransferSuccess.html");
	 		}
	 		else {
	 			response.sendRedirect("/BankApp/TransferFailed.html");
	 		}
	 	}
	 	catch(Exception e) {
	 		e.printStackTrace();
	 	}
	}
}
