package com.jspiders.ecommerceapp.operation;

import java.util.List;
import java.util.Scanner;

import com.jspiders.ecommerceapp.collection.UserCollection;
import com.jspiders.ecommerceapp.entity.User;
import com.jspiders.ecommerceapp.jdbc.UserJDBC;

public class UserOperation {

	private static UserCollection userCollection = new UserCollection();

	private static UserJDBC userJDBC = new UserJDBC();

	public void addUser(Scanner scanner) {

		System.out.println("Enter user id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter user name");
		String name = scanner.nextLine();
		System.out.println("Enter user email");
		String email = scanner.nextLine();
		System.out.println("Enter user mobile number");
		long mobile = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter user password");
		String password = scanner.nextLine();
		System.out.println("Select user role");
		System.out.println("Enter 1 for SELLER \nEnter 2 for BUYER");
		int choice = scanner.nextInt();
		String role = null;
		switch (choice) {
		case 1:
			role = "SELLER";
			break;
		case 2:
			role = "BUYER";
			break;
		default:
			System.out.println("Invalid choice");
		}
		User user = new User(id, name, email, mobile, password, role);
		List<User> users = userCollection.getUsers();
		users.add(user);
		userJDBC.addUser(user);
		System.out.println("User added");

	}

	public void findUserById(Scanner scanner) {
		System.out.println("Enter user id");
		int id = scanner.nextInt();
//		User userById = null;
//		List<User> users = userCollection.getUsers();
//		for (User user : users) {
//			if (user.getId() == id) {
//				userById = user;
//				break;
//			}
//		}
//		if (userById != null) {
//			System.out.println(userById);
//		} else {
//			System.out.println("User not found");
//		}
		userJDBC.findUserById(id);
	}

	public void findAllUsers() {
//		List<User> users = userCollection.getUsers();
//		if (users.size() > 0) {
//			for (User user : users) {
//				System.out.println(user);
//			}
//		} else {
//			System.out.println("Users not found");
//		}
		userJDBC.findAllUsers();
	}

	public void findUserByEmailAndPassword(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Enter user email");
		String email = scanner.nextLine();
		System.out.println("Enter user password");
		String password = scanner.nextLine();
//		List<User> users = userCollection.getUsers();
//		User loggedInUser = null;
//		for (User user : users) {
//			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
//				loggedInUser = user;
//				break;
//			}
//		}
//		return loggedInUser;
		userJDBC.findUserByEmailAndPassword(email, password);
	}

	public void deleteUser(Scanner scanner) {
		System.out.println("Enter user id");
		int id = scanner.nextInt();
//		List<User> users = userCollection.getUsers();
//		User userToBedeleted = null;
//		for (User user : users) {
//			if (user.getId() == id) {
//				userToBedeleted = user;
//				break;
//			}
//		}
//		if (userToBedeleted != null) {
//			users.remove(userToBedeleted);
//			System.out.println("User deleted");
//		} else {
//			System.out.println("Invalid user id");
//		}
		userJDBC.deleteUser(id);
	}

	public void updateUser(Scanner scanner) {
		System.out.println("Enter user id");
		int id = scanner.nextInt();
		List<User> users = userCollection.getUsers();
		User userToBeUpdated = null;
		for (User user : users) {
			if (user.getId() == id) {
				userToBeUpdated = user;
				break;
			}
		}
		if (userToBeUpdated != null) {
			scanner.nextLine();
			System.out.println("Enter new user name");
			String newName = scanner.nextLine();
			System.out.println("Enter new user email");
			String newEmail = scanner.nextLine();
			System.out.println("Enter new user mobile number");
			long newMobile = scanner.nextLong();
			scanner.nextLine();
			System.out.println("Enter new user password");
			String newPassword = scanner.nextLine();
			userToBeUpdated.setName(newName);
			userToBeUpdated.setEmail(newEmail);
			userToBeUpdated.setMobile(newMobile);
			userToBeUpdated.setPassword(newPassword);
			System.out.println("User updated");
		} else {
			System.out.println("Invalid user id");
		}
	}

}
