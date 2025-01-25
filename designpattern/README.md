# Design Patterns

## Behavioral Design Patterns

### Chain Of Responsibility

**Chain of Responsibility Design Pattern**

**What**

**Definition:** It is a pattern where multiple objects are given the chance to process a request, and the request is passed along the chain until it is handled or reaches the end.

**Key Components:**
- **Handler:** An interface or abstract class defining a method to handle the request.
- **Concrete Handler:** Classes that implement or extend the Handler and determine whether to process the request or forward it to the next handler.
- **Client:** The requester that sends a request into the chain.

**Why**
- **Separation of Concerns:** Decouples the sender of a request from its receivers.
- **Flexibility:** Allows new handlers to be added without modifying the existing code.
- **Dynamic Composition:** Enables runtime configuration of the chain.
- **Responsibility Delegation:** Distributes responsibility among a series of handlers, promoting cleaner and more maintainable code.

**When**

Use the Chain of Responsibility pattern when:
- **Multiple Handlers Are Possible:** You need several handlers to process a request, but only one should handle it.  
    *Example: Logging at different levels (debug, info, error).*
- **Dynamic Handler Configuration:** The chain of handlers may change at runtime.  
    *Example: Payment processing where different methods are tried in sequence.*
- **Decoupling:** The client should not know which handler will process its request.  
    *Example: User authentication systems with multiple validation steps.*
    **UML Diagram**

    Below is a UML diagram representing the Chain of Responsibility design pattern:

    ```plaintext
    +-------------------+        +-------------------+        +-------------------+
    |      Client       |        |      Handler      |        | ConcreteHandler1  |
    |-------------------|        |-------------------|        |-------------------|
    | - handler: Handler|        | + handleRequest() |        | + handleRequest() |
    | + sendRequest()   |        | + setNextHandler()|        |                   |
    +-------------------+        +-------------------+        +-------------------+
        |                           ^                             ^
        |                           |                             |
        v                           |                             |
    +-------------------+               |                             |
    | ConcreteHandler2  |               |                             |
    |-------------------|               |                             |
    | + handleRequest() |---------------+                             |
    |                   |                                             |
    +-------------------+                                             |
                                      |
                                      |
                                      v
                                +-------------------+
                                | ConcreteHandler3  |
                                |-------------------|
                                | + handleRequest() |
                                |                   |
                                +-------------------+
    ```

    In this diagram:
    - The `Client` sends a request to the first `Handler`.
    - Each `Handler` can either process the request or pass it to the next handler in the chain.
    - `ConcreteHandler1`, `ConcreteHandler2`, and `ConcreteHandler3` are specific implementations of the `Handler` interface.


### Command

**Command Design Pattern**

**What**

**Definition:** It is a pattern where an object is used to encapsulate all information needed to perform an action or trigger an event at a later time.

**Key Components:**
- **Command:** An interface for executing an operation.
- **ConcreteCommand:** Classes that implement the Command interface.
- **Invoker:** The object that invokes the command.
- **Receiver:** The object that performs the actual action.

**Why**
- **Encapsulation:** Encapsulates a request as an object.
- **Undo/Redo:** Supports undoable operations.
- **Decoupling:** Decouples the sender and receiver of a request.

**When**

Use the Command pattern when:
- **Parameterization:** You need to parameterize objects with operations.  
    *Example: Menu items in a GUI application.*
- **Undo/Redo:** You need to support undo and redo operations.  
    *Example: Text editors with undo and redo functionality.*
