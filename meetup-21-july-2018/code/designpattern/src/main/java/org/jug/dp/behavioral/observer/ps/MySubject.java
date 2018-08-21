package org.jug.dp.behavioral.observer.ps;


public class MySubject {

	private String stock;
	private double price;
	public MySubject(String stock, double price) {
		this.stock = stock;
		this.price = price;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	
}
