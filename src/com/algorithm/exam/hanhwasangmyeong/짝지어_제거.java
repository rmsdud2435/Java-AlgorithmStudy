package com.algorithm.exam.hanhwasangmyeong;


/**
 * 
 * 문제 설명
 * 
 * 0과 1로만 이루어진 문자열 S가 있습니다. 
 * S의 임의의 위치에서, 0과 1이 붙어있을 경우 두 개의 문자열을 짝지어 제거할 수 있습니다. 
 * 예를 들어, "1011" 이라는 문자열이 있으면, 첫 번째 문자 '1'과 두 번째 문자 '0'을 짝지어 제거하면 "11"만 남게 됩니다. 
 * 제거한 후 연결된 새로운 문자열에서 짝이 생길 경우에도 반복하여 제거합니다. 
 * 남은 문자열 "11"은 짝지어 제거할 수 없습니다.
 * 
 * 문자열 s가 매개변수로 주어질 때, 짝지어 제거하여 만들 수 있는 문자열 중 가장 짧은 문자열의 길이를 return 하는 solution 함수를 완성해 주세요.
 * 
 * 
 * 제한사항
 * 문자열 S의 길이 : 100,000 이하의 자연수
 * 입출력 예
 * S			answer
 * "1011"		2
 * "0110011"	1
 * "000111"		0
 * "00001"		3
 * 
 * 
 * 입출력 예 설명
 * 
 * 입출력 예 #1
 * 문제의 예시와 같습니다.
 * 
 * 입출력 예 #2
 * 첫 번째 문자 '0'과 두 번째 문자 '1'을 짝지어 제거하면 "10011"이 남습니다. 
 * 다음으로 첫 번째 문자 '1'과 두 번째 문자 '0'을 짝지어 제거하면 "011"이 남습니다. 
 * 다음으로 첫 번째 문자 '0'과 두 번째 문자 '1'을 제거하면 "1"이 남아 더이상 제거하지 못합니다. 
 * 이 경우가 최종적으로 만들 수 있는 문자열 중 가장 짧은 문자열이므로 1을 return 하면 됩니다.
 * 
 * 입출력 예 #3
 * 세 번째 문자 '0'과 네 번째 문자 '1'을 짝지어 제거하면 "0011"이 남습니다. 
 * 다음으로 두 번째 문자 '0'과 세 번째 문자 '1'을 짝지어 제거하면 "01"이 남습니다. 
 * 마지막으로 첫 번째 문자 '0'과 두 번째 문자 '1'을 제거하면 전부 제거되어 더이상 제거하지 못합니다. 
 * 이 경우가 최종적으로 만들 수 있는 문자열 중 가장 짧은 문자열이므로 0을 return 하면 됩니다.
 *
 */

import java.util.*;

public class 짝지어_제거 {
	
	public static void main(String[] args) {
		
		//String s = "1011";	
		//String s = "0110011";	
		//String s = "000111";			
		String s = "00001";			
		System.out.println(solution(s));

	}
	
	public static int solution(String s) {
		int answer = RecursiveFunc(s);
		
		return answer;
	}
	   
	
	public static int RecursiveFunc(String s){
		System.out.println("s : " + s);
		
		String s2 = "";
		String s3 = "";
		String s4 = "";
		
		boolean foundFlag = false;
		
		for(int i = 0; i < s.length()-1;i++) {
			if(s.charAt(i) !=  s.charAt(i+1)) {
				foundFlag = true;
				if(i > 0) {					
					s2 = s.substring(0,i);
				}
				if(i < s.length()-2) {					
					s3 = s.substring(i+2,s.length());
				}
				break;
			}
		}
		if(foundFlag) {
			s4 = s2 + s3;
			return RecursiveFunc(s4);
		}else {
			return s.length();
		}
    }
}