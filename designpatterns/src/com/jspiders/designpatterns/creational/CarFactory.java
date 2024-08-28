package com.jspiders.designpatterns.creational;

import java.util.Scanner;

public class CarFactory {

	public Car getCar() {
		Car car = null;
		System.out.println("Enter 1 to order Thar");
		System.out.println("Enter 2 to order Scorpio");
		System.out.println("Enter 3 to order Fortuner");
		System.out.println("Enter 4 to order XUV700");
		System.out.println("Enter your choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.close();
		switch (choice) {
		case 1:
			car = new Thar();
			break;
		case 2:
			car = new Scorpio();
			break;
		case 3:
			car = new Fortuner();
			break;
		case 4:
			car = new XUV700();
			break;
		default:
			System.out.println("Invalid choice");
		}
		return car;
	}

}
