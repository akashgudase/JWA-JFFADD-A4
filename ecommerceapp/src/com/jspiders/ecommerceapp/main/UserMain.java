package com.jspiders.ecommerceapp.main;

import java.util.Scanner;

import com.jspiders.ecommerceapp.operation.UserOperation;

public class UserMain {

	private static UserOperation userOperation = new UserOperation();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println(
					"=============================================================================================================================================================================================");
			System.out.println(
					"Enter 1 to add user \nEnter 2 to find user by email and password \nEnter 3 to find all users \nEnter 4 to find user by id \nEnter 5 to delete user \nEnter 6 to update user \nEnter 7 to exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				userOperation.addUser(scanner);
				break;
			case 2:
//				User user = userOperation.findUserByEmailAndPassword(scanner);
//				if (user != null) {
//					System.out.println("User found");
//					ProductMain.main(user, scanner);
//				} else {
//					System.out.println("Invalid email or password");
//				}
				userOperation.findUserByEmailAndPassword(scanner);
				break;
			case 3:
				userOperation.findAllUsers();
				break;
			case 4:
				userOperation.findUserById(scanner);
				break;
			case 5:
				userOperation.deleteUser(scanner);
				break;
			case 6:
				userOperation.updateUser(scanner);
				break;
			case 7:
				System.out.println("Thank you");
				flag = false;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		scanner.close();

	}

}
