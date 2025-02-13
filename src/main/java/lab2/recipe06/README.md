# Recipe 06: Advanced locking with the `StampedLock` class

## Overview
The `StampedLock` class provides a unique locking mechanism that differs from the `Lock` and `ReadWriteLock` interfaces. 
It is designed to help implement thread-safe components and offers three modes of locking: 
- write, 
- read, 
- and optimistic read. 

The write mode provides exclusive access, the read mode allows multiple threads to read concurrently, and the optimistic read mode allows non-exclusive access with validation. The `StampedLock` class includes methods to acquire, convert, and release locks, and it returns a stamp to manage lock operations. 
This recipe demonstrates how to use `StampedLock` to implement a thread-safe component.
## Files

- `Main.java` - The entry point of the application.
- `Writer.java` - Simulates a writer that updates the position.
- `Reader.java` - Simulates a reader that reads the position. 
- `OptimisticReader.java` - Simulates an optimistic reader that reads the position. 
- `Position.java` - Stores the position and manages access using a `StampedLock`.

## How it Works
1. **Position.java:**
   - Stores the coordinates (x, y) of a position.
   - Uses a StampedLock to control access.
   - Provides methods to read and update the position using different lock modes.
2. **Writer.java:**
   - Simulates a writer that updates the position by acquiring the write lock.
3. **Reader.java:**
   - Simulates a reader that reads the position by acquiring the read lock.
4. **OptimisticReader.java:**
   - Simulates an optimistic reader that reads the position using the optimistic read lock and validates access.
5. **Main.java:**
    - Sets up the writer, reader, and optimistic reader threads and starts them.

## Why it Works
The `StampedLock` class provides a flexible and efficient mechanism for controlling access to shared data. 
The write lock ensures exclusive access, the read lock allows concurrent reads, and the optimistic read lock provides a non-blocking way to read data with validation. 
By using these different lock modes, we can optimize performance and ensure data consistency in concurrent applications.

## Usage
To run the program, execute the `Main` class. 
The writer, reader, and optimistic reader threads will start, demonstrating the use of different lock modes provided by `StampedLock`.
## Notes
- The `StampedLock` class provides three lock modes: write, read, and optimistic read.
- The `StampedLock` class does not implement the `Lock` or `ReadWriteLock` interfaces.
- Proper use of `StampedLock` is crucial to prevent data corruption and ensure consistency in concurrent applications.
- For more information on thread synchronization, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.


