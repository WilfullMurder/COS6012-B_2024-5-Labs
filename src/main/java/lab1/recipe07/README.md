# Recipe 07: Processing Uncontrolled Exceptions in a Thread

Handling error situations is crucial in any programming language. 
Java, like most modern languages, uses an exception-based mechanism to manage errors. 
Exceptions are thrown by Java classes when an error is detected, and developers can also create custom exceptions to handle specific error scenarios.
Java distinguishes between checked exceptions, which must be caught or declared in the method signature, and unchecked exceptions, which do not need to be specified or caught.
When a checked exception is thrown inside the `run()` method of a thread, it must be caught and handled because the `run()` method cannot declare exceptions.
Unchecked exceptions, on the other hand, will cause the program to print the stack trace to the console and terminate. Java provides a mechanism to catch and handle unchecked exceptions in threads to prevent the program from ending unexpectedly. This recipe demonstrates this mechanism with an example.

## Files

- `Task.java`: A class that implements the `Runnable` interface and throws an exception.
- `ExceptionHandler.java`: A class that implements the `Thread.UncaughtExceptionHandler` interface.
- `Main.java`: The main class that creates and starts a thread.

## How it Works

1. **Task.java:**
    - Implements the `Runnable` interface.
    - The `run()` method throws an unchecked exception (`NumberFormatException`) when the thread is executed.
    - The exception is thrown when the thread is executed, and the stack trace is printed to the console.

2. **ExceptionHandler.java:**
    - Implements the `Thread.UncaughtExceptionHandler` interface.
    - The `uncaughtException()` method is called when an uncaught exception is detected in a thread.
    - The method prints the exception and the thread information to the console.

3. **Main.java:**
    - Creates a thread with a `Task` object and starts it.
    - Sets a custom uncaught exception handler for the thread.
    - The thread executes the `run()` method of the `Task` object.
    - The exception is thrown, and the stack trace is printed to the console by the custom exception handler.

## Why it Works

The `Thread.UncaughtExceptionHandler` interface provides a way to handle uncaught exceptions in threads. When an exception is thrown in a thread and not caught, the JVM calls the `uncaughtException()` method of the `Thread.UncaughtExceptionHandler` interface. This mechanism allows developers to define a custom behavior for handling uncaught exceptions in threads.

## Exception Types

- **Checked exceptions**: Must be specified in the `throws` clause of a method or caught within the method, such as `IOException` or `ClassNotFoundException`.
- **Unchecked exceptions**: Do not need to be specified or caught, such as `NumberFormatException`.

## Usage

To run the program, execute the `Main` class. The program will start a thread that throws an exception when executed. The exception is caught by the `Thread.UncaughtExceptionHandler` interface, and the stack trace is printed to the console.

## Notes

- The `Thread.UncaughtExceptionHandler` interface is a functional interface, so it can be implemented as a lambda expression.
- This example demonstrates handling unchecked exceptions in a thread to prevent the program from terminating unexpectedly.
- For more information on thread management and synchronization, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.