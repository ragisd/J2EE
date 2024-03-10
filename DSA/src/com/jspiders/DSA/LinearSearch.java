package com.jspiders.DSA;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array elements ");
		
		int[] arr = new int[5];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		
		System.out.println("Enter the number you want to find ");
		int num = scanner.nextInt();
		boolean flag = false;
		
		for(int i = 0; i < arr.length; i++) {
			if(num == arr[i]) {
				System.out.println(i);
				flag = true;
			}
		}
		if(!flag) {
			System.out.println(-1);
		}
		
	}

}
