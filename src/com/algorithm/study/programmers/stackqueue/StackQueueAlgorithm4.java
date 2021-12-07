package com.algorithm.study.programmers.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class StackQueueAlgorithm4 {

	/*
	 * 문제
	 * 
	 * 문제 설명
	 * 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 
	 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 
	 * 다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
	 * 예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 
	 * 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
	 * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
	 * 0		[]			[]				[7,4,5,6]
	 * 1~2	[]	[7]	[4,5,6]
	 * 3	[7]	[4]	[5,6]
	 * 4	[7]	[4,5]	[6]
	 * 5	[7,4]	[5]	[6]
	 * 6~7	[7,4,5]	[6]	[]
	 * 8	[7,4,5,6]	[]	[]
	 * 
	 * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
	 * solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다. 
	 * 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
	 * 
	 * 
	 * 제한사항
	 * 
	 * bridge_length는 1 이상 10,000 이하입니다.
	 * weight는 1 이상 10,000 이하입니다.
	 * truck_weights의 길이는 1 이상 10,000 이하입니다.
	 * 모든 트럭의 무게는 1 이상 weight 이하입니다.
	 * 
	 * 예
	 * 
	 * bridge_length	weight	truck_weights						return
	 * 2				10		[7,4,5,6]							8
	 * 100				100		[10]								101
	 * 100				100		[10,10,10,10,10,10,10,10,10,10]		110
	 * 
	 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42583
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities1 = {2, 1, 3, 2};
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		int location1 = 2;
		int location2 = 0;
			
		System.out.print(myAnswer(priorities2,location2));
		
	}

	public static int myAnswer(int[] priorities, int location) {
		
		List<Integer> 	tempPriorities 	= new ArrayList<Integer>();
		List<Integer> 	prioriesName 	= new ArrayList<Integer>();
		int 				answer 			= 0;
		
		for(int i = 0; i < priorities.length; i++){
			tempPriorities.add(priorities[i]);
			prioriesName.add(i);
		}
		
		int highestPrioities = 0;
		for(int priority : priorities){
			if(highestPrioities < priority){
				highestPrioities = priority;
			}
		}
		
		while(highestPrioities > 0){
			if(tempPriorities.contains(highestPrioities)){
				int cutLine = tempPriorities.indexOf(highestPrioities);
				if(prioriesName.get(cutLine).equals(location)){
					break;
				}
				
				List headPrioritiesArray = tempPriorities.subList(0, cutLine);
				List tailPrioritiesArray = tempPriorities.subList(cutLine+1, tempPriorities.size());
				
				List headNameArray = prioriesName.subList(0, cutLine);
				List tailNameArray = prioriesName.subList(cutLine+1, tempPriorities.size());
				
				tailPrioritiesArray.addAll(headPrioritiesArray);
				tailNameArray.addAll(headNameArray);
				
				tempPriorities 	= tailPrioritiesArray;
				prioriesName 	= tailNameArray;
				
				answer++;
			}else{
				highestPrioities --;
			}
			
		}

		return answer+1;
	}
	
	//모범답안
    public int standardAnswer(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;



        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}
