package com.hospital.login;

public class Cashier extends User {

	private String permit="lvl2";
	
	public Cashier(String name, String email, String userId, String password) {
		super(name, email, userId, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String permission() {
		
		return permit;
	}
	
	

}
