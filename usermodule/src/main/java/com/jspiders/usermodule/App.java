package com.jspiders.usermodule;

import java.util.Scanner;

import com.jspiders.usermodule.dao.UserDAO;
import com.jspiders.usermodule.dao.UserDAOImpl;

public class App {
	public static void main(String[] args) {

		UserDAO userDAO = new UserDAOImpl();
		Scanner scanner = new Scanner(System.in);
		boolean isRunning = true;

		while (isRunning) {
			System.out.println("==============================Welcome==============================");
			System.out.println("Enter 1 to add user" + "\nEnter 2 to exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				userDAO.addUser(null, choice, null, null);
				break;
			case 2:
				System.out.println("==============================See you again==============================");
				isRunning = false;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}

		scanner.close();

	}
}
