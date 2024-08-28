package com.jspiders.multithreading.resource;

public class FacebookServer {

	public void welcome() {
		System.out.println("Hi " 
	+ Thread.currentThread().getName() + " Welcome to Facebook..");
	}

}
