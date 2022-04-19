package com.algorithm.exam.nice.ict;

public class Test4 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        I1 i1 = b; 

        I3 i3 = b;
        //I2 i2 = a;
        a = b;
    }
}