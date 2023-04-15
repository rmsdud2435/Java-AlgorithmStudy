package com.algorithm.study.programmers.dfs;

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

public class 여행경로 {
	
    public static void main(String[] args) {
    	// tickets			                                                                    return
    	// [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]		                                ["ICN", "JFK", "HND", "IAD"]
    	// [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]      ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
    	여행경로 obj = new 여행경로();
		String[][] tickets1 = {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}};
        String[][] tickets2 = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};

        String[] answer1 = obj.solution(tickets1);
        String[] answer2 = obj.solution(tickets2);

        System.out.println("Example1 Answer");
        for(String answer :answer1){
            System.out.println(answer);
        }

        System.out.println("Example2 Answer");
        for(String answer :answer2){
            System.out.println(answer);
        }
	}

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


*/
/*
모법답안

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
import java.util.*;

class Solution {
    List<Stack<String>> result;
    String[][] tickets;

    public String[] solution(String[][] tickets) {
        result = new ArrayList<>();
        this.tickets = tickets;

        boolean[] visited = new boolean[tickets.length];
        Stack<String> st = new Stack<>();
        st.push("ICN");

        dfs(visited, st, 0);

        if (result.size() > 1) {
            Collections.sort(result, new Comparator<Stack<String>>() {
                @Override
                public int compare(Stack<String> o1, Stack<String> o2) {
                    for (int i = 0; i < o1.size(); i++) {
                        String s1 = o1.get(i);
                        String s2 = o2.get(i);

                        if (!s1.equals(s2)) {
                            return s1.compareTo(s2);
                        }
                    }

                    return 0;
                }
            });
        }

        Stack<String> res = result.remove(0);
        String[] answer = new String[res.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public void dfs(boolean[] visited, Stack<String> st, int len) {
        if (len == tickets.length) {
            Stack<String> res = new Stack<>();
            for (String s : st) {
                res.push(s);
            }

            result.add(res);
            return;
        }

        String arrive = st.peek();

        for (int i = 0; i < tickets.length; i++) {
            String[] tic = tickets[i];

            if (!visited[i] && arrive.equals(tic[0])) {
                st.push(tic[1]);
                visited[i] = true;

                dfs(visited, st, len + 1);

                visited[i] = false;
                st.pop();
            }
        }
    }
}

*/