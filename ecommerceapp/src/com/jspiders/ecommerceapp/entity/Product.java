package com.jspiders.ecommerceapp.entity;

public class Product {

	private int id;
	private String title;
	private String description;
	private double price;
	private boolean sold;

	public Product() {
		super();
	}

	public Product(int id, String title, String description, double price, boolean sold) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.sold = sold;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", sold=" + sold + "]";
	}

}
