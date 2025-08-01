package react_java.model.send;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/data")
public class Mydata extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String jsonData = "[{\"id\":1,\"name\":\"Brijesh Nishad\"},{\"id\":2,\"name\":\"Jane Doe\"},{\"id\":3,\"name\":\"Kishan Nishad\"}]";
        
        PrintWriter out = resp.getWriter();
        out.print(jsonData);
        out.flush();
	}

}
