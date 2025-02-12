# Recipe 05: Using multiple conditions in a lock

## Overview
In concurrent programming, a lock can be associated with one or more conditions, declared in the `Condition` interface. 
These conditions allow threads to control a lock and check whether a condition is true. 
If the condition is false, the thread is suspended until another thread wakes it up. 
The `Condition` interface provides mechanisms to suspend a thread and wake up a suspended thread.  
A classic problem in concurrent programming is the producer-consumer problem, where a data buffer is shared between producers that add data to the buffer and consumers that remove data from the buffer. 
In this recipe, you will learn how to implement the producer-consumer problem using locks and conditions.
## Files

- `Main.java` - The entry point of the application.
- `Producer.java` - Simulates a producer that generates data and stores it in the buffer.
- `Consumer.java` - Simulates a consumer that retrieves data from the buffer.
- `Buffer.java` - Manages the buffer and controls access to it using locks and conditions.
- `FileMock.java` - Simulates a file with lines of text to be processed.

## How it Works
1. **Buffer.java:**
   - Manages a buffer with a maximum size.
   - Uses a `ReentrantLock` to control access.
   - Uses two `Condition` objects: one for lines and one for space.
   - The `insert()` method adds data to the buffer if there is space, otherwise, it waits.
   - The `get()` method retrieves data from the buffer if it is not empty, otherwise, it waits.
2. **Producer.java:**
   - Simulates a producer that generates data and calls the insert() method of Buffer.
3. **Consumer.java:**
   - Simulates a consumer that retrieves data by calling the get() method of Buffer.
4. **FileMock.java:**
   - Simulates a file with lines of text to be processed.
5**Main.java:**
    - Sets up the producer and consumer threads and starts them.
## Why it Works
The `Condition` interface allows threads to wait for specific conditions to be met before proceeding.
By using multiple conditions, we can manage the producer-consumer problem more efficiently. 
The `await()` method suspends the thread until the condition is met, and the `signal()` or `signalAll()` methods wake up waiting threads. 
This ensures that producers wait when the buffer is full and consumers wait when the buffer is empty, preventing race conditions and ensuring data consistency.

## Usage
To run the program, execute the `Main` class. 
The producer and consumer threads will start, demonstrating the correct handling of the producer-consumer problem using locks and conditions.
## Notes
- The `Condition` interface provides mechanisms to suspend and wake up threads.
- The `await()` method must be called within a lock, and the lock must be held by the thread.
- Proper use of conditions is crucial to prevent data corruption and ensure consistency in concurrent applications.
- For more information on thread synchronization, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.