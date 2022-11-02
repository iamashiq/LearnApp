import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CreateServlet extends HttpServlet {

	String userData, name,fname, password, phone;
	PrintWriter printwriter;
	User candidate;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		printwriter = res.getWriter();
		name = req.getParameter("name");
		fname = req.getParameter("fname");
		password = req.getParameter("password");
		phone = req.getParameter("phone");


		candidate = check();
		
		if(candidate == null)
		{
			writeUser();
			printwriter.write("Account created, Please login");
		}
		else
		{
			printwriter.write("Create failed");
		}
		
	}

	private void writeUser() throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(new File("/Users/ashiq-15825/Desktop/users.txt"), true));
		
		writer.append(System.lineSeparator());
		writer.append(name+","+fname+","+password+","+phone);

		writer.close();

	}

	public User check() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/ashiq-15825/Desktop/users.txt"))) {
			String line = br.readLine();

			while (line != null) {
				String[] entry = line.split(",");
				if (entry[0].equals(name)) {
					printwriter.write("Username is taken, please try a new name !");
					return new User(entry[0], entry[1], entry[2],entry[3]);

				}
				line = br.readLine();
			}
		}
		return null;
	}
}