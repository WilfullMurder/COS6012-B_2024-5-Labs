# Recipe 02: Interrupting a Thread

## Overview
In **Java**, a program with multiple execution threads only finishes when all non-daemon threads have completed their execution or when one of the threads calls the `System.exit()` method. 
There are scenarios where you may need to terminate a thread, such as when ending a program or when a user cancels the tasks being performed by a thread.
**Java** provides an interruption mechanism to signal a thread that it should stop. 
However, the thread itself must check for this interruption and decide whether to terminate or continue its execution.
This means a thread can choose to ignore the interruption request.
In this recipe, we will create a program that starts a thread and forces its termination after 5 seconds using the interruption mechanism. 
The following sections will provide detailed information on the implementation and usage of this example.

## Files

- `Main.java`: The main class that initiates the thread and manages its interruption.
- `PrimeGenerator.java`: A thread class that generates prime numbers indefinitely.

## How It Works

1. **PrimeGenerator.java**:
    - Extends the `Thread` class.
    - The `run()` method generates prime numbers indefinitely.
    - Checks for interruption using the `isInterrupted()` method and stops execution if interrupted.

2. **Main.java**:
    - Creates and starts a `PrimeGenerator` thread.
    - Sleeps for 5 seconds.
    - Interrupts the `PrimeGenerator` thread.
    - Prints the status of the thread after interruption.

## Why It Works
The interruption mechanism in Java allows a thread to signal another thread that it should stop executing. 
This is done by calling the `interrupt()` method on the target thread. 
The target thread must periodically check its interrupted status using the `isInterrupted()` method and decide whether to terminate or continue its execution.
This approach ensures that threads can be stopped gracefully and allows them to clean up resources before terminating.  In the provided example, the PrimeGenerator thread continuously generates prime numbers and checks for interruptions. When the Main class interrupts the PrimeGenerator thread after 5 seconds, the thread detects the interruption and stops generating prime numbers, demonstrating how the interruption mechanism works in practice.

## Usage
To run the program, execute the `Main` class. 
The program will generate prime numbers and interrupt the thread after 5 seconds,
printing the thread's status to the console.

## Notes
- For more information on thread interruption and management, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.
- The Thread class provides methods such as `interrupt()`, `isInterrupted()`, and `interrupted()` to manage thread interruptions.
- Proper handling of thread interruptions is crucial for building responsive and robust multithreaded applications.
- Always ensure that threads can terminate gracefully by checking their interrupted status and releasing resources appropriately.