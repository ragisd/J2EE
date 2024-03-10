package com.jspiders.FileHandling.Operations;

import java.io.File;

public class FileInfo {

	public static void main(String[] args) {
		File file = new File("E:\\eclipse\\File\\Demo.txt");
		
		if(file.exists()) {
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length());
			
			if(file.canWrite()) {
				System.out.println("File is writable");
			}
			else {
				System.out.println("file is not writable");
			}
			
			if(file.canRead()) {
				System.out.println("File is readable");
			}
			else {
				System.out.println("file is not readable");
			}
			
			if(file.canExecute()) {
				System.out.println("File is Executable");
			}
			else {
				System.out.println("file is not Executable");
			}
		}
		else {
			System.out.println("file does not exist");
		}
	}

}
