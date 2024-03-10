package com.jspiders.FileHandling.Operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamRead {

	public static void main(String[] args) throws IOException {
		File file = new File("E:\\eclipse\\File\\Demo.txt");
		
		if(file.exists()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			System.out.println(fileInputStream.read());
			fileInputStream.close();
			System.out.println("data is fetched from file");
		}
		else {
			System.out.println("file does not exist");
		}
	}

}
