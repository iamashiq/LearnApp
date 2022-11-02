import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.getSession().removeAttribute("name");
		req.getSession().removeAttribute("phone");

		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
		dispatcher.forward(req, res);
	}

}
