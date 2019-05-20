package com.hospital.login;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.hospital.Pharmaceutical.PharmaceuticalDb;

/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//Declaring Object
		private LoginDb ldb;
		
		//define connection pool
			@Resource(name="jdbc/web_hospital_db")
			private DataSource datasource;
			
			
			
		//init method
		@Override
			public void init() throws ServletException {
				// Normally in Servlet we use init method instead of constructor in normal class.
				super.init();
				//Initializing object
				//init method is a very good place to initializing the objects. because its execute first.
				try {
					ldb=new LoginDb(datasource);
				}catch(Exception ex) {
					throw new ServletException();
				}
				
			}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//get the instruction 
			String infoLog=request.getParameter("infoLog");
			
			//if instruction is empty
			if(infoLog==null) {
				infoLog="redirect";
			}
			
			switch (infoLog) {
			
				case "admin":
					adminLogin(request,response);
					break;
				
				case "redirect":
					response.sendRedirect("index.html");
					break;
				
	
				default:
					response.sendRedirect("index.html");
					break;
			}
			
		}catch(Exception exc) {
			System.out.println("Error is: "+exc);
			//listMedicine(request, response);
		}
				
	}
	


	private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user_id=request.getParameter("userId");
		String pass=request.getParameter("pwd");
		
		Admin a1;
		//Retrieve user data from Database
		a1=ldb.adminDb(user_id);
		

		if(a1==null) {
			//if Entered userId Wrong
			request.getSession().setAttribute("errorAdmin", "That User account doesn't exist.");
			response.sendRedirect("loginAdmin.jsp");
		}else {
			//Retrieving Data from the created object
			String name=a1.getName();
			String id=a1.getUserId();
			String password=a1.getPassword();
			String email=a1.getEmail();
			
			//permission level
			String lvl=a1.permission();
			
			if(user_id.equals(id) && pass.equals(password)) {
				//Create Session for User 
				HttpSession session = request.getSession();
				session.setAttribute("userID", user_id);
				session.setAttribute("power", lvl);
				session.setAttribute("userName", name);
				session.setAttribute("email", email);
				session.setAttribute("position", "Admin");
				response.sendRedirect("PharmaceuticalControllerServlet");
			}else {
				//if Entered Password wrong
				request.getSession().setAttribute("errorAdmin", "The password that you've entered is incorrect");
				response.sendRedirect("loginAdmin.jsp");
			}
			
		}	
	}

}
