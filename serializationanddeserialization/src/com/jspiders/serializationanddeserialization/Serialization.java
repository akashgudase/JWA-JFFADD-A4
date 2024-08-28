package com.jspiders.serializationanddeserialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) throws IOException {

		User user = new User("ramesh@gmail.com", 9876543210L, "Ramesh@1234");

		File file = new File("user_data.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(user);
		objectOutputStream.close();
		fileOutputStream.close();
		System.out.println("Object is serialized");

	}

}
