package com.viv.lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class LamdaApp {

    public static void main(String[] args) {
        // Add two integers.
        BinaryOperator<Integer> add = (a, b) -> a + b;
        BiFunction<Integer,Integer,Integer> add2 = (a, b) -> a + b;
        System.out.println(add.apply(1, 2));
        System.out.println(add2.apply(1, 2));
        
        // Find the maximum of two integers. Using method reference
        BinaryOperator<Integer> max = Math::max;
        BiFunction<Integer,Integer,Integer> max2 = Math::max;
        System.out.println(max.apply(1, 2));
        System.out.println(max2.apply(1, 2));

        // Find the minimum of two integers.
        BinaryOperator<Integer> min = (a, b) -> Math.max(a, b);
        BiFunction<Integer,Integer,Integer> min2 = (a, b) -> Math.max(a, b);
        System.out.println(min.apply(1, 2));
        System.out.println(min2.apply(1, 2));


        // Find the average of two integers.
        BinaryOperator<Integer> avg = (a, b) -> (a + b) / 2;
        BiFunction<Integer,Integer,Integer> avg2 = (a, b) -> (a + b) / 2;
        System.out.println(avg.apply(1, 2));
        System.out.println(avg2.apply(1, 2));

        // Concatenate two strings.
        BinaryOperator<String> concat = (a, b) -> a + b;
        BiFunction<String,String,String> concat2 = (a, b) -> a + b;
        System.out.println(concat.apply("Hello", "World"));
        System.out.println(concat2.apply("Hello", "World"));

        // Implement the Runnable interface using a lambda expression.
        Runnable r = ()->System.out.println("Hello World");
        r.run();
    }
}
