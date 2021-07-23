package com.algorithm.hashmap;

public class HashAlgorithm2 {
	
	/*
	 * 문제
	 * 
	 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
	 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
	 * 구조대 : 119
	 * 박준영 : 97 674 223
	 * 지영석 : 11 9552 4421
	 * 
	 * 
	 * 제한사항
	 * 
	 * phone_book의 길이는 1 이상 1,000,000 이하입니다.
	 * 각 전화번호의 길이는 1 이상 20 이하입니다.
	 * 
	 * 
	 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42577
	 * 
	 */
	
	class Solution2 {
	    public boolean solution(String[] phoneBook) {
	       for(int i=0; i<phoneBook.length-1; i++) {
	            for(int j=i+1; j<phoneBook.length; j++) {
	                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
	                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
	            }
	        }
	        return true;
	    }
	}
	
	class Solution3 {
	    public boolean solution(String[] s) {
	      
	    }
	}
}