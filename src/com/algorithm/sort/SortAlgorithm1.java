package com.algorithm.sort;

import java.util.*;


public class SortAlgorithm1 {

	/*
	 * 문제
	 * 
	 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
	 * 
	 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면 array의 2번째부터 5번째까지
	 * 자르면 [5, 2, 6, 3]입니다. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다. 2에서 나온 배열의 3번째 숫자는
	 * 5입니다. 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든
	 * 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	 * arrangement의 여는 괄호와 닫는 괄호는 항상 쌍을 이룹니다.
	 * 
	 * 
	 * 제한사항
	 * 
	 * array의 길이는 1 이상 100 이하입니다. array의 각 원소는 1 이상 100 이하입니다. commands의 길이는 1 이상 50
	 * 이하입니다. commands의 각 원소는 길이가 3입니다.
	 * 
	 * 입출력 예
	 * 
	 * array commands return [1, 5, 2, 6, 3, 7, 4] [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
	 * [5, 6, 3]
	 * 
	 * 입출력 예 설명
	 * 
	 * [1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
	 * [1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다. [1, 5, 2,
	 * 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
	 * 
	 * 
	 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42748
	 * 
	 */

	public static void main(String[] args) {
		// array commands return
		// [1, 5, 2, 6, 3, 7, 4] [[2, 5, 3], [4, 4, 1], [1, 7, 3]] [5, 6, 3]
		// 케이스1 : [2, 5, 3] ==> 5, 2번째부터 5번째까지 뽑고 정렬해서 3번째
		// 케이스2 : [4, 4, 1] ==> 6, 4번째부터 4번째까지 뽑고 정렬해서 1번째
		// 케이스3 : [1, 7, 3] ==> 3, 1번째부터 7번째까지 뽑고 정렬해서 3번째
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		System.out.println(Arrays.toString(solution2(array, commands)));
	}// main

	// 내 답안
	static public int[] solution2(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for (int item : array) {
			arrayList.add(item);
		}

		int index = 0;
		for (int[] item : commands) {
			List<Integer> tempArray = new ArrayList<Integer>();
			for (int i = item[0] - 1; i < item[1]; i++) {
				tempArray.add(arrayList.get(i));
			}
			Collections.sort(tempArray, new AscendingInteger());
			int tempInt = tempArray.get(item[2] - 1);
			answer[index] = tempInt;
			index++;
		}
		return answer;
	}

	// 모범 답안
	static public int[] solution(int[] array, int[][] commands) {
		// 1. 2차원 배열을 다룰 수 있는가?
		// 2. 정렬을 할 수 있는가? : Arrays.sort( 배열 )
		int[] answer = new int[commands.length]; // new int[3];
		for (int m = 0; m < commands.length; m++) {
			// System.out.println( Arrays.toString( commands[i] ) );
			// [2, 5, 3]
			int i = commands[m][0]; // 2
			int j = commands[m][1]; // 5
			int k = commands[m][2]; // 3
			int[] tempArr = Arrays.copyOfRange(array, i - 1, j); // 인덱스(i-1, j) ==> (1,5) ==> 1,2,3,4
			Arrays.sort(tempArr); // 정렬
			answer[m] = tempArr[k - 1]; // 인간 : 3번째, 컴퓨터 인덱스 2 (k-1 즉 3-1)
		} // for
		return answer;
	}
}

class AscendingInteger implements Comparator<Integer> { 
	@Override 
	public int compare(Integer a, Integer b) { 
		return a.compareTo(b); 
	} 
}