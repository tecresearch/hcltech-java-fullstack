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
 * Servlet implementation class Dashboard
 */
@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession(false); // check existence of session

        if (session != null) {
            // getting session values
            String name = (String) session.getAttribute("session_name");
            String email = (String) session.getAttribute("session_email");
            String sessionId = session.getId();

            // getting cookies
            boolean isReturningUser = false;

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if ("name".equals(c.getName())) {
                        isReturningUser = true;
                        break;
                    }
                }
            }

            if (isReturningUser) {
                response.getWriter().write("<script>alert('Welcome back, " + name + "');</script>");
            } else {
                response.addCookie(new Cookie("name", name));
                response.getWriter().write("<script>alert('You are a new user');</script>");
            }

            response.getWriter().write("<script>alert('Session is active...');</script>");

            response.getWriter()
                    .write("<!DOCTYPE html>" + "<html>" + "<head>"
                            + "<link rel='stylesheet' type='text/css' href='dashboard.css'>" + "</head>" + "<body>"
                            + "<header>Dashboard</header>" + "<nav>" + "<a href='dashboard'>Home</a>"
                            + "<a href='logout' class='logout'>Logout</a>" + "</nav>" + "<div class='container'>"
                            + "<h1>Welcome to your Dashboard</h1>" + "<hr><br>" + "Session Id: " + sessionId
                            + " <br>Session Name: " + name + "<br>Session Email: " + email + "<br><hr>" + "</div>"
                            + "</body>" + "</html>");
        } else {
            response.getWriter().write("<script>alert('Session is not active...');</script>");
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        }
    }
}
