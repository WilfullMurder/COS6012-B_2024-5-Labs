# Recipe 04: Sleeping and Resuming a Thread
In Java, there are scenarios where you may need to pause the execution of a thread for a specific period. 
For instance, a thread might check a sensor's state once per minute and remain idle for the rest of the time, conserving system resources. 
The `sleep()` method of the Thread class is used to achieve this. 
By passing a duration in **milliseconds** to the `sleep()` method, 
the thread suspends its execution for that period. 
Once the time elapses, the thread resumes execution when the JVM schedules it. 
Alternatively, the `TimeUnit` **enumeration** can be used to specify the sleep duration in different units, which are then converted to milliseconds.
This recipe demonstrates how to use the `sleep()` method to print the current date every second.

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

## Notes
- For more information on thread interruption and management, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.
- The Thread class provides methods such as `interrupt()`, `isInterrupted()`, and `interrupted()` to manage thread interruptions.
- Proper handling of thread interruptions is crucial for building responsive and robust multithreaded applications.
- Always ensure that threads can terminate gracefully by checking their interrupted status and releasing resources appropriately.