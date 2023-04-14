package com.algorithm.study.programmers.bfs;

import java.awt.Point;

/**
 * 
 * 문제 설명
 * 
 * 문제 설명
주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.

항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
모든 공항은 알파벳 대문자 3글자로 이루어집니다.
주어진 공항 수는 3개 이상 10,000개 이하입니다.
tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
주어진 항공권은 모두 사용해야 합니다.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
입출력 예
tickets	return
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
입출력 예 설명
예제 #1

["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.

예제 #2

["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.
 */

import java.util.*;

public class 단어변환 {
	
    public static void main(String[] args) {
    	// numbers			target	return
    	// [1, 1, 1, 1, 1]	3		5
    	// [4, 1, 2, 1]		4		2
    	단어변환 obj = new 단어변환();
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot","dot","dog","log","lot","cog"};
		System.out.println( obj.solution(begin1, target1, words1));
		//int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		//System.out.println( obj.solution(maps2));
	}

    private HashMap<String, int> wordCntMap = new HashMap<String, int>();

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        init(words);
        
        bfs(begin, target, words);
        return answer;
    }

}


class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
    
        dfs
        
        return answer;
    }
    
    private dfs(String[][] leftTickets, ArrayList<String> route){
        if(notUsedTickets.length == 0){
            return route;
        }
        
        String destination = route.get(route.length()-1);
        String nextDestination = "";
        int position;
        
        for(int i = 0; i < leftTickets.length; i++){
            String[] leftTicket = leftTickets[i];
            if(leftTicket[0].equals(destination)){
                if(nextDestination == "" || nextDestination > leftTicket[1] ){
                    nextDestination = leftTicket[1];
                    position = i;
                }
            }
        }
        
        if(nextDestination == ""){
            return ;
        }else{
            ArrayList<String> newRoute = new ArrayList<String>();
            String[][] newLeftTickets = new String[leftTickets.length-1][2]();
            for(String node :route){
                newRoute.add(node);
            }
            newRoute.add(nextDestination);
            
            for(int j = 0; j < leftTickets.length; j ++ ){
                newLeftTickets[i] = newLeftTickets
            }
        }
        
    }
}


//문자열 비교하기도 정리 compareTo
/*
import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        return answer;
    }
    
    private ArrayList<String> dfs(String[][] leftTickets, ArrayList<String> route){
        if(leftTickets.length == 0){
            return route;
        }
        
        String destination = route.get(route.size()-1);
        String nextDestination = "";
        int position = 0;
        
        for(int i = 0; i < leftTickets.length; i++){
            String[] leftTicket = leftTickets[i];
            if(leftTicket[0].equals(destination)){
                if(nextDestination == "" || nextDestination.compareTo(leftTicket[1]) < 0 ){
                    nextDestination = leftTicket[1];
                    position = i;
                }
            }
        }
        
        if(nextDestination == ""){
            return new ArrayList<String>();
        }else{
            ArrayList<String> newRoute = new ArrayList<String>();
            String[][] newLeftTickets = new String[leftTickets.length-1][2];
            for(String node : route){
                newRoute.add(node);
            }
            newRoute.add(nextDestination);
            
            boolean flag = false;
            for(int j = 0; j < leftTickets.length; j ++ ){
                if(position == j){
                    flag = true;
                }else if(!flag){
                    newLeftTickets[j] = leftTickets[j];
                }else{
                    newLeftTickets[j-1] = leftTickets[j];
                }
           }
            return dfs(newLeftTickets, newRoute);
        }
        
    }
    
}
*/

