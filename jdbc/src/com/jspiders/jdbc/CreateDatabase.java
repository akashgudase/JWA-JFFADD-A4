package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Load the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Register the Driver
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);

		// Get the Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");

		// Create the Statement
		Statement statement = connection.createStatement();

		// Execute the Statement
		statement.execute("CREATE DATABASE demo");

		// Process the Result
		System.out.println("Database created");

		// Close the Connection
		statement.close();
		connection.close();

		// De-Register the Driver
		DriverManager.deregisterDriver(driver);

	}

}
