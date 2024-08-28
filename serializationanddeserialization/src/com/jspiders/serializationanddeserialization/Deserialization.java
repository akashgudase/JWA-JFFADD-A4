package com.jspiders.serializationanddeserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File file = new File("user_data.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		User user = (User) objectInputStream.readObject();
		System.out.println("Object is deserialized");
		objectInputStream.close();
		fileInputStream.close();
		System.out.println(user);

	}

}
