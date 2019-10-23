package com.algorithm.intergrated;

import java.util.ArrayList;

public class IntergratedAlgorithm3 {
	
	/*
	 * 문제
	 * 
	 * 2행n열의 매트릭스가 존재한다고 하며 각 행열은 1또는 0의 값을 가지고 있다.
	 * U의 값은 1행의 열들의 합을 나타내며, L의 값의 2행의 열들의 합을 나타낸다.
	 * C배열은 각 열의 합을 나타낸다.
	 * L, U, C를 통해 매트릭스가 존재할 수 있는지 확인 후,
	 * 없다면 "IMPOSSIBLE"을, 있다면 해당 "1행형식,2행형식"의 값으로 출력하라
	 * 
	 * 
	 * 제한사항
	 * 
	 * 값은 다량으로 존재하며 하나의 값이라도 출력한다면 정답으로 인정
	 * 
	 * 
	 * 출처 : Codility 문제중
	 * 
	 */
		
	 public String solution(int U, int L, int[] C) {
		 // write your code in Java SE 8
	    int sum = 0;   	
	    int tempU = U;
	    int tempL = L; 	
	    String upperString = "";
		String lowerString = "";	
	   	for(int x : C){
	   		sum += x;
	   		
	   		if(x==2){
	   			upperString += "1";
	   			lowerString += "1";
	   			tempU -= 1;
	   			tempL -= 1;
	   		}else if(x==0){
	   			upperString += "0";
	   			lowerString	+= "0";
	   		}else{
	   			if(tempU>0){
		   			upperString += "1";
		   			lowerString	+= "0";
		   			tempU -= 1;
	    		}else{
		   			upperString += "0";
		   			lowerString	+= "1";
		   			tempL -= 1;
	    		}
	    	}
	    }
	    
	   	if(sum == (U + L)){
	   		return upperString + "," + lowerString;
	    }else{
	    	return "IMPOSSIBLE";
	    }	
	}
}