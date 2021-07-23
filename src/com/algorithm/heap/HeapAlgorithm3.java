package com.algorithm.heap;

import java.util.*;

/*
 * 문제
 * 
 * 이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
 *
 * 명령어		수신 탑(높이)
 * I 숫자		큐에 주어진 숫자를 삽입합니다.
 * D 1		큐에서 최댓값을 삭제합니다.
 * D -1		큐에서 최솟값을 삭제합니다.
 * 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 
 * 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 * 
 * 
 * 제한사항
 * 
 * operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
 * operations의 원소는 큐가 수행할 연산을 나타냅니다.
 * 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
 * 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
 * 
 * 
 * 입출력 예
 * 
 * operations	return
 * ["I 16","D 1"]	[0,0]
 * ["I 7","I 5","I -5","D -1"]	[7,5]
 * 
 * 
 * 입출력 예 설명
 * 
 * 16을 삽입 후 최댓값을 삭제합니다. 비어있으므로 [0,0]을 반환합니다.
 * 7,5,-5를 삽입 후 최솟값을 삭제합니다. 최대값 7, 최소값 5를 반환합니다.
 * 
 * 
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42628
 * 
 * 
 */

class HeapAlgorithm3 {
	
	public static void main(String[] args) {
		
    	// operations	return
    	// ["I 16","D 1"]	[0,0]
    	// ["I 7","I 5","I -5","D -1"]	[7,5]
		String[] operations = {"I 16","D 1"};
		System.out.println( Arrays.toString(solution(operations) ) );
		String[] operations2 = {"I 7","I 5","I -5","D -1"};
		System.out.println( Arrays.toString(solution(operations2) ) );
	}
	
	static public int[] solution(String[] operations) {
    	// 1단계 : PriorityQueue 2 개, 하나는 오름차순, 나머지 하나는 내림차순
    	// 2단계 : 예) "I 16".split 해서 처리해봄!
    	PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(); // 최소 큐
    	PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder()); //최대 큐
        for (int i = 0; i < operations.length; i++) {
			String[] token = operations[i].split(" "); // "I 16" ==> token[0] : "I", token[1] : "16"
			switch (token[0]) {
			case "I":
				int num = Integer.parseInt(token[1]); // "16" ==> 16
				minQueue.add(num);
				maxQueue.add(num);
				break;
			case "D":
				if(! minQueue.isEmpty()) { // 비어있지 않으면
					if("1".equals(token[1])) { // 최대값 삭제
						int max = maxQueue.poll(); // 최대 큐에서 가장 큰 값 끄집어 낸다.
						minQueue.remove(max); // 최소 큐에서도 삭제
					} else { // "-1", 최소값 삭제
						int min = minQueue.poll(); // 최소 큐에서 가장 작은 값 끄집어 낸다.
						maxQueue.remove(min); // 최대 큐에서도 삭제
					}
				}// if
				break;
			}// switch
		}// for
    	int[] answer = new int[2];
    	if(minQueue.isEmpty()) { // [0,0]
    		answer[0] = 0;
    		answer[1] = 0;
    	} else { // 예) [7,5]
    		answer[0] = maxQueue.peek(); // peek 은 확인만 함!
    		answer[1] = minQueue.peek();
    	}
        return answer;
    }// solution} 
}
