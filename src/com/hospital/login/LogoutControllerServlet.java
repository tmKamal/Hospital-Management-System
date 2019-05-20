package com.hospital.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutControllerServlet
 */
@WebServlet("/LogoutControllerServlet")
public class LogoutControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Delete the UserID Session
		HttpSession session=request.getSession();
		session.removeAttribute("userID");
		session.invalidate();
		//Redirected to the Index
		response.sendRedirect("index.html");
	}

}
