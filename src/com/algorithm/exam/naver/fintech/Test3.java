package com.algorithm.exam.naver.fintech;

/**
 * 문제 설명
 * 
 * 사회적 거리 유지를 위해 공연 관람객들의 좌석을 배정하려 합니다. 
 * 공연장의 각 좌석은 1 x 1 크기 정사각형 모양이며, 전체 좌석은 n x n 크기 정사각 격자 모양입니다. 
 * 관람객에게 좌석을 배정하는 규칙은 다음과 같습니다.
 * 
 * 제일 처음 입장하는 관람객은 1행 1열 좌석을 배정받습니다.
 * 두 번째 관람객부터는 먼저 좌석을 배정받은 다른 관람객 중 가장 가까운 관람객까지의 거리가 최대인 좌석을 배정합니다.
 * 만약 그런 좌석이 여러 개라면 열 번호가 가장 작은 좌석을 배정합니다.
 * 만약 열 번호가 가장 작은 좌석이 여러 개라면 행 번호가 가장 작은 좌석을 배정합니다.
 * 두 좌석 사이의 거리는 행 번호 차이 + 열 번호 차이입니다.
 * 예를 들어 [2행, 3열]과 [5행, 1열] 사이의 거리는 |2 - 5| + |3 - 1| = 5입니다(| |는 절댓값 기호입니다).
 * 다음은 5 x 5 크기 관람석에 좌석을 배정하는 예시입니다.
 * seat_1.png
 * 
 * 제일 처음 입장하는 1번 관람객은 1행 1열에 배정합니다.
 * 2번 관람객은 1번 관람객까지의 거리가 최대인 5행 5열에 배정합니다.
 * 3번 관람객을 배정하기 위해 각 좌석에서 가장 가까운 관람객까지의 거리를 구하면 다음과 같습니다.
 * seat_6.png
 * 
 * 이때, 가장 가까운 관람객까지의 거리가 최대인 좌석은 [5행 1열], [4행 2열], [3행 3열], [2행 4열], [1행 5열]입니다. 이중 열 번호가 가장 작은 [5행 1열]에 3번 관람객을 배정합니다.
 * 3번 관람객을 배정한 후 각 좌석에서 가장 가까운 관람객까지의 거리는 다음과 같습니다.
 * seat_7.png
 * 
 * 3번 관람객을 배치한 후 [4행 2열]의 가장 가까운 관람객까지의 거리가 4 → 2로 변하며, 따라서 4번 관람객을 배치할 좌석은 [3행 3열]이 됩니다.
 * 아래 그림은 최대 수용 인원인 25명까지 관람객을 배치한 결과입니다.
 * seat_2.png
 * 
 * 좌석의 크기 n, 관람객 수 k 가 매개변수로 주어질 때, k 번째 관람객이 배정받는 좌석의 위치를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 제한사항
 * n은 5 이상 50 이하인 자연수입니다.
 * k는 1 이상 n2 이하인 자연수입니다
 * 정답은 [행 번호, 열 번호] 형태로 return 해주세요.
 * 
 * 
 * 입출력 예
 * n	k	result
 * 5	12	[4,4]				
 * 5	16	[1,2]
 * 6	13	[4,5]
 * 
 * 
 * 입출력 예 설명
 * 
 * 입출력 예 #1
 * seat_3.png
 * 
 * 입출력 예 #2
 * seat_4.png
 * 
 * 입출력 예 #3
 * seat_5.png
 * 
 * 
 * 출처: 2021년 Naver Financial Finetech 테스트
 */

public class Test3 {
	public int[] solution(int n, int k) {
        int[] answer = new int[2];
        int peopleCount = 0;
        int[] seat = new int[2];
        
        int[][] reservedSeats = new int[n*n][2];
        peopleCount++;
        reservedSeats[0][0]=0;
        reservedSeats[0][1]=0;
        
        for(int i = 1; i < k ; i++){
            int longestDistance = 0;
            int longestDistanceX = 0;
            int longestDistanceY = 0;
            for(int y = 0; y < n; y++){
                for(int x = 0; x < n; x++){
                    int distance = getLeastDistance(x,y,peopleCount,reservedSeats,n);
                    if(distance>longestDistance){
                        longestDistance = distance;
                        longestDistanceX = x;
                        longestDistanceY = y;
                    }
                }
            }
            reservedSeats[i][0]=longestDistanceX;
            reservedSeats[i][1]=longestDistanceY;
            peopleCount++;
        }
        
        answer[0] = reservedSeats[k-1][0]+1;
        answer[1] = reservedSeats[k-1][1]+1;
        return answer;
    }
    
    public int getLeastDistance(int width, int heigt, int peopleCount, int[][] reservedSeats,int squareSize){
        int leastDistance = Math.abs(width-reservedSeats[0][0])+ Math.abs(heigt-reservedSeats[0][1]);
        for(int a = 1; a < peopleCount; a++){
            int[] seat = reservedSeats[a];
            int distance = Math.abs(width-seat[0])+ Math.abs(heigt-seat[1]);
            if(leastDistance > distance){
                leastDistance = distance;
            }
        }
        return leastDistance;
    }
}















