# File Search with Interruption Exception

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

## Usage
To run the program, execute the `Main` class. The program will search for a file and interrupt the thread after 10 seconds, printing the thread's status to the console.

## Note
The program expects to find the Windows `C:\` directory. If you are using a different operating system, you may need to modify the directory path in the `Main` class.