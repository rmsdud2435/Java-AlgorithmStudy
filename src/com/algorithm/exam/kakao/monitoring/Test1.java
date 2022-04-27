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

/*
 * Complete the 'solution' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER X
 *  2. INTEGER_ARRAY arr
 *  3. INTEGER_ARRAY indexes
 */


public class Test1 {
    public static List<Integer> solution(int X, List<Integer> arr, List<Integer> indexes) {
	    // Write your code here
	    List<Integer> answer = new ArrayList<Integer>();
	    List<Integer> position = new ArrayList<Integer>();
	    for(int i =0; i < arr.size(); i++){
	        if(arr.get(i)==X){
	            position.add(i);           
	        }
	    }
	    
	    for(int index: indexes){
	        if(position.size() <  index){
	            answer.add(-1);
	        }else{
	            int value= position.get(index-1);
	            answer.add(value+1);
	        }
	    }
	    
	    return answer;
    } 
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int indexesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> indexes = IntStream.range(0, indexesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = solution(X, arr, indexes);

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
