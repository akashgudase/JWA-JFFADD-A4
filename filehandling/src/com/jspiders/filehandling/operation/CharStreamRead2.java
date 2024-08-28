package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharStreamRead2 {

	public static void main(String[] args) {

		File file = new File("pwd.txt");
		if (file.exists()) {
			try {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					System.out.println(scanner.nextLine());
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("File does not exist");

	}

}
