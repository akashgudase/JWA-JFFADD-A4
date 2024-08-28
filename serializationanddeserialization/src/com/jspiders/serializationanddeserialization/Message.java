package com.jspiders.serializationanddeserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Message {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String message1 = "Hello World!";

		File file = new File("message.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(message1);
		objectOutputStream.close();
		fileOutputStream.close();
		System.out.println("Message is serialized");

		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		String message2 = (String) objectInputStream.readObject();
		objectInputStream.close();
		fileInputStream.close();
		System.out.println("Message is deserialized");
		System.out.println(message2);

	}

}
