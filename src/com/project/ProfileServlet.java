package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		RequestDispatcher rd = request.getRequestDispatcher("/link.html");
		rd.include(request, response);

		Cookie[] c = request.getCookies();
		if (c != null) {
			String name = c[0].getValue();
			if (!name.equals("") || name != null) {
				out.println("<div align='center'>");
				out.println("<h1>Welcome to Profile Section </h1>");
				out.println("<br> <h1> Welcome " + name + "</h1>");
				out.println("</div>");
			}
		} else {
			out.println("<div align='center'>");
			out.println("<h2>Login First</h2>");
			out.println("</div>");
			request.getRequestDispatcher("/login.html").include(request, response);
		}
		out.close();
	}
}
