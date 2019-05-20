package com.hospital.login;

public class Nurse extends User {
	
	private String permit="lvl1"; 

	public Nurse(String name, String email, String userId, String password) {
		super(name, email, userId, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String permission() {
		// TODO Auto-generated method stub
		return permit;
	}
	
}
