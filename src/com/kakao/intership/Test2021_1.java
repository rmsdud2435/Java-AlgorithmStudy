package com.kakao.intership;

import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        for(int i =0; i < n; i++) {
        	answer += "O";
        }
        
        Stack<String> answerStack = new Stack<String>();
        int position = k;
        
        for(String cmdLine: cmd) {
        	if(cmdLine.contains("U")) {
        		String[] tempText = cmdLine.split(" ");
        		int movement = Integer.parseInt(tempText[1]);
        		position -= movement;
        	}else if(cmdLine.contains("D")) {
        		String[] tempText = cmdLine.split(" ");
        		int movement = Integer.parseInt(tempText[1]);
        		position += movement;
        	}else if(cmdLine.equals("C")) {
        		answer.
        	}
        }
        
        
        return answer;
    }
    
    public void checkZ(int i, String[] cmd) {
    	if(i + 1 > cmd.length -1) {
    		//cmd의 마지막 명령이면
    	}else {
    		if(cmd[i+1].equals("Z")) {
    			
    		}
    		
    	}
    }
}