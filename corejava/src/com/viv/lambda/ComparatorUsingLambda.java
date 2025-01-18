package com.viv.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorUsingLambda {

    public static void main(String[] args) {

        /**
         * Create a Comparator using a lambda expression to sort a list of strings by:
         * - Length
         * - Reverse alphabetical order.
         * - Convert a traditional anonymous inner class to a lambda expression.
         */

        List<String> names = Arrays.asList("Joey", "Shyam", "Alpha2", "Singh");
        // names.sort((s1, s2) -> s1.length() - s2.length()); //cannot perform sort operation directly on muttable object

        List<String> sortedNames = names.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
        System.out.println("Sort By Length1: " + sortedNames);

        Comparator<String> byLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        names.sort(byLength);
        System.out.println("Sort By Length2: " + names);

        Comparator<String> byReverseAlphabetical = (s1, s2) -> s2.compareTo(s1);
        names.sort(byReverseAlphabetical);
        System.out.println("Sort By Reverse Alphabetical: " + names);

        Comparator<String> byLengthTraditional = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        names.sort(byLengthTraditional);
        System.out.println("Sort By Length Traditional: " + names);

        Comparator<String> byLengthLambda = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        names.sort(byLengthLambda);
        System.out.println("Sort By Length byLengthLambda: " + names);

        Comparator<String> combinedComparator = byLength
                .thenComparing(byReverseAlphabetical);

                names.sort(combinedComparator);

        //sort using stream api
        names = names.stream()
                .sorted(byLength.thenComparing(byReverseAlphabetical))
                .collect(Collectors.toList());

        System.out.println("Sort By Length and Reverse Alphabetical: " + names);


    }
}
