package com.jspiders.DSA;

import java.util.Scanner;

public class BubbleSort2{
	
		public static void main(String[] args) {
		    int[] arr = new int[5];
		    Scanner scanner = new Scanner(System.in);
		    for(int p = 0; p < arr.length; p++){
		        arr[p] = scanner.nextInt();
		    }
		    
	        int n = arr.length;
	        int temp;
	        for(int i = 0; i < n-1; i++){
	            for(int j = 1; j <= n-i-1; j++){
	                if(arr[j] > arr[j+1]){
	                    temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
	                
	            }
	           
	        }
	        
	        System.out.println(arr);
		}
}
