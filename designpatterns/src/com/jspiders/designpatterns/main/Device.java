package com.jspiders.designpatterns.main;

import com.jspiders.designpatterns.creational.EagerConnection;

public class Device {

	public static void main(String[] args) {

//		LazyConnection connection1 = LazyConnection.getConnection();
//		System.out.println(connection1);
//
//		LazyConnection connection2 = LazyConnection.getConnection();
//		System.out.println(connection2);

		EagerConnection connection3 = EagerConnection.getConnection();
		System.out.println(connection3);

		EagerConnection connection4 = EagerConnection.getConnection();
		System.out.println(connection4);

	}

}
