package com.viv.lambda;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TerminalOperationsDemo {

    public static void main(String[] args) {

        /**
         * Use reduce() to:
         * Compute the product of a list of numbers.
         * Concatenate a list of strings.
         */

        // Compute the product of a list of numbers.
        int[] numbers = { 1, 2, 3, 4, 5 };
        int productOfNumber = Arrays.stream(numbers)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product of numbers: " + productOfNumber);

        // Concatenate a list of strings.
        String[] strings = { "Hello", "World", "Java" };
        String concatenatedString = Arrays.stream(strings)
                .reduce("", (a, b) -> a + " " + b);
        System.out.println("Concatenated string: " + concatenatedString);

        /**
         * Use collect() to:
         * Group a list of words by their lengths.
         * Given a list of strings, count the number of unique words.
         */

         // Group a list of words by their lengths.
        String[] words = { "Hello", "World", "Java", "Lambda", "Stream" };
        System.out.println("Group words by their lengths: ");
        Map<Integer, List<String>> collect = Arrays.stream(words)
                .collect(Collectors.groupingBy(String::length));
        System.out.println(collect);

        //create map of word and its length
        Map<String, Integer> wordLengthMap = Arrays.stream(words)
                .collect(Collectors.toMap(w -> w, String::length));

        System.out.println("Word and its length: " + wordLengthMap);

        //sort word length map by word length
        Map<String, Integer> sortedWordLengthMap = wordLengthMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, 
                          Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, 
                        LinkedHashMap::new));

        System.out.println("Sorted word and its length: " + sortedWordLengthMap);

    }        
}
