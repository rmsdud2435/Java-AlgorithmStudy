package com.algorithm.study.ktds;

import java.util.*;

public class E02_로또번호생성기 {
    public static void main(String[] args) {
    	//1~45 중에 중복없이 6개 담는다.
    	//정렬
    	//합이 100~170인것만 사용한다.
    	//5게임 5천원
    	ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
    	while(answer.size() < 5) {		
    		Random randomAlgo = new Random();
    		TreeSet<Integer> lottoSet = new TreeSet<Integer>();
    		while(lottoSet.size() < 6) {
    			lottoSet.add(randomAlgo.nextInt(44)+1);
    		}
    		ArrayList<Integer> lottoArray = new ArrayList<Integer>();
    		int totalCount=0;
    		while(lottoSet.size() > 0) {
    			int tempNum = lottoSet.pollFirst();
    			totalCount += tempNum;
    			lottoArray.add(tempNum);	
    		}
    		
    		if(totalCount>=100&&totalCount <= 170) {
    			answer.add(lottoArray);
    		}
    	}
    	System.out.println(answer.toString());
	}// main
}// end