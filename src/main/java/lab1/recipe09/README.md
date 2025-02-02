# Recipe 09: Grouping Threads and Processing Uncontrolled Exceptions in a Group of Threads

## Overview
The concurrency API in Java offers a useful feature that allows threads to be grouped together. 
This enables treating a group of threads as a single unit and provides access to the thread objects within the group to perform operations on them. 
For instance, if you have multiple threads performing the same task, you can control them collectively, 
such as interrupting all threads in the group with a single call.

Java's `ThreadGroup` class facilitates working with groups of threads. 
A `ThreadGroup` object can consist of thread objects and other `ThreadGroup` objects, 
forming a tree structure of threads.

In the "Controlling the interruption of a thread" recipe, 
a generic method was used to handle all uncaught exceptions thrown by a thread object.
Similarly, in the recipe, a handler was written to process uncaught exceptions thrown by a thread. 
This mechanism can also be applied to process uncaught exceptions thrown by a thread or a group of threads.

## Files

- `MyThreadGroup.java` - Stores thread objects and other `ThreadGroup` objects associated with it, so it can access all of their information (status, for example) and perform operations over all its members (interrupt, for example).
- `Task.java` - A task that generates random numbers and may throw an exception.
- `Main.java` - The entry point that sets up the thread group and starts the threads.

## How it Works
1. **MyThreadGroup:**
   - Extends the `ThreadGroup` class and overrides the `uncaughtException` method to handle uncaught exceptions thrown by any thread in the group.
   - When an exception is thrown, it prints the exception details and interrupts all threads in the group.

2. **Task:**
   - Implements the `Runnable` interface.
   - Generates random numbers and may throw an `ArithmeticException`.
   - Checks if the thread is interrupted and exits if it is.

3. **Main:**
   - Creates a `MyThreadGroup` instance.
   - Creates and starts multiple threads in the group, each running an instance of `Task`.
   - Prints the number of active threads and their states.

## Why it Works
When an uncaught exception is thrown in a `Thread` object, 
the JVM searches for three possible handlers for this exception. 
Initially, it looks for the uncaught exception handler of the thread. 
If this handler is not present, the JVM then checks for the uncaught exception handler of the `ThreadGroup` class of the thread. 
If this method is also absent, the JVM finally looks for the default uncaught exception handler. 
If none of these handlers exist, the JVM writes the stack trace of the exception to the console and terminates the execution of the thread that threw the exception.
## Usage
To run the program, execute the `Main` class. The program will create a thread group, start multiple threads, and handle any uncaught exceptions thrown by the threads.

## Notes
- The number of threads created is twice the number of available processors.
- The `Task` class generates random numbers and may throw an `ArithmeticException`.
- The `MyThreadGroup` class handles uncaught exceptions and interrupts all threads in the group when an exception is thrown.