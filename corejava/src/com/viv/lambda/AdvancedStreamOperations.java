package com.viv.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdvancedStreamOperations {

    public static void main(String[] args) {
        
        // Convert a list of lists into a single list.
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Hello", "World"),
                Arrays.asList("Java", "Lambda", "Stream")
        );
      List<String> listOfListsToSingleList =  listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

      System.out.println("listOfListsToSingleList: " + listOfListsToSingleList);


      
      //Tokenize a list of sentences into individual words.
      List<String> sentences = Arrays.asList("Hello World", "Java Lambda Stream");

         List<String> listOfSentencesIntoIndividualWords = sentences.stream().map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                // .flatMap(a -> Stream.of(a))  
                .collect(Collectors.toList());

        System.out.println("listOfSentencesIntoIndividualWords: " + listOfSentencesIntoIndividualWords);

        /**
         * Partition a list of integers into
         * even and odd numbers using Collectors.partitioningBy().
         */

        List<Integer> randomInteger = IntStream.generate(() -> (int) (Math.random() * 100))
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        Map<Boolean, List<Integer>> partitionEvenOdd = randomInteger.stream()
                .collect(Collectors.partitioningBy(a -> a % 2 == 0));
        System.out.println("Partition into even and odd: " +  partitionEvenOdd);

        Map<String, List<Integer>> groupEvenOdd = randomInteger.stream()
          .collect(Collectors.groupingBy(a -> a % 2 == 0 ? "even" : "odd"));

        System.out.println("Group into even and odd: " +  groupEvenOdd);

        // Group employees by department
        List<Employee> employees = Arrays.asList(
                new Employee("John", 30, 3000, "HR"),
                new Employee("Jane", 25, 2500, "Finance"),
                new Employee("Adam", 35, 3500, "HR"),
                new Employee("Robert", 40, 4000, "Finance")
        );

        Map<String, List<Employee>> groupEmployeeByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("groupEmployeeByDepartment " + groupEmployeeByDepartment);

        //Write a program to find the frequency of each character in a string using streams.
        String str = "Hello World";
        str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " -> " + v));

        Map<Character, Long> frequencyOfEachChar = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("frequencyOfEachChar: "+ frequencyOfEachChar);

//        Use streams to check if a list of integers is sorted.

        boolean isSorted = IntStream.range(0, randomInteger.size() - 1)
                .allMatch(i -> randomInteger.get(i) <= randomInteger.get(i + 1));
        System.out.println("Is the list sorted? " + isSorted);
    }
}
