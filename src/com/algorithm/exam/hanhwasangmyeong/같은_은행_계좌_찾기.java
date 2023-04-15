package com.algorithm.exam.hanhwasangmyeong;


/**
 * 
 * 문제 설명
 * 
 * 문자열 배열을 받아 계좌 규칙의 정합성을 확인하고 같은 은행의 계좌대로 개수를 세서 다 내린차순으로 배열을 출력하라
 * 
 * 계좌의 정합성
 * '-'는 맨 앞,뒤로 올 수 없다
 * '--'와 같이 대시를 연속으로 사용할 수 없다.
 * 숫자는 11~14개로 이루어져야한다.
 * '-'는 0~3개로 이루어져있다.
 * '-'와 숫자로 이루어져야한다. 
 *
 * 같은 은행 계좌 판단
 * 숫자개수-숫자개수-숫자개수의 규칙이 같으면 같은 은행
 * ex) 123-1256-123와 435-1233-743는 같은 은행, 123-1256-123와 4351-133-743, 4351233743는 다른 은행
 *
 */

import java.util.*;

public class 같은_은행_계좌_찾기 {
	
	public static void main(String[] args) {
		
		//String s = "1011";	
		//String s = "0110011";	
		//String s = "000111";			
		//String s = "00001";			
		//System.out.println(solution(s));

	}
	
	public static int[] solution(String[] accounts) {
		
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		for(String acountNumber: accounts) {
			if(CheckAccountValid(acountNumber)) {
				String key = "";
				String[] tempStr = acountNumber.split("-");
				for(String reg: tempStr) {
					key = key + Integer.toString(reg.length());
				}
				if(hashmap.containsKey(key)) {
					int value = hashmap.get(key);
					hashmap.put(key,value+1);
				}else {
					hashmap.put(key,1);
				}
			}
		}
		 
		Collection<Integer> collection = hashmap.values();
		
		int[] answer = collection.stream().mapToInt(Integer::intValue).toArray();
		//추후 내림차순으로 수정
		Arrays.sort(answer);
		
		return answer;
	}
	   
	
	public static boolean CheckAccountValid(String acountNumber){
		if(acountNumber.charAt(0)=='-') {
			return false;
		}
		if(acountNumber.charAt(acountNumber.length()-1)=='-') {
			return false;
		}
		if(acountNumber.indexOf("--")>-1) {
			return false;
		}
		
		int dashCount = 0;
		int digitCount = 0;
		for(int i = 0;i < acountNumber.length(); i++) {
			char digit = acountNumber.charAt(i);
			if(digit>='0' && digit<='9') {
				digitCount++;
			}else if(digit=='-'){
				dashCount++;
			}else {
				return false;
			}
		}
		if(dashCount > 3) {
			return false;
		}
		if(digitCount<11 || digitCount>14) {
			return false;
		}
		
		return true;
	}
}