package com.java.study.self.lamda;

public class Person {
	  private String name;
	  private Integer age;

	  public Person(String name) {
	    this.name = name;
	    this.age = 0;
	  }

	  public Person(String name, Integer age) {
	    this.name = name;
	    this.age = age;
	  }

	  @Override
	  public String toString() {
	    return "[" + this.name + " : " + this.age + "]";
	  }
}
