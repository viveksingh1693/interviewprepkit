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

