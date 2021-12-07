package com.algorithm.study.programmers.fullsearch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class FullSearchAlgorithm1 {
    public int[] solution(int[] answers) {
        // 1단계 : 수포자1, 2, 3을 준비
        // 2단계 : 정답 준비
        // 3단계 : 수포자1, 2, 3과 정답 비교, 맞추면 + 1
        // 4단계 : 정렬
    	int[] supoja1 = {1, 2, 3, 4, 5};
    	int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
    	int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    	// 수포자 별 정답을 저장할 변수 정의
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for (int i = 0; i < 3; i++) {
			list.add(0);
		}
    	// System.out.println(list); // [0, 0, 0]
    	// 정답 확인
    	int n1 = supoja1.length;
    	int n2 = supoja2.length;
    	int n3 = supoja3.length;
    	for (int i = 0; i < answers.length; i++) {
			if(answers[i] == supoja1[i % n1]) { // n1 : 5
				list.set(0, list.get(0) + 1); // 인덱스 0(첫번째 수포자) 정답 수에 +1
			}
			if(answers[i] == supoja2[i % n2]) { // n2 : 8
				list.set(1, list.get(1) + 1); // 인덱스 1(두번째 수포자) 정답 수에 +1
			}
			if(answers[i] == supoja3[i % n3]) { // n3 : 10
				list.set(2, list.get(2) + 1); // 인덱스 2(세번째 수포자) 정답 수에 +1
			}
		}// for
    	// 가장 많이 맞춘 점수
    	int max = Collections.max(list); // 예) answers 가 [1,2,3,4,5] 일때 5(수포자1이 5문제 맞춤)
    	// 정답에 따라 수포자를 저장할 변수
    	ArrayList<Integer> returnList = new ArrayList<Integer>();
    	for (int i = 0; i < list.size(); i++) {
    		if(max == list.get(i)) { // 예) [5,0,0] // [2,2,2]
    			returnList.add(i + 1); // 예) 0 + 1 ==> [1] // [0+1, 1+1, 2+1] ==> [1,2,3]
    		}
		}
    	// System.out.println(returnList); // [1] // [1, 2, 3] <== ArrayList 객체
    	// ArrayList 객체 를 int 배열로 변경
    	int[] answer = new int[returnList.size()];
    	for (int i = 0; i < returnList.size(); i++) {
			answer[i] = returnList.get(i);
		}// for
        return answer;
    }// solution
    public static void main(String[] args) {
    	// answers	return
    	// [1,2,3,4,5]	[1]
    	// [1,3,2,4,2]	[1,2,3]
		FullSearchAlgorithm1 obj = new FullSearchAlgorithm1();
		int[] answers = {1,2,3,4,5};
		System.out.println( Arrays.toString( obj.solution(answers) ) );
		int[] answers2 = {1,3,2,4,2};
		System.out.println( Arrays.toString( obj.solution(answers2) ) );
	}// main
}// end