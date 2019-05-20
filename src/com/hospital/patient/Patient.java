package com.hospital.patient;

public class Patient {
	
	private String nic;
    private String firstName;
	private String lastName;
	private String address;
	private String description;
	  

	public Patient(String nic, String firstName, String lastName, String address, String description) {
		
		this.nic = nic;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.description = description;
	}
	
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	    
}
