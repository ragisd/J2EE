package com.jspiders.FileHandling.Operations;

import java.io.File;

public class DeleteFile {

	public static void main(String[] args) {
		File file = new File("Demo.txt");
		
		if(file.exists()) {
			boolean status = file.delete();
			if(status) {
				System.out.println("File Deleted");
			} else {
				System.out.println("file not deleted");
			}
		} else {
			System.out.println("File does not exist");
		}
	}

}
