# Waiting for the finalization of a thread
This program demonstrates how to wait for the finalization of a thread in Java.


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


## Usage
