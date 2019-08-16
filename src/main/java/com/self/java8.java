package com.self;

public class java8 {

    public static void main(String[] args) {
        Test1 test1 = a -> a*2;

        Test2 test2 = (a, b) -> a + b;

        System.out.println(test1.sum(1));
    }

    interface Test1 {
        int sum(int a);
    }

    interface Test2 {
        int plus(int a, int b);
    }
}
