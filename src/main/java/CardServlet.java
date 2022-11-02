import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CardServlet extends HttpServlet {
	
	String username;
	User data;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		HttpSession session =req.getSession();
		username = session.getAttribute("name")+"";
		
		data = fetch();
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("card.jsp");
		req.setAttribute("name", data.getName());
		req.setAttribute("fname", data.getFname());
		req.setAttribute("phone", data.getPhone());
		
		dispatcher.forward(req, res);
		
		
		
		
	}
	
	public User fetch() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/ashiq-15825/Desktop/users.txt"))) {
			String line = br.readLine();

			while (line != null) {
				String[] entry = line.split(",");
				if (entry[0].equals(username)) {
					System.out.println("Logx : "+ line);
					return new User(entry[0], entry[1], entry[2],entry[3]);

				}
				line = br.readLine();
			}
		}
		return null;
	}

}
