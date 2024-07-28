package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamWrite {

	public static void main(String[] args) throws IOException {

		File file = new File("byte.txt");
		if (file.exists()) {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(26);
			fileOutputStream.close();
			System.out.println("Byte is written to the file");
		} else {
			boolean status = file.createNewFile();
			if (status)
				System.out.println("File is created");
			else

				System.out.println("File already exists");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(26);
			fileOutputStream.close();
			System.out.println("Byte is written to the file");
		}

	}

}
