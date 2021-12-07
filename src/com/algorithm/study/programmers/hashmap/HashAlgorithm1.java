package com.algorithm.study.programmers.hashmap;

import java.util.HashMap;

public class HashAlgorithm1 {

	/*
	 * 문제
	 * 
	 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
	 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
	 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 
	 * 제한사항
	 * 
	 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
	 * completion의 길이는 participant의 길이보다 1 작습니다.
	 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
	 * 참가자 중에는 동명이인이 있을 수 있습니다.
	 * 
	 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42576
	 * 
	 */
	public static void main(String[] args) {
		String[] arr1 = {"mislav", "stanko", "mislav", "ana"};
		String[] arr2 = {"stanko", "ana", "mislav"};
		
		//내 답안
		String answer1 = function1(arr1, arr2);
		System.out.println(answer1);
		
		//모법 답안
		String answer2 = function2(arr1, arr2);
		System.out.println(answer2);
		

	}
	
	public static String function1(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String player: completion) {			
			int value =1;
			if(map.containsKey(player)) {
				value = map.get(player);
				value += 1;
			}
			map.put(player, value);
		}
        
		for(String competent: participant) {
			if(map.containsKey(competent)) {
				int value = map.get(competent);
				if(value == 0) {
					return competent;
				}else {
					map.put(competent, value -1);
				}
			}else {
				return competent;
			}
		}
        
        return "something wrong";
	}
	
	public static String function2(String[] participant, String[] completion) {
		String answer = "";
		// 1단계 : 참여자를 키와 값의 형태로 만든다. 이름 : 수
		// 2단계 : 완주자를 가지고 -1을 한다.
		// 3단계 : 1인 사람이 답
		HashMap<String, Integer> map = new HashMap<>(); // 1-1. 자료 구조 준비!!!
		for (String name : participant) {
			// 없을 때 ==> 홍길동 : 0(기존값이 null이면 0) + 1, 있을 때 ==> 홍길동 : (기존값) + 1
			int su = map.getOrDefault(name, 0) + 1; // 2줄로 풀어쓰기
			map.put(name, su);
		}
		// System.out.println(map); // {leo=1, eden=1, kiki=1}
		for (String name : completion) {
			map.put(name, map.get(name) - 1);
		}
		// System.out.println(map); // {leo=1, eden=0, kiki=0}
		// System.out.println(map.keySet()); // [leo, eden, kiki]
		for (String name : map.keySet()) { // 키가 필요하다
			if (map.get(name) == 1) {
				answer = name;
				break; // 찾았으면 반복문 종료!!!
			}
		}
		return answer;	
	}
}
