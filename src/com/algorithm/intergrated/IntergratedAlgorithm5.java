package com.algorithm.intergrated;

import java.util.ArrayList;

public class IntergratedAlgorithm5 {
	
	/*
	 * 문제
	 * 
	 * {1,2,3,4,5} 부분집합을 모두 출력하라
	 * 
	 * 
	 * 출처 : 면접 예상 질문 중
	 * 
	 */
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = {1,2,3,4,5};
		
		mySolution(intArray);
		
	}
	
	public static void mySolution(int[] intArray){
		int maxDept = intArray.length-1;
		int currentDept = 0;
		ArrayList<Integer> currentArray = new ArrayList<Integer>();
		
		printSets(intArray, currentArray, currentDept, maxDept);
	}
	
	public static void printSets(int[] intArray, ArrayList<Integer> currentArray, int currentDept, int maxDept){
		
		if(maxDept == currentDept){
			System.out.println(currentArray);
			return;
		}
		
		int element = intArray[currentDept];
		currentDept++;
		
		//역시나 참조형식이라 꼬이네 나중에 정리필요할듯
		ArrayList<Integer> leftCurrentArray 	= new ArrayList<Integer>(currentArray);
		ArrayList<Integer> rightCurrentArray 	= new ArrayList<Integer>(currentArray);
		
		printSets(intArray, leftCurrentArray, currentDept, maxDept);
			
		rightCurrentArray.add(element);
		printSets(intArray, rightCurrentArray, currentDept, maxDept);
	}
}