package com.algorithm.study.programmers.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashAlgorithm2 {

	/*
	 * 문제
	 * 
	 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다. 전화번호가 다음과 같을 경우, 구조대
	 * 전화번호는 영석이의 전화번호의 접두사입니다. 구조대 : 119 박준영 : 97 674 223 지영석 : 11 9552 4421
	 * 
	 * 
	 * 제한사항
	 * 
	 * phone_book의 길이는 1 이상 1,000,000 이하입니다. 각 전화번호의 길이는 1 이상 20 이하입니다.
	 * 
	 * 
	 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42577
	 * 
	 */
	public static void main(String[] args) {
		// phone_book return
		// ["119", "97674223", "1195524421"] false
		// ["123","456","789"] true
		// ["12","123","1235","567","88"] false
		String[] phone_book = { "119", "97674223", "1195524421" };
		System.out.println(solution1(phone_book));
		String[] phone_book2 = { "123", "456", "789" };
		System.out.println(solution1(phone_book2));
		String[] phone_book3 = { "12", "123", "1235", "567", "88" };
		System.out.println(solution1(phone_book3));
	}

	//개인 답안
	public static boolean solution1(String[] phone_book) {
		HashMap<String, Integer> temMap = new HashMap<>();
        for(String phone_number : phone_book){
        	Set set = temMap.keySet();
        	Iterator iterator = set.iterator();
        	while(iterator.hasNext()){
        		Object object = iterator.next();
        		int result = phone_number.indexOf(object.toString());
        		if(result == 0){
        			return false;
        		}
                
                result = object.toString().indexOf(phone_number);
        		if(result == 0){
        			return false;
        		}
        	}
        	temMap.put(phone_number, 0);
        }
        return true;
	}

	//모범 답안
	public boolean solution2(String[] phoneBook) {
        boolean answer = true;
        // 1단계 : 정렬
        // 2단계 : 접두어 ==> 스트링_객체.startsWith 메소드 사용
        // System.out.println("before:" + Arrays.toString(phone_book) );
        Arrays.sort(phoneBook); // Arrays.sort 는 배열 정렬시 사용, 문자열의 각 자리로 비교 정렬
        // System.out.println("after:" + Arrays.toString(phone_book) );
        for (int i = 0; i < phoneBook.length - 1; i++) { // 마지막은 다음과 비교가 안되기 때문에 -1함. 
        	// 예) "1195524421".startsWith("119"), 다음_문자열이 이전문자열로 시작하는가? 체크
			if(phoneBook[i+1].startsWith(phoneBook[i])) {
				answer = false; // 하나라도 맞으면 false 담고
				break; // 종료
			}
		}
        return answer;
	}
}