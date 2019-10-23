package com.algorithm.intergrated;

import java.util.ArrayList;

public class IntergratedAlgorithm2 {
	
	/*
	 * 문제
	 * 
	 * 다음 트리 구조를 가진 Tree클래스에 관하여 연결되는 node의 최대 수를 구하라
	 * 
	 * 
	 * 제한사항
	 * 
	 * 이미 x값을 지닌 Tree 인스턴스를 지났다면 해당 값을 가진 Tree는 갈 수 없다.
	 * Tree 클래스 내의 l, r 변수가 null일 시, 트리형태의 끝임을 나타낸다.
	 * 
	 * 
	 * 출처 : Codility 문제중
	 * 
	 */
	
	class Tree {
		  public int x;
		  public Tree l;
		  public Tree r;
	}

	class Solution5 {
	    public int solution(Tree T) {
	        // write your code in Java SE 8	
	    	return recursiveFuntion(new ArrayList<Integer>(), T);
	}
	    
	public int recursiveFuntion(ArrayList<Integer> storage, Tree T){
		
	    	ArrayList<Integer> tempStorage = new ArrayList<Integer>(storage);
	    	
	    	if(tempStorage.contains(T.x)){
	    		return tempStorage.size();
	    	}else{
	    		tempStorage.add(T.x);
	    		
	        	int leftLength = 0;
	        	int rightLength = 0;
	        	if(T.l == null){
	        		leftLength = tempStorage.size();
	        	}else{
        			leftLength = recursiveFuntion(tempStorage, T.l);
        		}
        	
        		if(T.r == null){
        			rightLength = storage.size();
        		}else{
        			rightLength = recursiveFuntion(tempStorage, T.r);
        		}
        	
        		if(leftLength > rightLength){
        			return leftLength;
        		}else{
        			return rightLength;
        		}
    		}
    	}
	}    
}
