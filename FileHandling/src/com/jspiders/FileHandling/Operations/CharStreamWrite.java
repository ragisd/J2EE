package com.jspiders.FileHandling.Operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamWrite {

	public static void main(String[] args) throws IOException {
		File file = new File("E:\\eclipse\\File\\Demo.txt");
		
		if(file.exists()) {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("Java is programming language");
			System.out.println("data is written into the file");
			fileWriter.close();
		}
		else {
			boolean status = file.createNewFile();
			if(status) {
				System.out.println("file is created");
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write("Java is programming language");
				System.out.println("data is written into the file");
				fileWriter.close();
			}
			else {
				System.out.println("file is not created");
			}
		}

	}

}
