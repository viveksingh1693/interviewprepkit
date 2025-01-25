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
