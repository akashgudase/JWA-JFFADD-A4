package com.jspiders.servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.servlets.data.DataAccess;

@WebServlet("/signup")
public class SignUp extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String password = req.getParameter("password");

		DataAccess access = new DataAccess();

		int res = access.addUser(username, email, mobile, password);

		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		if (res == 1) {
			printWriter.println("<h1>Sign up successfull..</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			printWriter.println("<h1>Something went wrong..</h1>");
			req.getRequestDispatcher("signup.html").include(req, resp);
		}
	}

}
