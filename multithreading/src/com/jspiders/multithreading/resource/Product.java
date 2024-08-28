package com.jspiders.multithreading.resource;

public class Product {

	private int count;

	synchronized public void demand(int count) {
		if (count <= this.count) {
			System.out.println("Product availabel");
			this.count -= count;
			System.out.println("Product delivered");
		} else {
			System.out.println("Shortage of product");
			System.out.println("Wait for sometime..");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (this.count >= count) {
				System.out.println("Product availabel");
				this.count -= count;
				System.out.println("Product delivered");
			}
		}
	}

	synchronized public void supply(int count) {
		this.count += count;
		notify();
	}

}
