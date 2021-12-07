package com.algorithm.study.programmers.intergrated;

import java.util.ArrayList;

public class IntergratedAlgorithm4 {
	
	/*
	 * 문제
	 * 
	 * 1부터 100까지의 수 중에서 8이 들어간 횟수를 파악하시오
	 * 
	 * 
	 * 출처 : 면접 예상 질문 중
	 * 
	 */
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = new int[100];
		for(int i = 0; i < 100; i++){
			intArray[i] = i+1;
		}
		
		System.out.print(mySolution(intArray));

		
		
	}
	
	public static int mySolution(int[] intArray){
		int answer = 0;
		for(int element: intArray){
			String elementStr = String.valueOf(element);
			char[] StrArray = elementStr.toCharArray();
			for(char a: StrArray){
				if('8' == a){
					answer++;
				}
			}
		}
		return answer;
	}
}