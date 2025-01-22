package com.viv.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntermediateStreamOperationsDemo {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(new Employee(null, 0, 0),
                new Employee("John", 30, 3000),
                new Employee("Jane", 25, 2500),
                new Employee("Tom", 40, 4000),
                new Employee("Alice", 22, 2200),
                new Employee("Bob", 35, 3500),
                new Employee("Diana", 27, 2700),
                new Employee("Steve", 45, 4500),
                new Employee("Stella", 32, 3200),
                new Employee("Mike", 29, 2900)
        );

        List<Employee> employeeWithSalaryGreaterThan3000 = employees.stream().filter(e -> e.getSalary() > 3000)
                .collect(Collectors.toList());
        
        System.out.println("Employees with salary greater than 3000:");
        employeeWithSalaryGreaterThan3000.forEach(System.out::println);

        //Sort employees by salary in descending order.
        List<Employee> employeeSalaryInDecending = employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());

        System.out.println("\n");
        System.out.println("Employee sorted by salary in descending order: ");
        employeeSalaryInDecending.forEach(System.out::println);

        //Get a list of employee names.
        List<String> listOfEmployee = employees.stream().map(Employee::getName)
        .collect(Collectors.toList());
        System.out.println("ListOfEmployee: " +listOfEmployee);

        //Use map() to convert a list of integers to their string representation.
        Arrays.asList(1, 2, 3, 4, 5).stream()
        .map(String::valueOf)
        .forEach((s) -> System.out.print(s + " "));

        // Use distinct() to remove duplicate elements from a list.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("\nDistinct numbers: " + distinctNumbers);

        // Combine filter(), map(), and sorted() to process a list of integers.
        List<Integer> numberList = Arrays.asList(1,5,6,3,4,2,9);
        List<Integer> collect = numberList.stream().filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Collect: " + collect);

        //Create a stream of 10 random numbers and sort them in ascending order.
        IntStream randomNumbers = IntStream.generate(() -> (int) (Math.random() * 100)).limit(10);
        List<Integer> sortedRandomNumbers = randomNumbers.sorted().boxed()
        .collect(Collectors.toList());
        System.out.println("sortedRandomNumbers: " + sortedRandomNumbers);

        IntStream.generate(()-> (int)(Math.random() *100))
                .limit(10)
                .sorted()
                .boxed()
                .forEach(r -> System.out.print(" " + r));


    }

}
