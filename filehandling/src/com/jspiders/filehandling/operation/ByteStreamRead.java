package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamRead {

	public static void main(String[] args) throws IOException {

		File file = new File("byte.txt");
		if (file.exists()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			int data = fileInputStream.read();
			fileInputStream.close();
			System.out.println(data);
		} else
			System.out.println("File does not exist");

	}

}
