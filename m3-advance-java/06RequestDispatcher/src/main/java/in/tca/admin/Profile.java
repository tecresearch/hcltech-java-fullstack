package in.tca.admin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/myProfile")
public class Profile extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String userid=req.getParameter("userid");
		String password=req.getParameter("password");
		resp.setContentType("text/html");

        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("<meta charset='UTF-8'>");
        out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("<title>Dashboard</title>");
        out.print("<style>");
        out.print("body { font-family: Arial, sans-serif; }");
        out.print("nav { background-color: #333; overflow: hidden; }");
        out.print("nav ul { list-style-type: none; margin: 0; padding: 0; display: flex; align-items: center; }");
        out.print("nav ul li { margin: 0; padding: 0; }");
        out.print("nav ul li a { display: block; color: white; text-align: center; padding: 14px 20px; text-decoration: none; }");
        out.print("nav ul li a:hover { background-color: #111; }");
        out.print(".user-info { color: white; margin-left: auto; padding: 14px 20px; }");
        out.print("</style>");
        out.print("</head>");
        out.print("<body>");
        out.print("<!-- Navigation Bar -->");
        out.print("<nav>");
        out.print("<ul>");
        out.print("<li><a href='#home'>Home</a></li>");
        out.print("<li><a href='#services'>Services</a></li>");
        out.print("<li><a href='#contact'>Contact</a></li>");
        out.print("<li><a href='#about'>About</a></li>");
        out.print("<!-- User Info -->");
        out.print("<li class='user-info'>");
        out.print("Userid:" + userid + "<br>Password:" + password);
        out.print("</li>");
        out.print("</ul>");
        out.print("</nav>");
        
        out.print("<!-- Main Content of Dashboard -->");
        out.print("<div class='main-content'>");
        out.print("<h1>Welcome to the Dashboard</h1>");
        out.print("<!-- Other content goes here -->");
        out.print("</div>");
        out.print("</body>");
        out.print("</html>");	}
		
}
