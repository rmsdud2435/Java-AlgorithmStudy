package com.java.study.self.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Driver {
	  public static void main(String[] args) {
	    // 문자열 List
	    List<String> strList = Arrays.asList("1,2,3,4,5,6".split(","));
	    // 문자열 List를 Integer List로 변환
	    List<Integer> intList = Parser.strToIntList(strList);

	    int sum = 0; // 총 합

	    // 덧셈
	    for (Integer value : intList) {
	      sum += value;
	    }
	    System.out.println(sum); // 21
	    
	    // Integer 데이터를 갖는 Stream 생성
	    Stream<Integer> stream = intList.stream();
	    stream.forEach((Integer i) -> { System.out.println(i); });
	    
	    String a = "hello";
	    a.length();
	    System.out.println();
	  }
	}
