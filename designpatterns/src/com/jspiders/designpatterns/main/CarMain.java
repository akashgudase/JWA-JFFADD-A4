package com.jspiders.designpatterns.main;

import com.jspiders.designpatterns.creational.CarFactory;

public class CarMain {

	public static void main(String[] args) {

		CarFactory carFactory = new CarFactory();
		try {
			carFactory.getCar().order();
		} catch (Exception e) {
			System.out.println("Error while ordering the car");
		}

	}

}
