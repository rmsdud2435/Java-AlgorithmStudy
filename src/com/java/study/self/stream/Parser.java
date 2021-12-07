package com.java.study.self.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Parser {
    public static List<Integer> strToIntList(List<String> strList) {
    	//Stream 자료형 활용하기
    	/*
        List<Integer> intList = new ArrayList<>();

        for (String value : strList) {
            intList.add(Integer.parseInt(value));
        }
        return intList;
        */
        return strList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}