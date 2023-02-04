package com.algorithm.exam.elevenbunga;

import java.util.HashMap;

public class Test3 {
	public static void main(String[] args) {
		
		
		//String s = "hello";String cipher = "cbvvu";
		String s = "hello";String cipher = "bbvmu";
		//String s = "world";String cipher = "abcde";
		
		System.out.println(solution(s, cipher));

	}


	public static boolean solution(String s, String cipher) {
		HashMap<String ,String> hashmap = new HashMap<String ,String>();
		for(int i = 0; i < s.length(); i++) {
			String key = String.valueOf(s.charAt(i));
			String value = String.valueOf(cipher.charAt(i));
			if(hashmap.containsKey(key)) {
				if(!hashmap.get(key).equals(value)) {
					return false;
				}
			}else {
				hashmap.put(key,value);
			}
		}
		
		return true;
	}
}

