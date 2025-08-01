package in.tca.admin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class Dispatcher extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String userid=req.getParameter("userid");
		String password=req.getParameter("password");
		
		if(userid.equals("2100431")&&password.equals("787898")) {
			RequestDispatcher rd=req.getRequestDispatcher("/myProfile");
			rd.forward(req, resp);
		}else {
			resp.setContentType("text/html");
			out.print("<script>alert('invalid credentials');</script>");
			RequestDispatcher rd=req.getRequestDispatcher("/index.html");
			rd.include(req, resp);
		}
	}
	
}
