package com.hospital.management.jdbc;

public class Pharmaceutical {
	private int id;
	private String name;
	private String brandName;
	private int qty;
	private double price;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public void  setBrandName(String brandName) {
		this.brandName=brandName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Pharmaceutical(int id, String name,String brandName, int qty, double price) {
		super();
		this.id = id;
		this.name = name;
		this.brandName=brandName;
		this.qty = qty;
		this.price = price;
	}


	@Override
	public String toString() {
		return "Pharmaceutical [id=" + id + ", name=" + name + ", Brand Name="+brandName+", qty=" + qty + ", price=" + price + "]";
	}
	
	
	
}
