package com.algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class HeapAlgorithm1 {

	/*
	 * 문제
	 * 
	 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해
	 * Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
	 * 
	 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	 * 
	 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다. Leo가 가진 음식의 스코빌 지수를 담은 배열
	 * scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를
	 * return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 
	 * 제한사항
	 * 
	 * scoville의 길이는 1 이상 1,000,000 이하입니다. K는 0 이상 1,000,000,000 이하입니다. scoville의
	 * 원소는 각각 0 이상 1,000,000 이하입니다. 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return
	 * 합니다.
	 * 
	 * 
	 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42626
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = { 1, 2, 3, 9, 10, 12 };

		int result = solution1(scoville, 7);
		System.out.println(result);
	}

	//개인 답안
	public static int solution1(int[] scoville, int K) {
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

	//모범 답안
	public static int solution2(int[] scoville, int K) {
		// 우선순위큐 : PriorityQueue 사용 : 자동 정렬되는 큐
		// Queue : 비유(일방통행 도로), FIFO 구조(First In First Out)
		// 추가 메소드인 add와 offer 의 차이 : 예외 발생 시 add는 예외 리턴, offer는 실패의 뜻인 false 리턴
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			queue.offer(scoville[i]);
		}
		// System.out.println(queue); // [1, 2, 3, 9, 10, 12]
		while (queue.peek() < K) { // K보다 작으면 반복, peek : 맨앞의 데이터를 확인만 함!
			if (queue.size() == 1) {
				return -1;
			}
			int first = queue.poll(); // poll : 맨앞의 데이터를 꺼냄! 예) 1 리턴
			int second = queue.poll();// 예) [2, 3, 9, 10, 12], 2 리턴
			queue.offer(first + (second * 2)); // 1 + (2*2) ==> 5
			// [5, 3, 9, 10, 12] ==> 정렬 [3, 5, 9, 10, 12]
			// 두번째 반복시 3 + (5*2) ==> 13, [13, 9, 10, 12] ==> 정렬 [9, 10, 12, 13]
			answer++;
		} // while
		return answer;
	}// solution
}
