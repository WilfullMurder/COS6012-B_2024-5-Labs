# Console Clock with Sleep and Resume
This program demonstrates how to sleep and resume a thread in Java. 
The program creates a thread that prints the current data and time to the console every second and interrupts it after 5 seconds. 
The thread is then resumed after 1 second.

## Files

- `Main.java`: The main class that initiates the `ConsoleClock` thread and manages its interruption.
- `ConsoleClock.java`: A thread class that prints the current date and time to the console every second.

## How It Works

1. **ConsoleClock.java:**:
    - Implements the `Runnable` interface.
    - The `run()` method prints the current date and time to the console every second.
    - Checks for interruption using the `isInterrupted()` method and stops execution if interrupted.
2. **Main.java**:
    - Creates and starts a `ConsoleClock` thread.
    - Sleeps for 5 seconds.
    - Interrupts the `ConsoleClock` thread.
    - Prints a message if the thread is interrupted.

## Why it Works
When the `sleep()` method is **invoked**, the thread relinquishes the **CPU** and halts its execution for a specified duration.
During this period, it does not consume **CPU** resources, allowing the **CPU** to perform other tasks. 
If the thread is interrupted while sleeping, the `sleep()` method throws an `InterruptedException`,
causing the thread to stop its execution immediately without waiting for the sleep duration to complete.

## Usage
To run the program, execute the `Main` class. The program will print the current data and time to the console every second and interrupt the thread after 5 seconds, 
printing the message to the console.