- **Decoupling:** You want to decouple the sender and receiver of a request.  
    *Example: A remote control that can operate various devices.*

    **UML Diagram**

    Below is a UML diagram representing the Command design pattern:

    ```plaintext
    +-------------------+        +-------------------+        +-------------------+
    |     Client        |        |     Invoker       |        |    Command        |
    |-------------------|        |-------------------|        |-------------------|
    | - command: Command|        | - command: Command|        | + execute()       |
    | + setCommand()    |        | + setCommand()    |        +-------------------+
    | + executeCommand()|        | + invoke()        |                ^
    +-------------------+        +-------------------+                |
        |                           ^                             |
        |                           |                             |
        v                           |                             |
    +-------------------+               |                             |
    | ConcreteCommand   |---------------+                             |
    |-------------------|                                             |
    | + execute()       |---------------------------------------------+
    | - receiver: Receiver|
    +-------------------+
        |
        v
    +-------------------+
    |    Receiver       |
    |-------------------|
    | + action()        |
    +-------------------+
    ```

    In this diagram:
    - The `Client` creates a `ConcreteCommand` and sets its `Receiver`.
    - The `Client` sets the `ConcreteCommand` in the `Invoker`.
    - The `Invoker` calls the `execute` method on the `ConcreteCommand`.
    - The `ConcreteCommand` calls the `action` method on the `Receiver`.

    **Real-Time Example in Java**

    The `java.lang.Runnable` interface represents the Command pattern. We create objects of classes implementing `Runnable`, providing all the information they need. In the `run` method, we call an operation on the receiver. We can send this object for later execution to other parts of our application.

    ```java
    public class CommandExample implements Runnable {
        private final Receiver receiver;

        public CommandExample(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void run() {
            receiver.performAction();
        }
    }

    public class Receiver {
        public void performAction() {
            System.out.println("Action performed by the receiver.");
        }
    }

    public class Client {
        public static void main(String[] args) {
            Receiver receiver = new Receiver();
            Runnable command = new CommandExample(receiver);

            // Execute the command later
            new Thread(command).start();
        }
    }
    ```

    In this example:
    - The `CommandExample` class implements the `Runnable` interface and encapsulates the action to be performed.
    - The `Receiver` class contains the actual business logic.
    - The `Client` class creates the command and executes it in a separate thread.

    **Real-Time Example in Java and Spring Framework**

    Let's consider a real-time example of the Command pattern in a Java application using the Spring Framework. We will create a simple task scheduling system where different tasks can be scheduled and executed.

    **Java Implementation**

    1. **Command Interface:**

        ```java
        public interface Command {
            void execute();
        }
        ```

    2. **ConcreteCommand Classes:**

        ```java
        public class EmailTask implements Command {
            private EmailService emailService;

            public EmailTask(EmailService emailService) {
                this.emailService = emailService;
            }

            @Override
            public void execute() {
                emailService.sendEmail();
            }
        }

        public class SmsTask implements Command {
            private SmsService smsService;

            public SmsTask(SmsService smsService) {
                this.smsService = smsService;
            }

            @Override
            public void execute() {
                smsService.sendSms();
            }
        }
        ```

    3. **Receiver Classes:**

        ```java
        public class EmailService {
            public void sendEmail() {
                System.out.println("Sending email...");
            }
        }

        public class SmsService {
            public void sendSms() {
                System.out.println("Sending SMS...");
            }
        }
        ```

    4. **Invoker Class:**

        ```java
        public class TaskScheduler {
            private Command command;

            public void setCommand(Command command) {
                this.command = command;
            }

            public void scheduleTask() {
                command.execute();
            }
        }
        ```

    5. **Client Code:**

        ```java
        public class Client {
            public static void main(String[] args) {
                EmailService emailService = new EmailService();
                SmsService smsService = new SmsService();

                Command emailTask = new EmailTask(emailService);
                Command smsTask = new SmsTask(smsService);

                TaskScheduler scheduler = new TaskScheduler();

                scheduler.setCommand(emailTask);
                scheduler.scheduleTask();

                scheduler.setCommand(smsTask);
                scheduler.scheduleTask();
            }
        }
        ```

    **Spring Framework Integration**

    In a Spring application, you can use the Command pattern to schedule tasks using Spring's scheduling capabilities.

    1. **Spring Configuration:**

        ```java
        @Configuration
        @EnableScheduling
        public class AppConfig {
            @Bean
            public EmailService emailService() {
                return new EmailService();
            }

            @Bean
            public SmsService smsService() {
                return new SmsService();
            }

            @Bean
            public TaskScheduler taskScheduler() {
                return new TaskScheduler();
            }
        }
        ```

    2. **Spring Scheduler:**

        ```java
        @Component
        public class SpringTaskScheduler {
            private final TaskScheduler taskScheduler;
            private final EmailService emailService;
            private final SmsService smsService;

            @Autowired
            public SpringTaskScheduler(TaskScheduler taskScheduler, EmailService emailService, SmsService smsService) {
                this.taskScheduler = taskScheduler;
                this.emailService = emailService;
                this.smsService = smsService;
            }

            @Scheduled(fixedRate = 5000)
            public void scheduleEmailTask() {
                Command emailTask = new EmailTask(emailService);
                taskScheduler.setCommand(emailTask);
                taskScheduler.scheduleTask();
            }

            @Scheduled(fixedRate = 10000)
            public void scheduleSmsTask() {
                Command smsTask = new SmsTask(smsService);
                taskScheduler.setCommand(smsTask);
                taskScheduler.scheduleTask();
            }
        }
        ```

    In this example:
    - The `SpringTaskScheduler` schedules tasks at fixed intervals using Spring's `@Scheduled` annotation.
    - The `TaskScheduler` class is used to execute the commands.
    - The `EmailTask` and `SmsTask` classes encapsulate the actions to be performed.

    This demonstrates how the Command pattern can be implemented in a Java application and integrated with the Spring Framework for task scheduling.

    ### Interpreter

    **Interpreter Design Pattern**

    **What**

    **Definition:** The Interpreter pattern is used to define a grammatical representation for a language and provide an interpreter to deal with this grammar.

    **Key Components:**
    - **AbstractExpression:** Declares an abstract `interpret` method.
    - **TerminalExpression:** Implements the `interpret` method for terminal symbols in the grammar.
    - **NonTerminalExpression:** Implements the `interpret` method for non-terminal symbols in the grammar.
    - **Context:** Contains information that is global to the interpreter.
    - **Client:** Builds the abstract syntax tree representing a particular sentence in the language defined by the grammar.

    **Why**
    - **Language Representation:** Useful for designing a language interpreter.
    - **Grammar Implementation:** Helps in implementing and interpreting a grammar.
    - **Extensibility:** Easy to extend the grammar by adding new expressions.

    **When**

    Use the Interpreter pattern when:
    - **Language Parsing:** You need to interpret sentences in a language.  
        *Example: Parsing and evaluating mathematical expressions.*
    - **Grammar Representation:** You need to represent a grammar and interpret sentences in that grammar.  
        *Example: SQL query parsing and execution.*
    - **Complex Parsing Logic:** You need to simplify complex parsing logic by breaking it into smaller, manageable expressions.  
        *Example: Interpreting and executing commands in a scripting language.*

    **UML Diagram**

    Below is a UML diagram representing the Interpreter design pattern:

    ```plaintext
    +-------------------+        +-------------------+        +-------------------+
    |     Client        |        | AbstractExpression|        | TerminalExpression|
    |-------------------|        |-------------------|        |-------------------|
    | - context: Context|        | + interpret()     |        | + interpret()     |
    | + buildSyntaxTree()|       +-------------------+        +-------------------+
    | + interpret()     |                ^                             ^
    +-------------------+                |                             |
            |                            |                             |
            v                            |                             |
    +-------------------+                |                             |
    | NonTerminalExpression|-------------+                             |
    |-------------------|                                              |
    | + interpret()     |----------------------------------------------+
    +-------------------+
            |
            v
    +-------------------+
    |     Context       |
    |-------------------|
    | - input: String   |
    | - output: String  |
    +-------------------+
    ```

    In this diagram:
    - The `Client` builds the syntax tree and invokes the `interpret` method.
    - `AbstractExpression` declares the `interpret` method.
    - `TerminalExpression` and `NonTerminalExpression` implement the `interpret` method.
    - `Context` contains information for interpretation.

    **Real-Time Example in Java**

    Let's consider a simple example of interpreting mathematical expressions.

    1. **AbstractExpression Interface:**

        ```java
        public interface Expression {
            int interpret();
        }
        ```

    2. **TerminalExpression Classes:**

        ```java
        public class Number implements Expression {
            private int number;

            public Number(int number) {
                this.number = number;
            }

            @Override
            public int interpret() {
                return number;
            }
        }
        ```

    3. **NonTerminalExpression Classes:**

        ```java
        public class Add implements Expression {
            private Expression leftExpression;
            private Expression rightExpression;

            public Add(Expression leftExpression, Expression rightExpression) {
                this.leftExpression = leftExpression;
                this.rightExpression = rightExpression;
            }

            @Override
            public int interpret() {
                return leftExpression.interpret() + rightExpression.interpret();
            }
        }

        public class Subtract implements Expression {
            private Expression leftExpression;
            private Expression rightExpression;

            public Subtract(Expression leftExpression, Expression rightExpression) {
                this.leftExpression = leftExpression;
                this.rightExpression = rightExpression;
            }

            @Override
            public int interpret() {
                return leftExpression.interpret() - rightExpression.interpret();
            }
        }
        ```

    4. **Client Code:**

        ```java
        public class InterpreterClient {
            public static void main(String[] args) {
                Expression expression = new Add(new Number(10), new Subtract(new Number(20), new Number(5)));
                int result = expression.interpret();
                System.out.println("Result: " + result); // Output: Result: 25
            }
        }
        ```

    In this example:
    - The `Number` class represents terminal expressions.
    - The `Add` and `Subtract` classes represent non-terminal expressions.
    - The `InterpreterClient` builds the syntax tree and interprets the expression.

    This demonstrates how the Interpreter pattern can be used to interpret mathematical expressions in Java.

