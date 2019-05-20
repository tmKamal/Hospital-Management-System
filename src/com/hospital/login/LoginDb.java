package com.hospital.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.hospital.patient.Patient;

public class LoginDb {
	
	//Variable
	private DataSource datasource;

	//Constructor with parameters
	public LoginDb(DataSource datasource) {
		
		this.datasource = datasource;
	}
	
	
	
	
	
	
	
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		//Closing Connections for prevent Connection Leaks.
		
		
		try {
		
			if(myConn !=null) {
				myConn.close();
			}
			if(myStmt !=null) {
				myStmt.close();
			}
			if(myRs !=null) {
				myRs.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}








	public Admin adminDb(String user_id) {
		Admin adminLog=null;
		Connection myConn=null;
		java.sql.PreparedStatement myStmt=null;
		ResultSet myRs=null;
		//get connection
		try {
			myConn=datasource.getConnection();
			String sql="select * from admin where userId=?";
			//prepare statement
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, user_id);
			
			//execute Statement
			myRs=myStmt.executeQuery();
			//Reading 
			if(myRs.next()) {
				String uId=myRs.getString("userId");
				String name=myRs.getString("name");
				String email=myRs.getString("email");
				String pass=myRs.getString("password");
				
				
				//Assign to the object
				adminLog=new Admin(name, email, uId, pass);
			}else {
				return null;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(myConn, myStmt, myRs);
		}
		
		return adminLog;
	}
		
		
	
	
}
