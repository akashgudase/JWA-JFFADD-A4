package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SignIn {

	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String query;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user email");
		String email = scanner.nextLine();
		System.out.println("Enter user password");
		String password = scanner.nextLine();
		scanner.close();

		try {
			openConnection();
			statement = connection.createStatement();
			query = "SELECT * FROM user WHERE email = '" + email + "' AND password = '" + password + "'";
			boolean res = statement.execute(query);
			System.out.println(res);
			resultSet = statement.getResultSet();
			if (resultSet.next())
				System.out.println("User found");
			else
				System.out.println("Invalid email or password");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?user=root&password=root");
	}

	private static void closeConnection() throws SQLException {
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
		if (driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}

}
