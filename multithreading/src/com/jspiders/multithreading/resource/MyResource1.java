package com.jspiders.multithreading.resource;

public class MyResource1 {

	private int count;

	synchronized public void increment() {
		this.count++;
	}

	public int getCount() {
		return this.count;
	}

}
