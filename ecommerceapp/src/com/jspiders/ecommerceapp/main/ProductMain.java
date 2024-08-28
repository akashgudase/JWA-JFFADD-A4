package com.jspiders.ecommerceapp.main;

import java.util.Scanner;

import com.jspiders.ecommerceapp.entity.User;
import com.jspiders.ecommerceapp.operation.ProductOperation;

public class ProductMain {

	private static ProductOperation productOperation = new ProductOperation();

	public static void main(User user, Scanner scanner) {

		boolean flag = true;
		while (flag) {
			System.out
					.println("=========================================================================================================================================================");
			System.out.println(
					"Enter 1 to add product \nEnter 2 to find product by id \nEnter 3 to find all products \nEnter 4 to delete product \nEnter 5 to update product \nEnter 6 to go back");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				if (user.getRole().equals("SELLER")) {
					productOperation.addProduct(scanner);
				} else {
					System.out.println("Unauthorized access");
				}
				break;
			case 2:
				productOperation.findProductById(scanner);
				break;
			case 3:
				productOperation.findAllProducts();
				break;
			case 4:
				if (user.getRole().equals("SELLER")) {
					productOperation.deleteProduct(scanner);
				} else {
					System.out.println("Unauthorized access");
				}
				break;
			case 5:
				if (user.getRole().equals("SELLER")) {
					productOperation.updateProduct(scanner);
				} else {
					System.out.println("Unauthorized access");
				}
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}

	}

}
