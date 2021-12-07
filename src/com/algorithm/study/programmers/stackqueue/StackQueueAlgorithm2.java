package com.algorithm.study.programmers.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackQueueAlgorithm2 {

	/*
	 * 문제
	 * 
	 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다. 
	 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다. 
	 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 
	 * return 하도록 solution 함수를 완성하세요.
	 * 
	 * 예
	 * progresses	speeds		return
	 * [93,30,55]	[1,30,5]	[2,1]
	 * 
	 * 
	 * 제한사항
	 * 
	 * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
	 * 작업 진도는 100 미만의 자연수입니다.
	 * 작업 속도는 100 이하의 자연수입니다.
	 * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
	 * 
	 * 
	 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42586
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
			
		myAnswer(progresses,speeds);
		
	}

	public static int[] myAnswer(int[] progresses, int[] speeds) {
		
		//배포하는데 걸리는 시간
		Queue<Integer> jobDays = new LinkedList<Integer>();
		//List를 int[]로 바꿔줄 임시 변수
		List<Integer> tempAnswer = new ArrayList<Integer>();
		
		//남은 일량/일률을 올림처리한 후 저장
		for(int i = 0; i < progresses.length; i++ ){
			jobDays.add((int) Math.ceil(((100-progresses[i])/(double)speeds[i])));
		}
		
		//첫배포일 정하기
		int cnt = 1;
		int firstJobDay = jobDays.poll();
		while(jobDays.size() > 0){	
			//마지막 일이면
			if(jobDays.size() == 1){
				//기준배포일보다 마지막배포일이 늦으면 따로 배포
				if(firstJobDay < jobDays.peek()){					
					tempAnswer.add(cnt);
					tempAnswer.add(1);
				//아닐 경우 같이 배포
				}else{
					tempAnswer.add(cnt+1);
				}
				break;
			//기준배포일보다 작으면 같이 배포
			}else if(firstJobDay >= jobDays.peek()){
				cnt += 1;
				jobDays.remove();
			//기준배포일보다 크면 이전것까지 배포완료하고 현재일이 기준배포일로 변경
			}else{
				tempAnswer.add(cnt);
				cnt = 1;
				firstJobDay = jobDays.poll();
			}
			
		}
		
		//List를 int[]로 변환
		int[] answer = new int[tempAnswer.size()];
		for(int i = 0; i < tempAnswer.size(); i++){
			answer[i] = tempAnswer.get(i);
		}
		
		System.out.print(answer.toString());
		return answer;
	}
	
	public static int[] bestAnswer(int[] progresses, int[] speeds) {
		
		//배포하는데 걸리는 시간
		Queue<Integer> jobDays = new LinkedList<Integer>();
		//List를 int[]로 바꿔줄 임시 변수
		List<Integer> tempAnswer = new ArrayList<Integer>();
		
		//남은 일량/일률을 올림처리한 후 저장
		for(int i = 0; i < progresses.length; i++ ){
			jobDays.add((int) Math.ceil(((100-progresses[i])/(double)speeds[i])));
		}
		
		//첫배포일 정하기
		int cnt = 1;
		int firstJobDay = jobDays.poll();
		while(jobDays.size() > 0){	
			//마지막 일이면
			if(jobDays.size() == 1){
				//기준배포일보다 마지막배포일이 늦으면 따로 배포
				if(firstJobDay < jobDays.peek()){					
					tempAnswer.add(cnt);
					tempAnswer.add(1);
				//아닐 경우 같이 배포
				}else{
					tempAnswer.add(cnt+1);
				}
				break;
			//기준배포일보다 작으면 같이 배포
			}else if(firstJobDay >= jobDays.peek()){
				cnt += 1;
				jobDays.remove();
			//기준배포일보다 크면 이전것까지 배포완료하고 현재일이 기준배포일로 변경
			}else{
				tempAnswer.add(cnt);
				cnt = 1;
				firstJobDay = jobDays.poll();
			}
			
		}
		
		//List를 int[]로 변환
		int[] answer = new int[tempAnswer.size()];
		for(int i = 0; i < tempAnswer.size(); i++){
			answer[i] = tempAnswer.get(i);
		}
		
		System.out.print(answer.toString());
		return answer;
	}
	
}
