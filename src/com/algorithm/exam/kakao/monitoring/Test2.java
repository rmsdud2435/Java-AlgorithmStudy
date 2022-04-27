package com.algorithm.exam.kakao.monitoring;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Test2 {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY teamK
     *  2. INTEGER_ARRAY teamB
     *  
     *  문제 설명
     *  리스트 teamB는 B팀이 각 경기마다 골을 넣은 개수이며, 리스트 teamK는 K팀이 각 경기마다 골을 넣은 갯수이다.
     *  B팀이 각 경기당 넣은 골보다 teamK가 더 많은 골을 넣은 날을 구하여라
     *  
     *   
     *  예시
     *   
     *  
     */

    public static List<Integer> solution(List<Integer> teamK, List<Integer> teamB) {
	    // Write your code here
	    List<Integer> answer = new ArrayList<Integer>();
	    HashMap<Integer, Integer> value = new HashMap<Integer, Integer>();
	    Collections.sort(teamK);
	    for(int score: teamB){
	        if(value.containsKey(score)){
	            answer.add(value.get(score));
	        }else{
	            for(int i =0; i < teamK.size(); i++){
	                if(teamK.get(i)>score){
	                    answer.add(i);
	                    value.put(score,i);
	                    break;
	                }else if(i == teamK.size()-1){
	                    answer.add(i+1);
	                    value.put(score,i+1);
	                }
	            }  
	        }
	    }
	    return answer;

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int teamKCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> teamK = IntStream.range(0, teamKCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int teamBCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> teamB = IntStream.range(0, teamBCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = solution(teamK, teamB);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}