# Recipe 05: Waiting for the Finalization of a Thread
## Overview
In certain scenarios, it is necessary to wait for a thread to complete its execution before proceeding with the rest of the program. 
For instance, a program might need to initialize resources before continuing with its main tasks. 
These initialization tasks can be executed as threads, and the program can wait for their completion using the `join()` method of the `Thread` class.
This method suspends the execution of the calling thread until the specified thread finishes its execution.
This recipe demonstrates the use of the `join()` method with an example of resource initialization.

## Files

- `Main.java`: The main class that creates and starts a thread.
- `DataSourceLoader.java`: A thread class that simulates loading data from a data source.
- `NetworkConnectionLoader.java`: A thread class that simulates loading data from a network source.

## How it works

1. **DataSourceLoader:**

    - Implements the `Runnable` interface.
    - The `run()` method simulates loading data from a data source by simply sleeping for four seconds.
    - Prints the start and end times of the data source loading process.
2. **NetworkConnectionsLoader:**

    - Implements the `Runnable` interface.
    - The `run()` method simulates loading a network connection by simply sleeping for six seconds.
    - Prints the start and end times of the network connection process.
3. **Main:**

    - Creates and starts a `DataSourceLoader` thread.
    - Creates and starts a `NetworkConnectionsLoader` thread.
    - Waits for both threads to complete using the `join()` method.

## Why it works
The `join()` method allows one thread to wait for the completion of another. 
When `join()` is called on a thread, the calling thread is blocked until the target thread completes. 
This ensures that the main thread waits for both the `DataSourceLoader` and `NetworkConnectionsLoader` threads to finish their execution before proceeding.

## Usage
To run the program, execute the `Main` class.
The program will start two threads that simulate loading data from different sources and wait for both threads to complete before exiting.

## Notes
- For more information on thread interruption and management, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.
- The Thread class provides methods such as `interrupt()`, `isInterrupted()`, and `interrupted()` to manage thread interruptions.
- Proper handling of thread interruptions is crucial for building responsive and robust multithreaded applications.
- Always ensure that threads can terminate gracefully by checking their interrupted status and releasing resources appropriately.