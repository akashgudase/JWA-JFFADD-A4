package com.jspiders.servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.servlets.data.DataAccess;

@WebServlet("/login")
public class LogIn extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		DataAccess access = new DataAccess();

		boolean isPresent = access.findUserByUsernameAndPassword(username, password);

		if (isPresent) {
			req.getRequestDispatcher("home.html").forward(req, resp);
		} else {
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("<h1>Invalid username or password..</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}

}
