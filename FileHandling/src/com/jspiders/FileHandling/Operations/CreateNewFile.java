package com.jspiders.FileHandling.Operations;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {

	public static void main(String[] args) {
		File file = new File("Demo.txt");
		
		try {
			boolean status = file.createNewFile();
			if(status) {
				System.out.println("File created");
			} else {
				System.out.println("file not created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
