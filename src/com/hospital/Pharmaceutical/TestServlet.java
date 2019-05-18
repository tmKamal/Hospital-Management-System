package com.hospital.Pharmaceutical;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//define connection pool
	@Resource(name="jdbc/web_hospital_db")
	private DataSource dataSource;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try {
			//Connection
			myConn=dataSource.getConnection();
			//Sql Statement
			String sql="select * from users";
			//Create the Statement
			myStmt=myConn.createStatement();
			//execute the Query
			myRs=myStmt.executeQuery(sql);
			//Output
			while(myRs.next()) {
				String name=myRs.getString("u_name");
				out.println(name);
			}
			
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
