# Prime Number Generation with Interruption

This program demonstrates how to interrupt a thread in Java. The program creates a thread that generates prime numbers indefinitely and interrupts it after 5 seconds.

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

## Usage

To run the program, execute the `Main` class. The program will generate prime numbers and interrupt the thread after 5 seconds, printing the thread's status to the console.