/*
import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        ArrayList<String> route = new ArrayList<String>();
        route = dfs(tickets, route, "ICN");
        for(int i = 0; i < route.size(); i++){
            answer[i] = route.get(i);
        }
        return answer;
    }
    
    private ArrayList<String> dfs(String[][] leftTickets, ArrayList<String> route, String startNode){
        if(leftTickets.length == 0){
            return route;
        }
        
        String destination = "";
        int position = 0;
        
        for(int i = 0; i < leftTickets.length; i++){
            String[] leftTicket = leftTickets[i];
            if(leftTicket[0].equals(startNode)){
                if(destination == "" || destination.compareTo(leftTicket[1]) > 0 ){
                    destination = leftTicket[1];
                    position = i;
                }
            }
        }
        
        if(destination == ""){
            return route;
        }else{
            ArrayList<String> newRoute = new ArrayList<String>();
            String[][] newLeftTickets = new String[leftTickets.length-1][2];
            if(route.size() == 0){
                newRoute.add("ICN");
            }
            for(String node : route){
                newRoute.add(node);
            }
            newRoute.add(destination);
            
            boolean flag = false;
            for(int j = 0; j < leftTickets.length; j ++ ){
                if(position == j){
                    flag = true;
                }else if(!flag){
                    newLeftTickets[j] = leftTickets[j];
                }else{
                    newLeftTickets[j-1] = leftTickets[j];
                }
           }
            return dfs(newLeftTickets, newRoute, destination);
        }
        
    }
    
}
*/


