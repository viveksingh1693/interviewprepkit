package com.viv.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        /**
         * ### Given a list of integers, use streams to:
            - Filter out even numbers.
            - Square each number.
            - Collect results into a list.
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumber = numbers.stream().filter(i -> i % 2 == 0)
                .toList();
        System.out.println("Even Number: " + evenNumber);

        List<Integer> squareList = numbers
                .stream().map(a -> a * a)
                .toList();
        System.out.println("Square Number: " + squareList);

        
    }

}
