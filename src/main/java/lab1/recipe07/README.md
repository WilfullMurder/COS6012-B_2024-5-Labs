# Processing Uncontrolled Exceptions in a Thread

An essential feature in every programming language is the mechanism for handling error situations in applications. The Java programming language, like most modern languages, uses an exception-based system to manage errors. Java classes throw exceptions when an error is detected. Developers can also use these exceptions or create custom exceptions to handle errors in their classes.

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