### Example of Interpreter in Java

The `java.util.regex.Pattern` class is an example of the interpreter pattern in the Java class library. A `Pattern` instance is created with an internal abstract syntax tree, representing the grammar rules, during the static method `compile()`. After that, we check a sentence against this grammar using `Matcher`.

```java
Pattern pattern = Pattern.compile("ADMIN", Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher("admin user");
while (matcher.find()) {
    System.out.println("has required permission: " + matcher.group());
}
```


### Iterator

**Iterator Design Pattern**

**What**

**Definition:** The Iterator pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

**Key Components:**
- **Iterator:** An interface for accessing and traversing elements.
- **ConcreteIterator:** A class that implements the Iterator interface.
- **Aggregate:** An interface for creating an Iterator object.
- **ConcreteAggregate:** A class that implements the Aggregate interface and returns an instance of the ConcreteIterator.

**Why**
- **Encapsulation:** Encapsulates the traversal logic of a collection.
- **Uniformity:** Provides a uniform way to traverse different collections.
- **Separation of Concerns:** Separates the traversal logic from the collection's internal structure.

**When**

Use the Iterator pattern when:
- **Multiple Traversals:** You need to traverse a collection in different ways.  
    *Example: Traversing a list forward and backward.*
- **Uniform Traversal:** You want to provide a uniform interface for traversing different collections.  
    *Example: Iterating over a list, set, or map in a consistent manner.*
