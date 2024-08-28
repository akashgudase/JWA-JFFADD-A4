package com.jspiders.designpatterns.creational;

public class LazyConnection {

	private static LazyConnection connection;

	private LazyConnection() {

	}

	public static LazyConnection getConnection() {
		if (connection == null) {
			connection = new LazyConnection();
			System.out.println("Connection is established with the new device");
		} else
			System.out.println("Connection is already established");
		return connection;
	}

}
