package com.jspiders.SerializationAndDeserialization.Deserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.jspiders.SerializationAndDeserialization.object.User;

public class Deserialization {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		File file = new File("E:\\eclipse\\File\\Demo.txt");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		User user = (User)objectInputStream.readObject();
		System.out.println("Object Deserialized");
		objectInputStream.close();
		fileInputStream.close();
		
		
	}
}
