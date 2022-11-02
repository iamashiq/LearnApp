import java.io.*;
import java.util.concurrent.TimeUnit;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	
	String name,password;
	PrintWriter printwriter;
	User login;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		printwriter = res.getWriter();
		name = req.getParameter("name");
		password = req.getParameter("password");

		printwriter.write("Checking " + name +"\n\n");
		login = check();
		
		if(login != null)
		{

			
			HttpSession session = req.getSession();
			session.setAttribute("name", login.getName());
			session.setAttribute("phone", login.getPhone());
			
			res.sendRedirect("welcome");
		
		}
		else
		{
			printwriter.write("\n\nlog In failed !");
		}
	}

	public User check() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader( "/Users/ashiq-15825/Desktop/users.txt"))) {
			String line = br.readLine();

			while (line != null) {
				String[] entry = line.split(",");
				if(entry[0].equals(name))
				{
					if(entry[2].equals(password))
					{

						return new User(entry[0],entry[1],entry[2],entry[3]);
					}
					else
					{
						printwriter.write("Wrong password");
						return null;
					}
					
				}
				line = br.readLine();
			}
		}
		printwriter.write("No account found, please create a new account !");
		return null;
	}

}
