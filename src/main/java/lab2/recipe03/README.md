# Recipe 03: Synchronizing a block of code with a lock

## Overview
Java provides a more powerful and flexible mechanism for synchronizing blocks of code than the `synchronized` keyword. 
This mechanism is based on the `Lock` interface from the java.util.concurrent.locks package and its implementing classes, such as `ReentrantLock`. 
The `Lock` interface allows for more complex structures to implement critical sections and provides additional functionalities, 
such as the `tryLock()` method, which attempts to acquire the lock without blocking if it is already held by another thread. 
Additionally, the ReadWriteLock interface separates read and write operations, allowing multiple readers but only one writer. 
The `Lock` interface generally offers better performance than the `synchronized` keyword.  
The `ReentrantLock` class constructor accepts a boolean parameter named `fair`, which controls its behavior. 
In non-fair mode (default), the lock randomly selects a waiting thread to access the critical section. 
In fair mode, the lock selects the thread that has been waiting the longest. 
This behavior applies to the `lock()` and unlock() methods but not to the `tryLock()` method.  
In this recipe, you will learn how to use locks to synchronize a block of code and create a critical section using the `Lock` interface and the `ReentrantLock` class. 
You will also see how the `fair` parameter affects the behavior of the lock.

## Files

- `Main.java` - The entry point of the application.
- `Job.java` - Simulates a job that sends a document to the print queue.
- `PrintQueue.java` - Manages the print queue and controls access to it using locks.

## How it Works
1. **PrintQueue.java**:
   - Manages the print queue using a `ReentrantLock`.
   - The printJob() method simulates printing a document, acquiring and releasing the lock twice to demonstrate lock usage.
2. **Job.java**:
   - Simulates a job that sends a document to the print queue by calling the printJob() method of PrintQueue.
3. **Main.java**:
   - Sets up multiple job threads and starts them, demonstrating the use of locks in both fair and non-fair modes.
## Why it Works
The `Lock` interface and its implementing classes, such as `ReentrantLock`, provide a more flexible and powerful mechanism for synchronizing blocks of code compared to the `synchronized` keyword. 
The `lock()` and unlock() methods control access to critical sections, while the `tryLock()` method allows non-blocking attempts to acquire the lock. 
The `fair` parameter in `ReentrantLock` ensures that threads are granted access in the order they requested it, preventing starvation.
## Usage
To run the program, execute the `Main` class. 
The job threads will start, demonstrating the correct handling of the print queue using locks in both fair and non-fair modes.
## Notes
- The `Lock` interface can be used to synchronize blocks of code.
- The `tryLock()` method allows non-blocking attempts to acquire the lock.
- The `fair` parameter in `ReentrantLock` controls the order in which threads are granted access to the critical section.
- Proper use of locks is crucial to prevent data corruption and ensure consistency in concurrent applications.
- For more information on thread synchronization, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.