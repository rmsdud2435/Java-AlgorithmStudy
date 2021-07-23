package com.algorithm.hashmap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
		// TODO Auto-generated method stub
		String[] arr1 = {"mislav", "stanko", "mislav", "ana"};
		String[] arr2 = {"stanko", "ana", "mislav"};
		
		String answer = function(arr1, arr2);
		System.out.println(answer);
		
		HashMap<Character, Integer> ma= new HashMap<Character, Integer>();
		for(Character a :ma.keySet()) {
			
		}
		

	}
	
	public static String function(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String player: completion) {			
			int value =1;
			if(map.containsKey(player)) {
				value = map.get(player);
				value += 1;
			}
			map.put(player, value);
		}
		System.out.println(map);
        
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
        	
		ArrayList<Integer> array = new ArrayList<Integer>();
		//array.remove(index)
		
        return "something wrong";
		
		
	       
        for(int a=2; a<=n; a++){
            int count =0;
            for(int b=1; b<=a/2; b++){
                if(a%b==0){
                    count ++;
                    if(count>1){
                        break;
                    }
                }
            }
            
            if(count==1){
                answer++;
            }
        }
	}
}
