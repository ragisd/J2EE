package com.jspiders.hashmap.hashmap1;

import java.util.HashMap;

public class Hashmap1 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> emps = new HashMap<String, Integer>();
		
		emps.put("john", 2345);
		emps.put("carl", 9876);
		emps.put("peter", 19832);
		
		System.out.println(emps);
		
		emps.put("kari", 2345);
		emps.put("carl", 7777);

		System.out.println(emps);
		//values can be duplicated but keys cannot be duplicated
		
		System.out.println(emps.get("carl"));
		System.out.println(emps.containsKey("john"));
		System.out.println(emps.containsValue(2345));
		System.out.println(emps.replace("carl", 8743));
		
		emps.putIfAbsent("steve", 3452);
		
		System.out.println(emps);
		
		emps.remove("steve");
		
		System.out.println(emps.values());
	}

}
