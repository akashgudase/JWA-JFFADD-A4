package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Product;

public class Consumer extends Thread {

	private Product product;

	public Consumer() {
		super();
	}

	public Consumer(Product product) {
		super();
		this.product = product;
	}

	@Override
	public void run() {
		product.demand(10);
	}

}
