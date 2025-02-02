# Recipe 03: Controlling the Interruption of a Thread

This program demonstrates how to control the interruption of a thread that is implementing a more complex algorithm divided into some methods.
`Java` provides the `InterruptedException` exception for this purpose.
The program creates a thread that searches for a file in a directory and its subdirectories, and interrupts it after 10 seconds.
Additionally, the control mechanism can also be used for methods with recursive calls.

## Files
- `FileSearch.java`: A thread class that searches for a file in a directory and its subdirectories.
- `Main.java`: The main class that initiates the thread and manages its interruption.

## How It Works
1. **FileSearch.java**:
    - Implements the `Runnable` interface.
    - The `run()` method searches for a file in a directory and its subdirectories.
    - The `searchFiles()` method is a recursive method that searches for the file in the directory and its subdirectories.
    - Checks for interruption using the `isInterrupted()` method and stops execution if interrupted.
2. **Main.java**:
    - Creates and starts a `FileSearch` thread.
    - Sleeps for 10 seconds.
    - Interrupts the `FileSearch` thread.
    - Prints the status of the thread after interruption.

## Why it Works
The interruption mechanism in Java allows a thread to signal another thread that it should stop executing. 
This is done by calling the `interrupt()` method on the target thread. 
The target thread must periodically check its interrupted status using the `isInterrupted()` method and decide whether to terminate or continue its execution. 
This approach ensures that threads can be stopped gracefully and allows them to clean up resources before terminating.  
In the provided example, the `FileSearch` thread recursively searches for files and checks for interruptions. 
When the `Main` class interrupts the `FileSearch` thread after 10 seconds, the thread detects the interruption and stops searching, 
demonstrating how the interruption mechanism works in practice.

## Usage
To run the program, execute the `Main` class. The program will search for a file and interrupt the thread after 10 seconds, printing the thread's status to the console.

## Notes
- The program expects to find the Windows `C:\` directory. If you are using a different operating system, you may need to modify the directory path in the `Main` class.
- For more information on thread interruption and management, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch. 
- The `Thread` class provides methods such as `interrupt()`, `isInterrupted()`, and `interrupted()` to manage thread interruptions.
- Proper handling of thread interruptions is crucial for building responsive and robust multithreaded applications. 
- Always ensure that threads can terminate gracefully by checking their interrupted status and releasing resources appropriately.