package com.algorithm.exam.sk.ict;

/*
 * 
 * 문제 설명
 * 
 * 6종류(1원, 5원, 10원, 50원, 100원, 500원)의 동전을 생산하는 공장이 있습니다. 특정 금액만큼 동전을 생산해달라는 의뢰가 들어왔을 때, 
 * 최소 비용으로 그 금액만큼 동전을 생산하고자 합니다.
 * 
 * 화폐 단위(원)	생산 단가(원)
 * 1	1
 * 5	4
 * 10	99
 * 50	35
 * 100	50
 * 500	1000
 * 
 * 만약 각 동전의 생산 단가가 위의 표와 같고, 의뢰받은 금액이 4578원이라면, 최소의 비용으로 4578원어치의 동전을 생산하는 방법은 다음과 같습니다.
 * 화폐 단위(원)	생산 단가(원)	생산 수량(개)	생산 비용(원)	생산 화폐 가치(원)
 * 1	1	3	1 x 3 = 3	1 x 3 = 3
 * 5	4	5	4 x 5 = 20	5 x 5 = 25
 * 10	99	0	99 x 0 = 0	10 x 0 = 0
 * 50	35	1	35 x 1 = 35	50 x 1 = 50
 * 100	50	45	50 x 45 = 2250	100 x 45 = 4500
 * 500	1000	0	1000 x 0 = 0	500 x 0 = 0
 * 
 * 총 비용			3 + 20 + 35 + 2250 = 2308	
 * 총 화폐 가치				3 + 25 + 50 + 4500 = 4578
 * 
 * 즉, 1원짜리 동전을 3개, 5원짜리 동전을 5개, 50원짜리 동전을 1개, 100원짜리 동전을 45개 생산하면 2308원이라는 최소 비용으로 4578원어치의 동전을 생산할 수 있습니다. 
 * 2308원보다 적은 비용으로 4578원어치의 동전을 생산할 수 있는 방법은 없습니다.
 * 
 * 공장이 생산해야 하는 금액을 나타내는 정수 money, 6종류 동전의 생산 단가를 나타내는 1차원 정수 배열 costs가 매개변수로 주어집니다. 
 * money원만큼의 동전을 최소 비용으로 생산했을 때, 그 최소 비용을 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 제한사항
 * 
 * 1 ≤ money ≤ 1,000,000
 * costs의 길이 = 6
 * 1 ≤ costs의 원소 ≤ 5,000
 * costs[0] ~ costs[5]은 차례대로 1원, 5원, 10원, 50원, 100원, 500원짜리 동전의 생산 단가를 담고 있습니다.
 * 
 * 
 * 입출력 예
 * 
 * money	costs	result
 * 4578	[1, 4, 99, 35, 50, 1000]	2308
 * 1999	[2, 11, 20, 100, 200, 600]	2798
 * 
 * 
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제 예시와 같습니다.
 * 
 * 입출력 예 #2
 * 화폐 단위(원)	생산 단가(원)	생산 수량(개)	생산 비용(원)	생산 화폐 가치(원)
 * 1	2	9	2 x 9 = 18	1 x 9 = 9
 * 5	11	0	11 x 0 = 0	5 x 0 = 0
 * 10	20	4	20 x 4 = 80	10 x 4 = 40
 * 50	100	1	100 x 1 = 100	50 x 1 = 50
 * 100	200	4	200 x 4 = 800	100 x 4 = 400
 * 500	600	3	600 x 3 = 1800	500 x 3 = 1500
 * 
 * 총 비용			18 + 80 + 100 + 800 +1800 = 2798	
 * 총 화폐 가치		9 + 40 + 50 + 400 + 1500 = 1999
 * 
 * 2798원의 최소 비용으로 1999원어치의 동전을 생산할 수 있습니다.
 * 500원짜리 동전을 4개 생산하면 2400원(600 x 4 = 2400)의 비용으로 2000원어치의 동전을 생산할 수 있습니다. 
 * 하지만, 공장이 생산해야 하는 금액은 정확히 1999원이어야 합니다. 
 * 즉, 주어진 금액을 초과하는 금액을 더 싼 비용으로 생산할 수 있다고 하여도, 그것은 정답으로 인정되지 않습니다.
 * 
 * 
 */


public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//예시1
		//int money = 4578;
		//int[] costs = {1,4,99,35,50,1000};
		//예시2
		int money = 1999;
		int[] costs = {2, 11, 20, 100, 200, 600};

		int answer = solution(money, costs);
		System.out.println("answer: " + answer);
	}
	
	public static int solution(int money, int[] costs) {
		// TODO Auto-generated method stub
		int totalPay=0;
		float[] value = new float[6];
		int[] coins	= {1,5,10,50,100,500};
		for(int i =0; i < costs.length; i++) {
			value[i] = (float)coins[i]/(float)costs[i];
		}
		
		int leftMoney = money;
		while(leftMoney>0) {
			float highestValue=0;
			int order=0;
			for(int j=0; j < value.length; j++) {
				if(coins[j] > leftMoney) {
					break;
				}else {
					if(highestValue < value[j] ) {
						highestValue = value[j];
						order = j;
					}
				}
			}
			int amont=0;
			amont=leftMoney/coins[order];
			totalPay+=amont*costs[order];
			leftMoney=leftMoney%coins[order];
		}
		
		return totalPay;

	}
	
	

}
