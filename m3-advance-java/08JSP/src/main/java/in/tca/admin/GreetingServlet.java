package in.tca.admin;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/greating")
public class GreetingServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String  age=request.getParameter("age");
		
		ArrayList<String> list=new ArrayList();
		list.add(name);
		list.add(age);
		response.getWriter().print(list);
	}
	
	
}
