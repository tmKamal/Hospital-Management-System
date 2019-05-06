package com.hospital.management.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/PharmaceuticalControllerServlet")
	

public class PharmaceuticalControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Declaring Object
	PharmaceuticalDb pdb;
	
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
				pdb=new PharmaceuticalDb(datasource);
			}catch(Exception ex) {
				throw new ServletException();
			}
			
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Using a method for handle data in MVC style
		 listMedicine(request,response);
	}
	
	//Method
	private void listMedicine(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			//Get Pharmaceutical List from PhatmaceuticalDB class using the object pdb
			List <Pharmaceutical> pList=pdb.getPharmaceutical();
			
			//add list to the request
			request.setAttribute("tmpList", pList);
			
			//send to the Jsp psge (view)
			RequestDispatcher fly=request.getRequestDispatcher("/viewPharmaceutical.jsp");
			fly.forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
