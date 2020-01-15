package com.bailiban.springboot.singleton;

public class Test {
    public static void main(String[] args) {
        DoubleCheckSingleton singleton=DoubleCheckSingleton.getSingleton();
        DoubleCheckSingleton singleton2=DoubleCheckSingleton.getSingleton();
        System.out.println(singleton==singleton2);
    }
}