- **Decoupling:** You want to decouple the traversal logic from the collection's internal structure.  
    *Example: Iterating over a custom data structure without exposing its internal details.*

**UML Diagram**

Below is a UML diagram representing the Iterator design pattern:

```plaintext
+-------------------+        +-------------------+        +-------------------+
|     Client        |        |     Iterator      |        | ConcreteIterator  |
|-------------------|        |-------------------|        |-------------------|
| - aggregate: Aggregate|    | + hasNext()       |        | + hasNext()       |
| + iterate()       |        | + next()          |        | + next()          |
+-------------------+        +-------------------+        +-------------------+
        |                           ^                             ^
        |                           |                             |
        v                           |                             |
+-------------------+               |                             |
|    Aggregate      |---------------+                             |
|-------------------|                                             |
| + createIterator()|---------------------------------------------+
+-------------------+
        |
        v
+-------------------+
| ConcreteAggregate |
|-------------------|
| + createIterator()|
+-------------------+
```

In this diagram:
- The `Client` uses the `Iterator` to traverse the `Aggregate`.
- `Iterator` defines the interface for traversal.
- `ConcreteIterator` implements the `Iterator` interface.
- `Aggregate` defines the interface for creating an `Iterator`.
- `ConcreteAggregate` implements the `Aggregate` interface and returns an instance of `ConcreteIterator`.

**Real-Time Example in Java**

