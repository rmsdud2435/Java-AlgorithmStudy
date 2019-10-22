package com.algorithm.intergrated;

public class IntergratedAlgorithm1 {

	/*
	 * 문제
	 * 
	 * 주어준 문자열에서 aaa 혹은 bbb가 포함되지 않는 문자열의 최대 길이를 구하라
	 * 
	 * 
	 * 출처 : Codility 문제중
	 * 
	 */
	
	public int solution3(String S) {
	        
		// write your code in Java SE 8
	    String tempS = S;
	    int maxDigit = 0;
	    boolean loopFlag = false;
	    	
	   	while(tempS.contains("aaa")||tempS.contains("bbb")){
	    	loopFlag = true;
	    		
	    	if(tempS.contains("aaa")&&tempS.contains("bbb")){
	    		if(tempS.indexOf("aaa") < tempS.indexOf("bbb")){
	        		if((tempS.indexOf("aaa") + 2) >= maxDigit){
	        			maxDigit = tempS.indexOf("aaa") + 2;
	        		}
	        		tempS = tempS.substring(tempS.indexOf("aaa")+1, tempS.length());
	    		}else{
	        		if((tempS.indexOf("bbb") + 2) >= maxDigit){
	        			maxDigit = tempS.indexOf("bbb") + 2;
	        		}
	        		tempS = tempS.substring(tempS.indexOf("bbb")+1, tempS.length());
	    		} 			
	    	}else if(tempS.contains("aaa")){
	    		if((tempS.indexOf("aaa") + 2) >= maxDigit){
	    			maxDigit = tempS.indexOf("aaa") + 2;
	    		}
	    		tempS = tempS.substring(tempS.indexOf("aaa")+1, tempS.length());
	    	}else{
	    		if((tempS.indexOf("bbb") + 2) >= maxDigit){
	    			maxDigit = tempS.indexOf("bbb") + 2;
	    		}
	    		tempS = tempS.substring(tempS.indexOf("bbb")+1, tempS.length());
	    	}
	   	}
	    	
	   	if(tempS.length() > maxDigit){
	   		maxDigit = tempS.length();
	   	}
	    	
	    if(loopFlag){
	    	return maxDigit;
	    }else{    		
	   		return S.length();
	   	}
	}
}


