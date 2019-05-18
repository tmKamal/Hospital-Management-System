package com.hospital.Pharmaceutical;

public class Pharmaceutical {
	 String id;
	 String name;
	private String brandName;
	private int qty;
	private double price;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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


	public Pharmaceutical(String id, String name,String brandName, int qty, double price) {
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
