package com.algorithm.sort;

import java.util.*;


public class SortAlgorithm2 {

	/*
	 * 문제
	 * 
	 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
	 * 0예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
	 * 00 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한사항
	 * 
	 * numbers의 길이는 1 이상 100,000 이하입니다.
	 * numbers의 원소는 0 이상 1,000 이하입니다.
	 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
	 * 
	 * 
	 * 입출력 예
	 * 
	 * numbers	return
	 * [6, 10, 2]	"6210"
	 * [3, 30, 34, 5, 9]	"9534330"
	 * 
	 * https://programmers.co.kr/learn/courses/30/lessons/42746
	 * 
	 */

	public static void main(String[] args) {
    	// numbers	return
    	// [6, 10, 2]	"6210"
    	// [3, 30, 34, 5, 9]	"9534330"
		int[] numbers = {6, 10, 2};
		System.out.println(solution(numbers));
		int[] numbers2 = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers2));
	}// main

	// 내 답안
	static public String solution(int[] numbers) {
        String answer = "";

        ArrayList<String> tempArray = new ArrayList<String>();
        
        for(int a: numbers){
            tempArray.add(String.valueOf(a));            
        }        
        
        Collections.sort(tempArray, new NewSort());
        
        if(tempArray.get(0).equals("0")){return "0";}
        for(String temp: tempArray){
           answer +=  temp;
        }
        
        return answer;
    }

	// 모범 답안
	static public String solution2(int[] numbers) {
    	// 1단계 : 정수 배열을 문자열 배열로 변경
    	// 2단계 : 정렬 규칙을 새로 정의 : s1 + s2 비교 s2 + s1 큰 값이 되도록 정렬
        String answer = "";
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
			strArr[i] = ""+numbers[i]; // String.valueOf(numbers[i]);
		}
        Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2+s1).compareTo(s1+s2); // 2개를 더해서 더 큰쪽이 우선 순위가 되도록 설정
			}
		});
        for (int i = 0; i < strArr.length; i++) {
			answer += strArr[i];
		}
        return answer;
    }// solution
}

class NewSort implements Comparator<String> { 
	@Override 
	public int compare(String a, String b) {
        if(Integer.parseInt(a+b) > Integer.parseInt(b+a)){
            return -1;
        }else if(Integer.parseInt(a+b) < Integer.parseInt(b+a)){
            return 1;
        }else{
            return 0;
        }
	} 
}