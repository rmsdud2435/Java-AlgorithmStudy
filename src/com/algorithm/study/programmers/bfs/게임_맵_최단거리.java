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

mport java.util.*;

class Solution {
    private boolean[][] visitCheckArr;
    private int[][] currentMap;
    
    private int sourceX;
    private int sourceY;
    private int currentMove=1;
        
    public int solution(int[][] maps) {
        int answer = 0;
    
        sourceX = maps[0].length;
        sourceY = maps.length;
        
        visitCheckArr = new boolean[sourceY][sourceX];
        currentMap = new int[sourceY][sourceX];
        for(int i = 0; i < sourceY; i++){
            for(int j = 0; j < sourceX; j++){
                visitCheckArr[i][j] = false;
                currentMap[i][j] = maps[i][j];
            }
        }
        if(bfs(0, 0)){
            answer =  currentMap[sourceY-1][sourceX-1];
        }else{
            answer = -1;
        }
        
        return answer;
    }
    
    public boolean bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] startNode = {x,y,1};
        queue.add(startNode);
        while(!queue.isEmpty()){
            int[] currentNode = queue.poll();
            
            int currentX = currentNode[0];
            int currentY = currentNode[1];
            int currentDepth = currentNode[2];
            
            visitCheckArr[currentY][currentX] = true;
            currentMap[currentY][currentX] = currentDepth;
            
            int[] upXY = {currentX, currentY-1,currentDepth+1};
            int[] downXY = {currentX, currentY+1, currentDepth+1};
            int[] rightXY = {currentX+1, currentY,currentDepth+1};
            int[] leftXY = {currentX-1, currentY, currentDepth+1};
            
            int[][] nextNodeArr = {upXY, downXY, rightXY, leftXY};
            for(int[] nextNode : nextNodeArr){
                if(nextNode[0] >= sourceX || nextNode[0] < 0 
                  || nextNode[1] >= sourceY || nextNode[1] < 0){
                    continue;
                }else if(visitCheckArr[nextNode[1]][nextNode[0]] ||
                         currentMap[nextNode[1]][nextNode[0]] == 0){ 
                    continue;
                }else if(currentMap[nextNode[1]][nextNode[0]] >= nextNode[2] || currentMap[nextNode[1]][nextNode[0]] == 1 ){
                    currentMap[nextNode[1]][nextNode[0]] = nextNode[2];
                    queue.add(nextNode);
                }
            }
        }
        return visitCheckArr[sourceY-1][sourceX-1];
    }
    
    
}
/*
class Solution {
    public int leastVal = -1;
    public int[][] originalMaps;
    
    public int solution(int[][] maps) {
        int answer = 0;
        originalMaps = maps;
        answer = dfs(maps, 0, 0, 1);
        return answer;
    }
    
    public int dfs(int[][] maps, int x, int y, int moveCount){
        if(y == maps.length-1 && x == maps[y].length-1){
            return moveCount;
        }else if(y >= maps.length || y<0 || x >= maps[y].length || x<0){
            return -1;
        }else if(maps[y][x]==0){
            return -1;
        }else if(leastVal != -1 && moveCount >= leastVal){
            return -1;
        }else{
            if(originalMaps[y][x] != 1 && originalMaps[y][x] < moveCount ){
                System.out.println("position x: " + x + ", y: " + y + " and moveCount is " + moveCount);
                System.out.println("originalMaps[y][x] - " + originalMaps[y][x]);
                System.out.println("It will return -1");
                return -1;
            }else{
                System.out.println("position x: " + x + ", y: " + y + " and moveCount is " + moveCount);
                System.out.println("originalMaps[y][x] - " + originalMaps[y][x]);
                originalMaps[y][x] = moveCount;
                System.out.println("after originalMaps[y][x] - " + originalMaps[y][x]);
            }
            
            int[][] newMaps1 = new int[maps.length][maps[0].length];
            int[][] newMaps2 = new int[maps.length][maps[0].length];
            int[][] newMaps3 = new int[maps.length][maps[0].length];
            int[][] newMaps4 = new int[maps.length][maps[0].length];
            
            for(int i = 0; i < maps.length; i++){
                for(int j = 0; j < maps[0].length; j++){
                    newMaps1[i][j] = maps[i][j];
                    newMaps2[i][j] = maps[i][j];
                    newMaps3[i][j] = maps[i][j];
                    newMaps4[i][j] = maps[i][j];
                }
            }
            
            newMaps1[y][x]=0;
            newMaps2[y][x]=0;
            newMaps3[y][x]=0;
            newMaps4[y][x]=0;
            int right = dfs(newMaps1,x+1,y,moveCount+1);
            int left = dfs(newMaps2,x-1,y,moveCount+1);
            int down = dfs(newMaps3,x,y+1,moveCount+1);
            int up = dfs(newMaps4,x,y-1,moveCount+1);
            
            int[] a = {right,left,down,up};
            for(int i = 0; i < a.length; i++){
                if(a[i] != -1 && (a[i] < leastVal || leastVal == -1)){ 
                    leastVal = a[i]; 
                }
            }
                
            return leastVal;
        }
    }
}
*/