package com.algorithm.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashAlgorithm4 {
	
	/*
	 * 문제
	 * 
	 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
	 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
	 * 
	 * 종류      이름
	 * 얼굴    동그란 안경, 검정 선글라스
	 * 상의    파란색 티셔츠
	 * 하의    청바지
	 * 겉옷    긴 코트
	 * 
	 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한사항
	 * 
	 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
	 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
	 * 같은 이름을 가진 의상은 존재하지 않습니다.
	 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
	 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
	 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
	 * 
	 * 
	 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42578
	 * 
	 */

	public static void main(String[] args) {
		// clothes	return
		// [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]	5
		// [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]	3
		String[][] clothes = {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
		System.out.println(solution(clothes));
		String[][] clothes2 = {{"crowmask", "face"},{"bluesunglasses", "face"},{"smoky_makeup", "face"}};
		System.out.println(solution(clothes2));
	}
	
	// 내 답안
	static public int solution(String[][] clothes) {
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		for (String clothe[] : clothes) {
			if (!hashmap.containsKey(clothe[1])) {
				hashmap.put(clothe[1], 2);
			} else {
				hashmap.put(clothe[1], hashmap.get(clothe[1]).intValue() + 1);
			}
		}

		Set set = hashmap.keySet();
		Iterator iterator = set.iterator();

		int choices = 1;
		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			choices = choices * hashmap.get(key).intValue();
		}

		choices -= 1;
		return choices;
	}
	
	//모범 답안
	static public int solution2(String[][] clothes) {
        int answer = 1;
        // 1단계 : 키와 값의 형태가 코딩이 쉽겠다 ==> 자료구조 선택 : HashMap
        // 2단계 : 키가 존재하지 않으면 1, 존재하면 기존값+1
        HashMap<String, Integer> map = new HashMap<String, Integer>(); // 종류 : 갯수
        for (int i = 0; i < clothes.length; i++) { // 예) ["yellowhat", "headgear"] ==> [0, 1]
			// 현재 의상의 종류가 존재하지 않으면 1개를 넣고, 존재하면 기존값 + 1을 넣는다
        	if(map.get(clothes[i][1]) == null) { // 예) clothes[i][1] 는 "headgear"
        		map.put(clothes[i][1], 1);
        	} else {
        		map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        	}
		}
        System.out.println(map); // {eyewear=1, headgear=2}
        for (String key : map.keySet()) {
			answer *= (map.get(key) + 1); // +1은 착용 안하는 경우 포함
		}
        return answer - 1; // -1은 반드시 하나는 착용(둘 다 착용안하는 경우를 뺀다)
    }
}
