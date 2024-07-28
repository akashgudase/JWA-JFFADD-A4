package com.jspiders.designpatterns.creational;

public class EagerConnection {

	private static EagerConnection connection = new EagerConnection();
	
	private static int count = 0;

	private EagerConnection() {

	}
	
	public static EagerConnection getConnection() {
		count++;
		if(count == 1)
			System.out.println("Connection is established with the new device");
		else
			System.out.println("Connection is already established");
		return connection;
	}

}
