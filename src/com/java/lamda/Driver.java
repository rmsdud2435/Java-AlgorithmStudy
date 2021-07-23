package com.java.lamda;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntBiFunction;

class Driver {
	  public static void main(String[] args) {
	    int n = 2;
	    
	    //lamda를 활용한 계산식 선언
	    Calculator cal = calc ->  calc+1;

	    System.out.println(cal.calc(n)); // 3
	    
	    //이미 생성된 lamda interface를 통한 계산식 선언
	    IntBinaryOperator op = (int x, int y) -> {
	    	if(x>y) 
	    		return x; 
	    	else 
	    		return y;
	    };
	    System.out.println(op.applyAsInt(3, 7));
	    
	    //이미 생성된 lamda interface를 통하여 한줄로 표현
	    IntBinaryOperator op2 = (x,y) -> Math.max(x, y);
	    System.out.println(op2.applyAsInt(3, 9));
	    
	    MyMath myMath = new MyMath();
	    IntBinaryOperator op3 = myMath::myMax;
	    
	    System.out.println(op.applyAsInt(3, 14));
	    
	    //compareTo()는 매개변수로 들어온 인자가 호출한 인자보다 값이 큰 경우 -1, 같을 경우 0, 작을 경우 1을 리턴
	    ToIntBiFunction<Integer, Integer> func = Integer::compareTo; // (x, y) -> x.compareTo(y);
	    System.out.println(func.applyAsInt(7, 8)); // -1
	    
	    Function<String, Person> func1 = Person::new;
	    //Function<String, Integer, Person> func2 = Person::new; //이거 왜 안되는지 모르겠음
	    
	    System.out.println(func1.apply("Dom")); // [Dom : 0]
	    
	    // int n과 구별하기 위해 람다식에는 v라는 변수명을 사용.
	    printCalc(n, v -> v + 1); // n + 1, 출력값 3
	    printCalc(n, v -> v - 1); // n - 1, 출력값 1
	    printCalc(n, v -> v * 2); // n * 2, 출력값 4
	    
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    try {
			Date date = dateFormat.parse("12321312");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  public static void printCalc(int n, Calculator cal) {
		    System.out.println(cal.calc(n));
	}
	  
	  ArrayList<Integer> leftPeople = new ArrayList<Integer>();
	  
	  
	  
	  
}