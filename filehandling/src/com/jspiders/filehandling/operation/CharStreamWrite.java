package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamWrite {
	
	public static void main(String[] args) {
		
		File file = new File("pwd.txt");
		if(file.exists()) {
			try {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write("Akash@1234");
				fileWriter.close();
				System.out.println("Password is written to the file");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				boolean status = file.createNewFile();
				if(status)
					System.out.println("File is created");
				else
					System.out.println("File already exists");
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write("Akash@1234");
				fileWriter.close();
				System.out.println("Password is written to the file");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
