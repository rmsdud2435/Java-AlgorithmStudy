package com.algorithm.exam.naver.fintech;

/**
 * 문제 설명
 * 
 * 대형 마트와 같은 상품 판매 회사는 물품을 외부 거래처로부터 구매하여 일정 마진을 더한 후 고객에게 판매합니다. 
 * 이때, 고객에게 상품을 판매하고 얻은 금액을 매출액이라 하고, 상품을 거래처로부터 구입할 때 지불한 금액을 매출원가라고 합니다. 
 * 매출원가를 구하는 방법에는 선입선출법, 후입선출법 2가지 방법이 있습니다. 
 * 선입선출법에서는 먼저 구매한 제품이 먼저 판매된다고 가정을 하는 반면, 후입선출법에서는 나중에 구매한 제품이 먼저 판매가 된다고 가정합니다. 
 * 상품 구입과 판매 기록이 주어졌을 때, 두 방법으로 각각 매출원가를 계산하여 비교하려고 합니다.
 * 아래 표는 어느 마트의 상품 구입과 판매 기록을 나타냅니다. 상품의 종류는 1가지만 주어집니다.
 * 
 * 활동	가격		수량
 * 구입	300		6
 * 구입	500		3
 * 판매	1000	4
 * 구입	600		2
 * 판매	1200	1
 * 
 * 위 표에 따르면 구입한 상품의 수는 총 11개, 판매한 상품의 수는 총 5개입니다.
 * 선입선출법은 먼저 구매한 상품이 먼저 판매된다고 가정하기 때문에, 총판매수량 5는 모두 첫 번째 구입에서 가져온 상품을 판매한 것으로 가정합니다. 
 * 그렇기 때문에 매출원가는 1500원(= 300 x 5)입니다.
 * 후입선출법은 나중에 구매한 상품이 먼저 판매된다고 가정하기 때문에, 첫 번째 판매에서 발생한 매출원가는 1800원(= 500 x 3 + 300 x 1)이고, 
 * 두 번째 판매에서 발생한 매출원가는 600원(= 600 x 1)입니다. 
 * 따라서 총매출원가는 2400원(= 1800 + 600)입니다.
 * 참고로, 매출원가를 계산할 때 물품을 판매한 가격은 고려할 필요가 없습니다.
 * 상품의 구입 또는 판매 활동과 그때 거래된 상품의 가격과 수량을 나타내는 문자열이 시간 순서대로 담긴 배열 record가 주어집니다. 
 * 선입선출법과 후입선출법을 따라 계산한 매출원가를 각각 a, b라고 할 때, [a, b] 형식으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 제한사항
 * 처음 갖고 있는 상품의 수와 매출원가는 0입니다.
 * record의 길이는 1 이상 10,000 이하입니다.
 * record의 원소는 "활동 가격 수량" 형식의 문자열입니다.
 * 활동은 알파벳 대문자 'P' 또는 'S'입니다.
 * 'P'는 구매를, 'S'는 판매를 나타냅니다.
 * 가격은 1 이상 1,000 이하인 자연수입니다.
 * 수량은 1 이상 1,000 이하인 자연수입니다.
 * 갖고 있는 상품의 수량보다 많은 양의 판매하는 경우는 주어지지 않습니다.
 * 
 * 입출력 예
 * record																	result
 * ["P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"]				[1500, 2400]
 * ["P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"]				[1800, 2700]
 * ["P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"]		[7100, 10700]
 * 
 * 
 * 입출력 예 설명
 * 
 * 입출력 예 #1
 * 문제 예시와 같습니다.
 * 
 * 입출력 예 #2
 * 총판매수량은 6개입니다. 
 * 선입선출법에 따르면 처음에 300원으로 구매한 상품 6개를 판매한 것으로 가정합니다. 
 * 따라서 총매출원가는 1800원(= 300 x 6)입니다. 
 * 후입선출법에 따르면 첫 번째 판매에서 매출원가 1800원(= 500 x 3 + 300 x 1)과 
 * 두 번째 판매에서 매출원가 900원(= 600 x 1 + 300 x 1)을 합하여 총매출원가는 2700원입니다. 따라서 [1800, 2700]을 return 합니다.
 * 
 * 입출력 예 #3
 * 선입선출법에 따르면 각 판매 별로 다음과 같이 매출원가를 계산할 수 있습니다.
 * 첫 번째 판매의 매출원가: 100 x 4 + 300 x 3 = 1300원
 * 두 번째 판매의 매출원가: 300 x 6 + 1000 x 1 = 2800원
 * 세 번째 판매의 매출원가: 1000 x 3 = 3000원
 * 합계: 7100원
 * 
 * 후입선출법에 따르면 각 판매 별로 다음과 같이 매출원가를 계산할 수 있습니다.
 * 첫 번째 판매의 매출원가: 300 x 7 = 2100원
 * 두 번째 판매의 매출원가: 1000 x 7 = 7000원
 * 세 번째 판매의 매출원가: 1000 x 1 + 300 x 2 = 1600원
 * 합계: 10700원
 * 따라서 [7100, 10700]을 return 합니다.
 * 
 * 출처: 2021년 Naver Financial Finetech 테스트
 */

import java.util.*;

public class Test1 {
	public int[] solution(String[] record) {
        int[] answer = new int[2];
        
        Queue<Integer> fifo = new LinkedList<Integer>();
        Stack<Integer> filo = new Stack<Integer>();
        
        int filoAnswer = 0;
        int fifoAnswer = 0;
        
        for(String elements: record){
            String[] element = elements.split(" ");
            String activity = element[0];
            int price = Integer.parseInt(element[1]);
            int quantity = Integer.parseInt(element[2]);
            
            if("P".equals(activity)){
                for(int i = 0; i < quantity; i++){
                    fifo.add(price);
                    filo.push(price);
                }
            }else if("S".equals(activity)){
                for(int i = 0; i < quantity; i++){
                    filoAnswer += fifo.poll();
                    fifoAnswer += filo.pop();
                }
            }
        }
        answer[0] = filoAnswer;
        answer[1] = fifoAnswer;
        return answer;
    }
}
		

		
		