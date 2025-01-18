## Basics of Lambda and Functional Interfaces

### Write a lambda expression to:
- Add two integers.
- Concatenate two strings.
- Find the square of a number.
- Implement the Runnable interface using a lambda expression.

### Create a Comparator using a lambda expression to sort a list of strings by:
- Length.
- Reverse alphabetical order.
- Convert a traditional anonymous inner class to a lambda expression.

## Streams: Basic Operations

### Given a list of integers, use streams to:
- Filter out even numbers.
- Square each number.
- Collect results into a list.

### Use streams to find:
- The maximum number in a list.
- The sum of all elements in a list.
- The average of a list of numbers.
- Given a list of strings, filter out strings that start with a particular letter (e.g., "A").

## Intermediate Stream Operations

### Given a list of employees (`List<Employee>`), where `Employee` has fields `name` and `salary`:
- Find all employees earning more than a certain amount.
- Sort employees by salary in descending order.
- Get a list of employee names.
- Use `map()` to convert a list of integers to their string representation.
- Use `distinct()` to remove duplicate elements from a list.
- Combine `filter()`, `map()`, and `sorted()` to process a list of integers.
- Create a stream of 10 random numbers and sort them in ascending order.

## Terminal Operations

### Use `reduce()` to:
- Compute the product of a list of numbers.
- Concatenate a list of strings.

### Use `collect()` to:
- Group a list of words by their lengths.
- Given a list of strings, count the number of unique words.

## Advanced Stream Operations

### Use `flatMap()` to:
- Convert a list of lists into a single list.
- Tokenize a list of sentences into individual words.

### Partition a list of integers into even and odd numbers using `Collectors.partitioningBy()`.

### Group employees by department using `Collectors.groupingBy()`.

### Write a program to find the frequency of each character in a string using streams.

### Use streams to check if a list of integers is sorted.

## Optional and Streams

### Use `Optional` to:
- Handle the result of a `findAny()` or `findFirst()` call.
- Provide a default value if the `Optional` is empty.
- Use `orElseThrow()` to throw a custom exception if an `Optional` is empty.

## Practical Exercises

### Write a program to generate the first 10 Fibonacci numbers using streams.

### Use `Collectors` to:
- Create a map from a list of objects.
- Join a list of strings with a delimiter.
- Given a stream of transactions, filter the top 5 highest-value transactions.

### Find the second highest number in a list using streams.

### Write a program to find all palindromes in a list of strings using streams.

### Create a pipeline that processes a list of integers by doubling each value, filtering out those greater than 50, and then sorting the remaining elements.

## Challenging and Advanced Questions

### Advanced Stream Manipulations

#### Find Top N Elements with Streams:
- Given a list of integers, find the top N largest numbers in descending order efficiently using streams. Ensure the solution works for very large lists.

#### Custom Collectors:
- Create a custom collector to:
    - Calculate both the sum and average of a list of integers.
    - Group a list of strings by their lengths but store the result in a `TreeMap`.

#### Lazy Loading with Streams:
- Write a program to generate an infinite stream of prime numbers and collect the first 50 primes.

#### Matrix Manipulation:
- Given a 2D array (e.g., `int[][]`), convert it to a flattened list of integers using streams. Then, calculate the sum of all diagonal elements.

#### Dynamic Filtering:
- Implement a method that takes a list of `Predicate` objects and a list of items, applies all predicates dynamically, and returns the filtered results.

### Complex Data Transformations

#### Nested Grouping:
- Given a list of employees with `name`, `department`, and `city`, group them by:
    - Department, then city.
    - City, then department.

#### Merging Streams:
- Given two lists of integers, merge them into a single stream and:
    - Remove duplicates.
    - Sort the merged list in reverse order.

#### Transaction Summary:
- Given a list of transactions with `id`, `amount`, and `type` (CREDIT or DEBIT), calculate:
    - The total amount for each type.
    - The transaction with the highest amount for each type.
    - A summary of transactions grouped by type.

#### Sliding Window Stream:
- Implement a method that takes a list of integers and a window size `k`, and returns a list of sums of all sliding windows of size `k`.

### Stream Performance and Optimization

#### Parallel Streams for Large Data:
- Process a very large list of integers in parallel to:
    - Compute the sum of all elements.
    - Find the frequency of each number. Measure the performance difference between sequential and parallel streams.

#### Stream Debugging:
- Debug a pipeline to print intermediate results at each stage (e.g., after `filter`, `map`, etc.) without disrupting the stream flow.

#### Concurrency with Streams:
- Write a program using parallel streams to process a list of files, reading their contents and finding the most frequent word across all files.

### Functional Programming Challenges

#### Dynamic Predicate Builder:
- Write a method to dynamically construct a `Predicate` for filtering a list of objects based on a set of conditions. For example:
    - Filter employees with a salary > 50,000 and who belong to a certain department.

#### Recursive Stream Operations:
- Implement a recursive solution using streams to:
    - Generate all permutations of a string.
    - Compute factorial using streams.

#### Event Scheduling:
- Given a list of events with start and end times, find all overlapping events using streams.

### Practical Use Cases

#### Stock Analysis:
- You are given a list of stock prices for each day in a week. Use streams to:
    - Find the maximum profit you can earn by buying and selling on different days.
    - Detect if any stock price has been repeated.

#### Route Optimization:
- Given a list of cities and distances between them, find:
    - The shortest route between two cities.
    - All cities within a certain distance of a given city.

#### Dependency Resolution:
- Given a list of tasks with dependencies (e.g., Task A depends on Task B), implement a topological sort to determine the order of execution using streams.

#### Data Transformation Pipeline:
- Implement a data transformation pipeline for an ETL process:
    - Read raw data (e.g., `String[]`), filter invalid entries, transform valid data into objects, and group by a key.

### Games and Simulations

#### Game Scoring System:
- Write a program to:
    - Simulate a game where players earn random scores.
    - Rank players by their total scores using streams.
    - Identify players with the top N highest scores.

#### Sudoku Validator:
- Given a 9x9 Sudoku grid, write a stream-based solution to validate the rows, columns, and 3x3 subgrids.

#### Dynamic Rule Engine:
- Create a dynamic rule engine where you can define rules as `Predicate` objects and apply them to a stream of data (e.g., filtering financial transactions).

### Advanced Concepts

#### Stream of Streams:
- Given a stream of sentences, split each sentence into words, and flatten it into a single stream of unique words sorted alphabetically.

#### Memory-efficient Large File Processing:
- Use streams to process a very large text file line-by-line to:
    - Count the number of lines containing a specific word.
    - Find the 10 most frequently used words.

#### Reactive Streams Simulation:
- Simulate a reactive stream using `Supplier` and `Stream.generate()`. Continuously generate new values until a condition is met.

#### Stream Pipelining with Multiple Outputs:
- Design a pipeline where a single stream processes a list of objects and produces multiple outputs simultaneously (e.g., even numbers to one list, odd numbers to another).
