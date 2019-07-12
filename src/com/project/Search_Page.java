package com.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search_Page extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Search_Page() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("search_box");
		response.sendRedirect("https://www.google.co.in/#q=" + name);
	}

}