The `java.util.Iterator` interface is an example of the Iterator pattern. Here's a simple example of using an iterator to traverse a list.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }
}
```

In this example:
- The `ArrayList` class implements the `Iterable` interface, which provides an `iterator` method.
- The `Iterator` interface provides methods for traversing the list (`hasNext` and `next`).
- The `IteratorExample` class demonstrates how to use the iterator to traverse the list.

This demonstrates how the Iterator pattern can be used to traverse a collection in Java.


### Strategy

**Strategy Design Pattern**

**What**

**Definition:** The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern allows the algorithm to vary independently from clients that use it.

**Key Components:**
- **Strategy:** An interface common to all supported algorithms.
- **ConcreteStrategy:** Classes that implement the Strategy interface.
- **Context:** The class that uses a Strategy.

**Why**
- **Flexibility:** Allows switching between algorithms at runtime.
- **Encapsulation:** Encapsulates the algorithm implementation details.
- **Separation of Concerns:** Separates the algorithm from the context in which it is used.

**When**

Use the Strategy pattern when:
- **Multiple Algorithms:** You need to use different variants of an algorithm.  
    *Example: Different sorting algorithms (quick sort, merge sort, bubble sort).*
- **Runtime Decisions:** The algorithm needs to be selected at runtime.  
    *Example: Payment processing with different payment methods (credit card, PayPal, bank transfer).*
- **Avoiding Conditional Statements:** You want to avoid complex conditional statements for selecting algorithms.  
    *Example: Different tax calculation strategies based on country.*

**UML Diagram**

Below is a UML diagram representing the Strategy design pattern:

```plaintext
+-------------------+        +-------------------+        +-------------------+
|     Context       |        |     Strategy      |        | ConcreteStrategyA |
|-------------------|        |-------------------|        |-------------------|
| - strategy: Strategy|      | + execute()       |        | + execute()       |
| + setStrategy()   |        +-------------------+        +-------------------+
| + executeStrategy()|               ^                             ^
+-------------------+                |                             |
        |                            |                             |
        v                            |                             |
+-------------------+                |                             |
| ConcreteStrategyB |----------------+                             |
|-------------------|                                              |
| + execute()       |----------------------------------------------+
+-------------------+
```

In this diagram:
- The `Context` uses a `Strategy` to execute an algorithm.
- `Strategy` defines the interface for the algorithm.
- `ConcreteStrategyA` and `ConcreteStrategyB` implement the `Strategy` interface.

**Real-Time Example in Java**

Let's consider a simple example of using the Strategy pattern for different sorting algorithms.

1. **Strategy Interface:**

    ```java
    public interface SortingStrategy {
        void sort(int[] array);
    }
    ```

2. **ConcreteStrategy Classes:**

    ```java
    public class BubbleSortStrategy implements SortingStrategy {
        @Override
        public void sort(int[] array) {
            // Bubble sort algorithm
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    public class QuickSortStrategy implements SortingStrategy {
        @Override
        public void sort(int[] array) {
            quickSort(array, 0, array.length - 1);
        }

        private void quickSort(int[] array, int low, int high) {
            if (low < high) {
                int pi = partition(array, low, high);
                quickSort(array, low, pi - 1);
                quickSort(array, pi + 1, high);
            }
        }

        private int partition(int[] array, int low, int high) {
            int pivot = array[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (array[j] < pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;
            return i + 1;
        }
    }
    ```

3. **Context Class:**

    ```java
    public class SortingContext {
        private SortingStrategy strategy;

        public void setStrategy(SortingStrategy strategy) {
            this.strategy = strategy;
        }

        public void sortArray(int[] array) {
            strategy.sort(array);
        }
    }
    ```

4. **Client Code:**

    ```java
    public class StrategyPatternExample {
        public static void main(String[] args) {
            int[] array = {5, 2, 9, 1, 5, 6};

            SortingContext context = new SortingContext();

            // Using BubbleSortStrategy
            context.setStrategy(new BubbleSortStrategy());
            context.sortArray(array);
            System.out.println("Bubble Sorted: " + Arrays.toString(array));

            // Using QuickSortStrategy
            context.setStrategy(new QuickSortStrategy());
            context.sortArray(array);
            System.out.println("Quick Sorted: " + Arrays.toString(array));
        }
    }
    ```

In this example:
- The `SortingStrategy` interface defines the sorting algorithm.
- The `BubbleSortStrategy` and `QuickSortStrategy` classes implement the `SortingStrategy` interface.
- The `SortingContext` class uses a `SortingStrategy` to sort an array.
- The `StrategyPatternExample` class demonstrates how to use different sorting strategies.

This demonstrates how the Strategy pattern can be used to implement different sorting algorithms in Java.