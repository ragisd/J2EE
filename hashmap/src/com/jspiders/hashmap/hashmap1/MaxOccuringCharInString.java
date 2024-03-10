package com.jspiders.hashmap.hashmap1;

import java.util.HashMap;
import java.util.Map.Entry;

public class MaxOccuringCharInString {

	public static void main(String[] args) {
		
		String str = "I would love to visit Japan.";
		char[] charArray = str.replaceAll("\\s+", "").toLowerCase().toCharArray();
		
		System.out.println(charArray);
		
		HashMap<Character, Integer> charCountMap = new HashMap<>();
		
		for(char c : charArray) {
			if(charCountMap.containsKey(c)) {
				charCountMap.put(c, charCountMap.get(c)+1);
			}
			else {
				charCountMap.put(c, 1);
			}
		}
		
		int maxValue = 0;
		char maxChar = 0;
		char[] arr = new char[3];
		
		for(Entry<Character, Integer> entry : charCountMap.entrySet()) {
			if(entry.getValue() >= maxValue) {
				maxValue = entry.getValue();
				maxChar = entry.getKey();
			}
			System.out.println(entry);
		}
		
		System.out.println(charCountMap);
		System.out.println("Most frequent character : " + maxChar + " : " + maxValue);
		
		
	}

}
