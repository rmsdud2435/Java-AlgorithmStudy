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



class Result {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY infectedHouses
     */

    public static int solution(int n, List<Integer> infectedHouses) {
    // Write your code here
    int answer = 1;
    System.out.println(Math.pow(10, 9));
    System.out.println(10^9);
    List<Integer> oldInfectedHouses = new ArrayList<Integer>();
    for(int a: infectedHouses) {
    	oldInfectedHouses.add(a);
    }
    
    while(n > oldInfectedHouses.size()){
        List<Integer> newInfectedHouses = new ArrayList<Integer>();
        for(int a: oldInfectedHouses) {
        	newInfectedHouses.add(a);
        }
        
        for(int i = 0; i < oldInfectedHouses.size(); i++){
            if(oldInfectedHouses.get(i) != 1 && !newInfectedHouses.contains(oldInfectedHouses.get(i)-1)){
                newInfectedHouses.add(oldInfectedHouses.get(i)-1);
            }
            if(oldInfectedHouses.get(i) != n && !newInfectedHouses.contains(oldInfectedHouses.get(i)+1)){
                newInfectedHouses.add(oldInfectedHouses.get(i)+1);
            }
        }
        answer = answer*Factorial(newInfectedHouses.size()-oldInfectedHouses.size());
       
        oldInfectedHouses = newInfectedHouses.subList(0, newInfectedHouses.size());
        

    }
    return answer;
    }
    
    public static int Factorial(int n){
        if(n<=1){
            return n;
        }else{
            return Factorial(n-1)*n;
        }
    }

}

public class Test3 {
    public static void main(String[] args) throws IOException {
		/*
		 * BufferedReader bufferedReader = new BufferedReader(new
		 * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
		 * BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * int n = Integer.parseInt(bufferedReader.readLine().trim());
		 * 
		 * int infectedHousesCount = Integer.parseInt(bufferedReader.readLine().trim());
		 * 
		 * List<Integer> infectedHouses = IntStream.range(0,
		 * infectedHousesCount).mapToObj(i -> { try { return
		 * bufferedReader.readLine().replaceAll("\\s+$", ""); } catch (IOException ex) {
		 * throw new RuntimeException(ex); } }) .map(String::trim)
		 * .map(Integer::parseInt) .collect(toList());
		 */
    	
    	List<Integer> infectedHouses = new ArrayList<Integer>();
    	infectedHouses.add(3);
    	infectedHouses.add(5);
    	int n = 6;
        int result = Result.solution(n, infectedHouses);
        System.out.println(result);
		/*
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedReader.close(); bufferedWriter.close();
		 */
    }
}
