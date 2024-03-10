package com.jspiders.DSA;

public class BubbleSort {

	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {76, 85, 92, 53, 71, 38, 39};
		
		bubbleSort(arr);
		System.out.println("Array sorted");
		for(int num : arr) {
			System.out.println(num + " ");
		}
	}

}
