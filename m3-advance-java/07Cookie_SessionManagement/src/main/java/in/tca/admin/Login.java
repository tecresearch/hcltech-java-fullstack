package in.tca.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		HttpSession sh = request.getSession(false);
		if (sh != null) {
			response.getWriter().write("<script>alert('Session active :Already LoggedIn!')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/dashboard");
			rd.include(request, response);
		} else {
			
			if (name.equalsIgnoreCase("Brijesh") || name.equalsIgnoreCase("2100431")||name.equalsIgnoreCase("mrjacks")&& email.equals("bnlv1212@gmail.com")) {
			
				Cookie c=new Cookie("cname",name);//Creating a cookie
				response.addCookie(c);//adding a cookie
				
				HttpSession session = request.getSession();// session created
				session.setAttribute("session_name", name);
				session.setAttribute("session_email", email);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} else {
				response.getWriter().write("<script>alert('Invalid credentials!')</script>");
				RequestDispatcher rd = request.getRequestDispatcher("dashboard");
				rd.include(request, response);
			}

		}

	}

}
