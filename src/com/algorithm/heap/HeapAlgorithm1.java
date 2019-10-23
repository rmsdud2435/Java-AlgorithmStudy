package com.algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class HeapAlgorithm1 {

	/*
	 * 문제
	 * 
	 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
	 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
	 * 
	 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	 * 
	 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
	 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 
	 * 제한사항
	 * 
	 * scoville의 길이는 1 이상 1,000,000 이하입니다.
	 * K는 0 이상 1,000,000,000 이하입니다.
	 * scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
	 * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
	 * 
	 * 
	 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42626
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {1, 2, 3, 9, 10, 12};
			
		int result = solution7(scoville,7);
		System.out.println(result);
	}

	public static int solution7(int[] scoville, int K) {	
		PriorityQueue<Integer> scovilleQueue = new PriorityQueue<Integer>();		
		for(int spice : scoville){
			scovilleQueue.add(spice);
		}
		
		int count = 0;
		boolean successFlag = false;
		
		if(scovilleQueue.peek() >= K ){
			successFlag = true;
		}else{			
			while(scovilleQueue.size() > 1){
				count ++;
				int leastSpicy = scovilleQueue.poll();
				int lessSpicy = scovilleQueue.poll();
				int newSpice = leastSpicy + lessSpicy*2;
				scovilleQueue.add(newSpice);
				
				if(scovilleQueue.peek() >= K){
					successFlag = true;
					break;
				}
			}
		}
		
		if(successFlag){			
			return count;
		}else{
			return -1;
		}
	} 
	
	public static int solution8(int[] scoville, int K) {
		
		int count = 0;
		boolean successFlag = false;
		
		while(scoville.length > 0){
			Arrays.sort(scoville);

			if(K <= scoville[0]){
				successFlag = true;
				break;
			}else{
				if(scoville.length == 1 ){
					break;
				}
				int leastSpicy 	= scoville[0];
			   	int lessSpicy 	= scoville[1];
			   	int result 		= leastSpicy + lessSpicy*2;
			   	
			   	scoville = Arrays.copyOfRange(scoville, 1, scoville.length);
			   	scoville[0] = result;
			}
			
		   	count++;
	    }
		
		if(successFlag){			
			return count;
		}else{
			return -1;
		}
	}  
}




