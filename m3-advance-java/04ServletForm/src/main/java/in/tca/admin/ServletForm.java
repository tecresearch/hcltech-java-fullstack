package in.tca.admin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitForm")
public class ServletForm extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		out.print(
			    "<!DOCTYPE html>" +
			    "<html>" +
			    "<head>" +
			    "<meta charset='UTF-8'>" +
			    "<title>Room Created</title>" +
			    "<style>" +
			    "body {" +
			    "    font-family: Arial, sans-serif;" +
			    "    background-color: #f4f4f4;" +
			    "    display: flex;" +
			    "    justify-content: center;" +
			    "    align-items: center;" +
			    "    height: 100vh;" +
			    "    margin: 0;" +
			    "}" +
			    ".container {" +
			    "    background-color: #fff;" +
			    "    padding: 20px;" +
			    "    border: 1px solid #ccc;" +
			    "    border-radius: 10px;" +
			    "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);" +
			    "    text-align: center;" +
			    "}" +
			    ".container h1 {" +
			    "    color: #333;" +
			    "}" +
			    ".container h3 {" +
			    "    color: #555;" +
			    "}" +
			    "</style>" +
			    "</head>" +
			    "<body>" +
			    "<div class='container'>" +
			    "<h3>Room Created</h3>" +
			    "<hr>" +
			    "<h5>Name: " + name + "</h5>" +
			    "<h5>Email: " + email + "</h>" +
			    "</div>" +
			    "</body>" +
			    "</html>"
		);		
	}
	
}

