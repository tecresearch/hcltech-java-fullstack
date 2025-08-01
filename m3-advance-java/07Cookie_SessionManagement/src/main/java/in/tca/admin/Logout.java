package in.tca.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
       
        if (session != null) {
            session.invalidate();
            response.getWriter().write("<script>alert('Logged out successfully');</script>");
        }

        response.setContentType("text/html");
        response.getWriter().write(
            "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<link rel='stylesheet' type='text/css' href='logout.css'>" +
            "</head>" +
            "<body>" +
            "<div class='logout-message'>" +
            "<h1>You have been logged out</h1>" +
            "<a href='login.html'>Go to Login Page</a>" +
            "</div>" +
            "</body>" +
            "</html>"
        );
    }
}
