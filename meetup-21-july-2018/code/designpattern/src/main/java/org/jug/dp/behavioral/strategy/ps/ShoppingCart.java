package org.jug.dp.behavioral.strategy.ps;

import java.util.*;

 public class ShoppingCart {
	private List<Product> products = new ArrayList<Product>();
	
	public void addProduct(Product product) {
		products.add(product);
	}

	public double getCartPrice() {
		double cartTotal = 0;
		for (Product product : products) {
			cartTotal += product.getPrice();
		}
		return cartTotal;
	}

	
}
