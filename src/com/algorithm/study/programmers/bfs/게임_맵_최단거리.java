package com.algorithm.study.programmers.bfs;

/**
 * 
 * 문제 설명
 * 
 * ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 
 * 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
 * 지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다. 
 * 다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고, 
 * 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.
 * 여기는 java package 안깔려 있어서 힘듦 나중에 차차 정리


벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다. 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.


 * 게임 맵의 상태 maps가 매개변수로 주어질 때, 
 * 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 
 * solution 함수를 완성해주세요. 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.

 * 
 * 제한사항
 * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
 * 각 숫자는 1 이상 50 이하인 자연수입니다.
 * 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
 *
 * 입출력 예
 * numbers			target	return
 * [1, 1, 1, 1, 1]	3		5
 * [4, 1, 2, 1]		4		2
 * 
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제 예시와 같습니다.
 * 
 * 입출력 예 #2
 * +4+1-2+1 = 4
 * +4-1+2-1 = 4
 * 총 2가지 방법이 있으므로, 2를 return 합니다.
 *
 *
 * 출처: 프로그래머스 - https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */

public class DFSAlgorithm1 {
    public int solution(int[] numbers, int target) {
    	int answer = 0;
        answer = getSum(numbers,target, 0, 0);
        return answer;
    }// solution
    
    public int getSum(int[] numbers, int target, int sum, int order){  
        if(order == numbers.length){
            if(sum==target){
                return 1;
            }else{
                return 0;
            }
        }else{
            int leftResult = sum - numbers[order]; 
            int rightResult = sum + numbers[order];
            return getSum(numbers, target, rightResult, order+1) + getSum(numbers, target, leftResult, order+1);
        }
    }
    
    public static void main(String[] args) {
    	// numbers			target	return
    	// [1, 1, 1, 1, 1]	3		5
    	// [4, 1, 2, 1]		4		2
		DFSAlgorithm1 obj = new DFSAlgorithm1();
		int[] numbers = {1,2,3,4,5}; int target = 3;
		System.out.println( obj.solution(numbers, target));
		int[] numbers2 = {1,3,2,4,2}; int target2 = 4;
		System.out.println( obj.solution(numbers2, target2));
	}
    
    
    //Best Answer
    public int solution2(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
    
}