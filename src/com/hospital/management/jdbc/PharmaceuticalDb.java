package com.hospital.management.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PharmaceuticalDb {
	
	//Variable
	private DataSource datasource;
	
	
	//Constructor with parameters
	public PharmaceuticalDb(DataSource datasource) {
		
		this.datasource = datasource;
	}

	//Listing pharmaceutical in db  to an Array 
	public List<Pharmaceutical> getPharmaceutical()throws Exception{
		
		List<Pharmaceutical> pharmaceuticals=new ArrayList<Pharmaceutical>();
		
		//Connection Var
		Connection myConn =null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try {
		
			//Get a connection
			myConn=datasource.getConnection();
			
			//Create a Sql Statement
			String sql="select * from pharmaceutical";
			myStmt=myConn.createStatement();
			
			//Execute Query
			myRs=myStmt.executeQuery(sql);
			
			//Printing out the results from DB
			while(myRs.next()) {
				int pId=myRs.getInt("p_id");
				String pName=myRs.getString("p_name");
				String pBrandName=myRs.getString("p_brand_name");
				int pQty=myRs.getInt("p_qty");
				Double pPrice=myRs.getDouble("p_price");
				
				//Creating Object
				Pharmaceutical tmpPharmaceutical=new Pharmaceutical(pId,pName,pBrandName,pQty,pPrice);
				//Adding created object into the list
				pharmaceuticals.add(tmpPharmaceutical);
				
						
			}
		
		}catch(Exception exc) {
			
		}finally {
			close(myConn,myStmt,myRs);
		}
		
		return pharmaceuticals;
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
}
