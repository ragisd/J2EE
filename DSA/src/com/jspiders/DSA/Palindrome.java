package com.jspiders.DSA;

public class Palindrome {

	public static void main(String[] args) {
		String str = "litresd";
		int flag = 0;
		char[] arr;
		String str2 = "";
		
		arr = str.replace("\\s+", "").toCharArray();
		
		if(arr != null){
			for(int i = arr.length - 1; i >= 0; i--){
				str2 += arr[i];
			}
			
			System.out.println(str2);
			
			if(str2.equals(str)){
				flag = 1;
			}
		}
		
		if(flag == 1) {
			System.out.println(str + " is a palindrome string");
		}
		else {
			System.out.println(str + " is not a palindrome string");
		}
		
	}

}
