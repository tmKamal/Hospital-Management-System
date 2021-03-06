package com.hospital.Pharmaceutical;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hospital.login.Admin;
import com.hospital.patient.Patient;
import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.bcel.internal.generic.ALOAD;

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
				String pId=myRs.getString("p_id");
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
	
	
	//Method - Add Student to the the DB
	public void addPharmaceutical(Pharmaceutical medicine) {
		Connection myConn1=null;
		java.sql.PreparedStatement myStmt1=null;
		
			try {
				//Connection
				myConn1=datasource.getConnection();
				
				//Create SQL for insert
				
				String sql="insert into pharmaceutical "+"(p_id, p_name, p_brand_name, p_qty, p_price)"
							+"values(?, ?, ?, ?, ?)";
				
				//Prepare Statements
				myStmt1=myConn1.prepareStatement(sql);
				//Add Values to the related fields
				myStmt1.setString(1, medicine.getId());
				myStmt1.setString(2, medicine.getName());
				myStmt1.setString(3, medicine.getBrandName());
				myStmt1.setInt(4, medicine.getQty());
				myStmt1.setDouble(5, medicine.getPrice());
				
				//Execute
				myStmt1.execute();
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close(myConn1, myStmt1, null);
				
			}
	}

	public Pharmaceutical selectMed(String pId) throws Exception {
		Pharmaceutical phMed=null;
		Connection myConn=null;
		java.sql.PreparedStatement myStmt=null;
		ResultSet myRs=null;
		
		try {
			//create connection
			myConn=datasource.getConnection();
			//Sql Statement
			String sql="select * from pharmaceutical where p_id=?";
			//create prepared Statements
			myStmt=myConn.prepareStatement(sql);
			//set parameters
			myStmt.setString(1, pId);
			//execute Statement
			myRs=myStmt.executeQuery();
			//Reading 
			if(myRs.next()) {
				String pid=myRs.getString("p_id");
				String pname=myRs.getString("p_name");
				String pbrand=myRs.getString("p_brand_name");
				int pqty=myRs.getInt("p_qty");
				double pprice=myRs.getDouble("p_price");
				
				//Assign to the object
				phMed=new Pharmaceutical(pid, pname, pbrand, pqty, pprice);
			}else {
				throw new Exception("Cannot find the given id "+pId);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			//close JDBC connection
			close(myConn, myStmt, myRs);
		}
		return phMed;
	}



	public void updateMedicineDb1(Pharmaceutical medicineDb) throws Exception{
		Connection myConn=null;
		java.sql.PreparedStatement myStmt=null;
		
		try {
			//create connection
			myConn=datasource.getConnection();
			//sql statement
			String sql="update pharmaceutical "
						+"set p_id=?, p_name=?, p_brand_name=?, p_qty=?, p_price=? "
						+"where p_id=?";
			//prepare Statement
			myStmt=myConn.prepareStatement(sql);
			//set parameters of the sql statement
			myStmt.setString(1, medicineDb.getId());
			myStmt.setString(2, medicineDb.getName());
			myStmt.setString(3, medicineDb.getBrandName());
			myStmt.setInt(4, medicineDb.getQty());
			myStmt.setDouble(5, medicineDb.getPrice());
			myStmt.setString(6, medicineDb.getId());
			//execute sql command
			myStmt.execute();
		}finally {
			//close JDBC connection
			close(myConn, myStmt, null);
			
		}
		
		
		
	}

	public void deleteMedicineDb(String id) {
		Connection myConn=null;
		java.sql.PreparedStatement myStmt=null;
		
		//get connection 
		try {
			myConn=datasource.getConnection();
			String sql="delete from pharmaceutical where p_id=?";
			//prepare statements
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1,id);
			//execute
			myStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(myConn, myStmt, null);
		}
		
		
	}

	public Patient selectPatientDb(String patientId) throws Exception {
		Patient patientDb=null;
		Connection myConn=null;
		java.sql.PreparedStatement myStmt=null;
		ResultSet myRs=null;
		//get connection
		try {
			myConn=datasource.getConnection();
			String sql="select * from patient where nic=?";
			//prepare statement
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, patientId);
			
			//execute Statement
			myRs=myStmt.executeQuery();
			//Reading 
			if(myRs.next()) {
				String pid=myRs.getString("nic");
				String firstName=myRs.getString("first_name");
				String lastName=myRs.getString("last_name");
				String address=myRs.getString("address");
				String description=myRs.getString("description");
				
				//Assign to the object
				patientDb=new Patient(pid, firstName, lastName, address, description);
			}else {
				return null;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(myConn, myStmt, myRs);
		}
		
		return patientDb;
	}

	public List<AllocatedPharmaceutical> showAllocatedMeds(String patientId) throws Exception {
		Connection myConn=null;
		java.sql.PreparedStatement myStmt=null;
		ResultSet myRs=null;
		AllocatedPharmaceutical allocatedDb;
		List<AllocatedPharmaceutical>listAllocated=new ArrayList<AllocatedPharmaceutical>();
		
		
				try {
					//get connection
					myConn=datasource.getConnection();
					//SQL
					String sql="select a.id,ph.p_id,ph.p_name,ph.p_brand_name,a.qty "
								+"from allocated_medicine a, patient p, pharmaceutical ph "
								+"where a.patient_nic=p.nic and ph.p_id=a.pharmaceutical_id  and a.patient_nic=? ";
					//prepare statement
					myStmt=myConn.prepareStatement(sql);
					myStmt.setString(1, patientId);
					
					//execute Statement
					myRs=myStmt.executeQuery();
					//Reading 
					while(myRs.next()) {
						int id=myRs.getInt("a.id");
						String pId=myRs.getString("ph.p_id");
						String pName=myRs.getString("ph.p_name");
						String pBrandName=myRs.getString("ph.p_brand_name");
						int qty=myRs.getInt("a.qty");
						
						
						//Assign to the object
						AllocatedPharmaceutical allo1=new AllocatedPharmaceutical(id, pId, qty, pName, pBrandName);
						listAllocated.add(allo1);
					}
					
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					close(myConn, myStmt, myRs);
				}
				
		
		return listAllocated;
	}

	public Pharmaceutical selectMedDb(String medId) {
		
		Pharmaceutical medDb=null;
		Connection myConn=null;
		java.sql.PreparedStatement myStmt=null;
		ResultSet myRs=null;
		//get connection
		try {
			myConn=datasource.getConnection();
			String sql="select * from pharmaceutical where p_id=?";
			//prepare statement
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, medId);
			
			//execute Statement
			myRs=myStmt.executeQuery();
			//Reading 
			if(myRs.next()) {
				String pid=myRs.getString("p_id");
				String pname=myRs.getString("p_name");
				String pbrand=myRs.getString("p_brand_name");
				int pqty=myRs.getInt("p_qty");
				double pprice=myRs.getDouble("p_price");
				
				//Assign to the object
				medDb=new Pharmaceutical(pid, pname, pbrand, pqty, pprice);
			}else {
				return null;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(myConn, myStmt, myRs);
		}
		
		return medDb;
	}

	public void insertAllocatedMeds(String patientNic, String p_id, int nQty) {
		Connection myConn1=null;
		java.sql.PreparedStatement myStmt1=null;
		
			try {
				//Connection
				myConn1=datasource.getConnection();
				
				//Create SQL for insert
				
				String sql="insert into allocated_medicine "
							+"(patient_nic, pharmaceutical_id, qty)"
							+"values(?, ?, ?)";
				
				//Prepare Statements
				myStmt1=myConn1.prepareStatement(sql);
				//Add Values to the related fields
				myStmt1.setString(1, patientNic);
				myStmt1.setString(2, p_id);
				myStmt1.setInt(3, nQty);		
				//Execute
				myStmt1.execute();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(myConn1, myStmt1, null);	
			}
		
	}

	public void updateOriginalMed(String p_id, int rQty) throws SQLException {
		Connection myConn=null;
		java.sql.PreparedStatement myStmt=null;
		
		try {
			//create connection
			myConn=datasource.getConnection();
			//sql statement
			String sql="update pharmaceutical "
						+"set p_qty=? "
						+"where p_id=?";
			//prepare Statement
			myStmt=myConn.prepareStatement(sql);
			//set parameters of the sql statement
			
			myStmt.setInt(1, rQty);
			myStmt.setString(2, p_id);
			
			
			//execute sql command
			myStmt.execute();
		}finally {
			//close JDBC connection
			close(myConn, myStmt, null);
			
		}	
	}

	
}
