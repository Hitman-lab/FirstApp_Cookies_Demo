package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("/link.html").include(request, response);

		Cookie[] c = request.getCookies();
		if (c == null) {
			out.println("<div align='center'>");
			out.println("<h2>You Haven't login in !</h2>");
			out.println("</div>");
			return;
		}

		Cookie ck = new Cookie("name", "");
		ck.setMaxAge(0);
		response.addCookie(ck);

		out.println("<div align='center'>");
		out.println("<h2>You Successfully logged out !</h2>");
		out.println("</div>");
	}
}
