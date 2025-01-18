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
                .collect(Collectors.toList());
        System.out.println("Even Number: " + evenNumber);

        List<Integer> squareList = numbers
                .stream().map(a -> a * a)
                .collect(Collectors.toList());

        System.out.println("Square Number: " + squareList);

        /**
         * Use streams to find:
         * The maximum number in a list.
         * The sum of all elements in a list.
         * The average of a list of numbers.
         * Given a list of strings, filter out strings that start
         * with a particular letter (e.g., "A").
         */

        //The sum of all elements in a list.
        Integer sumUsingReduce = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("sumUsingReduce " + sumUsingReduce);

        Integer sumUsingMethodReference = numbers.stream()
                .reduce(0, Integer::sum);
        
        numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
                

        System.out.println("sumUsingMethodReference " + sumUsingMethodReference);

        //The maximum number in a list.
        Integer maxInList = numbers.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);

        numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(max -> System.out.println("Max: " + max));

        System.out.println("maxInList: " + maxInList);

        //The average of a list of numbers.
        numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(avg -> System.out.println("Average: " + avg));

                
                
        //Given a list of strings, filter out strings that start with a particular letter (e.g., "A").

        List<String> names = Arrays.asList("Adam", "Bob", "Cathy", "Dave", "Alice", "Eve", "Alex");
        List<String> namesWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Names with A: " + namesWithA);
        
        }


       
}
