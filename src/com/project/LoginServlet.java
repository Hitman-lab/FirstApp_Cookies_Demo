package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		RequestDispatcher rd = request.getRequestDispatcher("/link.html");
		rd.include(request, response);

		String u_name = request.getParameter("username");
		String p_pass = request.getParameter("pass");

		if (p_pass.equals("admin123")) {
			out.println("<div align='center'>");
			out.println("<h1>You are successfully Logged in!</h1>");
			out.println("<br> <h1> Welcome " + u_name + "</h1>");
			out.println("</div>");

			Cookie ck = new Cookie("name", u_name);
			response.addCookie(ck);

		} else {
			out.println("<div align='center'>");
			out.println("<h2>Sorry!! Username or Password error!! </h2>");
			out.println("</div>");
			request.getRequestDispatcher("/login.html").include(request, response);
		}
		out.close();
	}

}
