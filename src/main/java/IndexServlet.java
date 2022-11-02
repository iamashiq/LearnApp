import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class IndexServlet extends HttpServlet {
	
	String username;
	User data;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, res);
	}
}
