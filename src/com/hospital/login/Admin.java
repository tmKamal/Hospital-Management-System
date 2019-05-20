package com.hospital.login;

public class Admin extends User {

	private String permit="all";
	
	public Admin(String name, String email, String userId, String password) {
		super(name, email, userId, password);
		
	}

	@Override
	public String permission() {
		
		return permit;
	}

	
}
