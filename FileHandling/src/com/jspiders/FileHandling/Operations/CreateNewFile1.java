package com.jspiders.FileHandling.Operations;

import java.io.File;
import java.io.IOException;

public class CreateNewFile1 {

	public static void main(String[] args) {
		File file = new File("E:\\eclipse\\File\\demo.txt");
		
		try {
			boolean status = file.createNewFile();
			if(status) {
				System.out.println("File Created");
			} else {
				System.out.println("File not created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
