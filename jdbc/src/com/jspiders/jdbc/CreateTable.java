package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Load the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Register the Driver
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);

		// Get the Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=root");

		// Create the Statement
		Statement statement = connection.createStatement();

		// Execute the Statement
		statement.execute(
				"CREATE TABLE users(id int primary key, name varchar(20) not null, email varchar(20) not null unique, mobile bigint(10) not null unique, password varchar(20) not null)");

		// Process the Result
		System.out.println("Table is created");

		// Close the Connection
		statement.close();
		connection.close();

		// De-Register the Driver
		DriverManager.deregisterDriver(driver);

	}

}
