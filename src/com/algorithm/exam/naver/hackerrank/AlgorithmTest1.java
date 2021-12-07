package com.algorithm.exam.naver.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * 문제
 * 주어진 정수 배열에 대해 우선적으로 이진 표현시 1의 개수에 대해 오름차순 정렬 후, 1의 개수가 같을 시 십진수의 오름차순으로 정렬해라
 * 
 * https://hackerrankforwork.com>
 **/

public class AlgorithmTest1 {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		System.out.println(cardinalitySort(nums));

	}
	
	public static List<Integer> cardinalitySort(List<Integer> nums) {
		// Write your code here
		List<Integer> answer = new ArrayList<Integer>();
		
		HashMap<Integer, List<Integer>> hashmap = new HashMap<Integer, List<Integer>>();
		List<Integer> keyList = new ArrayList<Integer>();
		for(int i = 0; i < nums.size(); i++){
			int num = nums.get(i);
			String numStr = Integer.toBinaryString(num);
			Integer key = 0;
			for(int j =0; j < numStr.length(); j++){
				if(numStr.charAt(j) == '1'){
					key ++;
				}
			}
			
			List<Integer> tempList = new ArrayList<Integer>();
			if(hashmap.containsKey(key)){
				tempList = hashmap.get(key);
			}else{
				keyList.add(key);
			}
			tempList.add(num);
			hashmap.put(key, tempList);
		}
		
		int[] keyArr = new int[keyList.size()];
		for(int i = 0; i < keyList.size(); i++){
			keyArr[i] = keyList.get(i);
		}
		Arrays.sort(keyArr);
		for(int key: keyArr){
			List<Integer> tempList = hashmap.get(key);
			int[] valueArr = new int[tempList.size()];
			for(int i = 0; i < tempList.size(); i++){
				valueArr[i] = tempList.get(i);
			}
			Arrays.sort(valueArr);
			for(Integer value: valueArr){
				answer.add(value);
			}
		}
		
		return answer;
		
	}
}
