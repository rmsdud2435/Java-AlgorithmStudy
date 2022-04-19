package com.algorithm.study.programmers.test;

import java.util.*;

public class 신고_결과_받기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        HashMap<String, ArrayList<String>> hashmap = new HashMap<String, ArrayList<String>>();
        for(String id: id_list){
            ArrayList<String> list = new ArrayList<String>();
            list.add(id);
        }
        
        for(String contents: report){
            String[] content = contents.split(" ");
            ArrayList<String> list2 = hashmap.get(content[0]);
            if(!list2.contains(content[1])){
                list2.add(content[1]);
                hashmap.put(content[0],list2);
            }           
        }
        System.out.println(hashmap);
        return answer;
    }

}
