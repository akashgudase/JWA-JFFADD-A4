package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamRead {

	public static void main(String[] args) {

		String pwd = "";
		File file = new File("pwd.txt");
		if (file.exists()) {
			try {
				FileReader fileReader = new FileReader(file);
				int ascii = -1;
				while((ascii = fileReader.read()) != -1) {
					pwd += (char)ascii;
				}
				fileReader.close();
				System.out.println(pwd);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("File does not exist");

	}

}
