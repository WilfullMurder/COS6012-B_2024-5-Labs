# Recipe 01: Creating, Running, and Setting the Characteristics of a Thread

## Overview
In this recipe, we will explore basic operations on threads using the Java API. 
Threads in Java are objects, and there are two primary ways to create them: 
 - by extending the `Thread` class and overriding the `run()` method,
 - or by implementing the `Runnable` interface and passing an instance of it to a `Thread` object.

The latter approach is preferred due to its flexibility.

We will use the `Runnable` interface to create threads and then modify their attributes. The `Thread` class in Java stores several attributes that help identify and manage threads, such as:
- **ID**: A unique identifier for each thread.
- **Name**: The name of the thread.
- **Priority**: The priority of the thread, ranging from 1 (lowest) to 10 (highest). Although changing thread priority is possible, it is generally not recommended as it only serves as a hint to the operating system.
- **Status**: The current state of the thread, which can be one of the following:
   - **NEW**: The thread has been created but not yet started.
   - **RUNNABLE**: The thread is executing in the JVM.
   - **BLOCKED**: The thread is blocked and waiting for a monitor.
   - **WAITING**: The thread is waiting for another thread.
   - **TIMED_WAITING**: The thread is waiting for another thread with a specified waiting time.
   - **TERMINATED**: The thread has finished its execution.

In this recipe, we will create and run 10 threads to calculate prime numbers within the first 20,000 numbers. The following sections will provide detailed information on the implementation and usage of this example.

## Files

- `Main.java`: The main class that initiates the threads and manages their execution.
- `Calculator.java`: A thread class that calculates the number of prime numbers within a given range.

## How It Works

1. **Main.java**:
    - Prints the minimum, normal, and maximum thread priorities.
    - Creates an array of 10 threads, alternating between maximum and minimum priority.
    - Writes the initial status of each thread to a log file.
    - Starts all threads.
    - Monitors the status of each thread and writes any changes to the log file.
    - Waits for all threads to complete before exiting.

2. **Calculator.java**:
    - Implements the `Runnable` interface.
    - The `run()` method calculates the number of prime numbers up to 2000.
    - Prints the start and end of each thread along with the number of primes found.

## Why It Works
Concurrency in Java allows multiple threads to run simultaneously, improving the efficiency and performance of applications. 
By using the Java API, you can create and manage threads effectively. 
The `Thread` class and `Runnable` interface provide the foundation for thread creation. 
Extending the `Thread` class or implementing the `Runnable` interface allows you to define the behavior of threads.  In this lab, we demonstrate various thread operations, such as creating, running, interrupting, and managing threads. 
By understanding and utilizing these operations, you can build robust multithreaded applications. 
The examples provided illustrate how to handle thread attributes, control thread execution, and manage thread groups, ensuring that threads operate smoothly and efficiently.
### Log File

The log file `recipe01-log.txt` contains the following information for each thread:
- Initial status
- Thread ID and name
- Thread priority
- Old and new state of the thread
- A separator line for readability

## Usage

To run the program, execute the `Main` class. The program will output the status of each thread to the console and write detailed thread information to the log file located at `src/main/resources/data/recipe01-log.txt`.

## Notes
- For more information on concurrency and thread management, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.
- The `Thread` class and `Runnable` interface are part of the `java.lang` package, which provides essential classes for Java programming.
- Proper thread management is crucial for building responsive and efficient applications. Always ensure that threads are created, managed, and terminated appropriately.
- Understanding thread states and handling interruptions are key aspects of developing multithreaded applications.