# Prime Number Calculation Using Threads

This program demonstrates the use of threads in Java to perform concurrent calculations of prime numbers. The program creates multiple threads, each calculating the number of prime numbers within a specified range.

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

## Usage

To run the program, execute the `Main` class. The program will output the status of each thread to the console and write detailed thread information to the log file located at `src/main/resources/data/recipe01-log.txt`.

## Log File

The log file `recipe01-log.txt` contains the following information for each thread:
- Initial status
- Thread ID and name
- Thread priority
- Old and new state of the thread
- A separator line for readability