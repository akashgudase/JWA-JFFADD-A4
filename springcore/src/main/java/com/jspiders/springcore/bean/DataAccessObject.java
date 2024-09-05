package com.jspiders.springcore.bean;

public class DataAccessObject {

	private DatabaseConnection connection;
	
	{
		System.out.println("Data access object created");
	}

	public DatabaseConnection getConnection() {
		return connection;
	}

	public void setConnection(DatabaseConnection connection) {
		this.connection = connection;
	}

	@Override
	public String toString() {
		return "DataAccessObject [connection=" + connection + "]";
	}

}