/*
20230414

import java.util.*;

class Solution {
    private int answerLength;
    
    public String[] solution(String[][] tickets) {
        answerLength = tickets.length + 1;
        String[] answer = new String[answerLength];
        
        ArrayList<String> route = new ArrayList<String>();
        ArrayList<ArrayList<String>> leftTickets = new ArrayList<ArrayList<String>>();
        for(String[] ticket: tickets){
            ArrayList<String> leftTicket = new ArrayList<String>();
            leftTicket.add(ticket[0]);
            leftTicket.add(ticket[1]);
            leftTickets.add(leftTicket);
        }
        
        route = dfs(leftTickets, route, "ICN");
        System.out.println(route.size());
        for(int i = 0; i < route.size(); i++){
            answer[i] = route.get(i);
        }
        return answer;
    }
    private ArrayList<String> makeCloneRoute(ArrayList<String> route, String desination){
        ArrayList<String> tempRoute = new ArrayList<String>();
        for(String node: route){
            tempRoute.add(node);
        }
        tempRoute.add(desination);
        
        return tempRoute;
    }
    
    private ArrayList<ArrayList<String>> makeCloneLeftTickets(ArrayList<ArrayList<String>> leftTickets,int position){
        ArrayList<ArrayList<String>> tempLeftTickets = new ArrayList<ArrayList<String>>();
        for(ArrayList<String> leftTicket : leftTickets){
            ArrayList<String> tempLeftTicket = new ArrayList<String>();
            tempLeftTicket.add(leftTicket.get(0));
            tempLeftTicket.add(leftTicket.get(1));
            tempLeftTickets.add(tempLeftTicket);
        }
        tempLeftTickets.remove(position);
        
        return tempLeftTickets;
        
    }
    private boolean checkOrder(ArrayList<String> destination, ArrayList<String> tempDestination){
        if(tempDestination.size() != answerLength){
            return false;
        }
        if(destination.size() == 0){
            return true;
        }
        for(int i = 0; i < destination.size(); i++){
            if(destination.get(i).compareTo(tempDestination.get(i)) < 0){
                return false;
            }else if(destination.get(i).compareTo(tempDestination.get(i)) > 0){
                return true;
            }
        }
        return false;
        
    }
    
    private ArrayList<String> dfs(ArrayList<ArrayList<String>> leftTickets, ArrayList<String> route, String startNode){
        if(leftTickets.size() == 0){
            return route;
        }

        ArrayList<String> destination = new ArrayList<String>();
        for(int i = 0; i < leftTickets.size(); i++){
            ArrayList<String> leftTicket = leftTickets.get(i);
            if(leftTicket.get(0).equals(startNode)){
                ArrayList<String> tempDestination = new ArrayList<String>();
                ArrayList<String> tempRoute = new ArrayList<String>();
                ArrayList<ArrayList<String>> tempLeftTickets = new ArrayList<ArrayList<String>>();
                tempRoute = makeCloneRoute(tempRoute, leftTicket.get(1));
                tempLeftTickets = makeCloneLeftTickets(leftTickets, i);
                tempDestination = dfs(tempLeftTickets,tempRoute,leftTicket.get(1));
                if(checkOrder(destination, tempDestination)){
                    destination = tempDestination;
                }
            }
        }
        return destination;
    }
    
}
*/
/*
내 정답

import java.util.*;

class Solution {
    private int answerLength;
    
    public String[] solution(String[][] tickets) {
        answerLength = tickets.length + 1;
        String[] answer = new String[answerLength];
        
        ArrayList<String> route = new ArrayList<String>();
        ArrayList<ArrayList<String>> leftTickets = new ArrayList<ArrayList<String>>();
        for(String[] ticket: tickets){
            ArrayList<String> leftTicket = new ArrayList<String>();
            leftTicket.add(ticket[0]);
            leftTicket.add(ticket[1]);
            leftTickets.add(leftTicket);
        }
        
        route = dfs(leftTickets, route, "ICN");
        for(int i = 0; i < route.size(); i++){
            answer[i] = route.get(i);
        }
        return answer;
    }
    private ArrayList<String> makeCloneRoute(ArrayList<String> route, String desination){
        ArrayList<String> tempRoute = new ArrayList<String>();
        for(String node: route){
            tempRoute.add(node);
        }
        tempRoute.add(desination);
        
        return tempRoute;
    }
    
    private ArrayList<ArrayList<String>> makeCloneLeftTickets(ArrayList<ArrayList<String>> leftTickets,int position){
        ArrayList<ArrayList<String>> tempLeftTickets = new ArrayList<ArrayList<String>>();
        for(ArrayList<String> leftTicket : leftTickets){
            ArrayList<String> tempLeftTicket = new ArrayList<String>();
            tempLeftTicket.add(leftTicket.get(0));
            tempLeftTicket.add(leftTicket.get(1));
            tempLeftTickets.add(tempLeftTicket);
        }
        tempLeftTickets.remove(position);
        
        return tempLeftTickets;
        
    }
    private boolean checkOrder(ArrayList<String> destination, ArrayList<String> tempDestination){
        if(tempDestination.size() != answerLength){
            return false;
        }
        if(destination.size() == 0){
            return true;
        }
        for(int i = 0; i < destination.size(); i++){
            if(destination.get(i).compareTo(tempDestination.get(i)) < 0){
                return false;
            }else if(destination.get(i).compareTo(tempDestination.get(i)) > 0){
                return true;
            }
        }
        return false;
        
    }
    
    private ArrayList<String> dfs(ArrayList<ArrayList<String>> leftTickets, ArrayList<String> route, String startNode){
        if(leftTickets.size() == 0){
            return route;
        }
        if(route.size() == 0){
            route.add("ICN");
        }

        ArrayList<String> destination = new ArrayList<String>();
        for(int i = 0; i < leftTickets.size(); i++){
            ArrayList<String> leftTicket = leftTickets.get(i);
            if(leftTicket.get(0).equals(startNode)){
                ArrayList<String> tempDestination = new ArrayList<String>();
                ArrayList<String> tempRoute = new ArrayList<String>();
                ArrayList<ArrayList<String>> tempLeftTickets = new ArrayList<ArrayList<String>>();
                tempRoute = makeCloneRoute(route, leftTicket.get(1));
                tempLeftTickets = makeCloneLeftTickets(leftTickets, i);
                tempDestination = dfs(tempLeftTickets,tempRoute,leftTicket.get(1));
                if(checkOrder(destination, tempDestination)){
                    destination = tempDestination;
                }
            }
        }
        return destination;
    }
    
}
*/