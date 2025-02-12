# Recipe 02: Using conditions in synchronized code

## Overview
In concurrent programming, the producer-consumer problem is a classic scenario where a data buffer is shared between one or more producers that add data to the buffer and one or more consumers that remove data from the buffer. 
Since the buffer is a shared resource, access to it must be synchronized to prevent data corruption and ensure consistency. 
Producers must wait if the buffer is full, and consumers must wait if the buffer is empty.  
Java provides the `wait()`, `notify()`, and `notifyAll()` methods in the Object class to handle these synchronization requirements. These methods must be called within a synchronized block of code. The `wait()` method puts the thread to sleep and releases the lock on the object, allowing other threads to execute synchronized blocks protected by the same object. The `notify()` and `notifyAll()` methods wake up waiting threads.  
In this recipe, you will learn how to implement the producer-consumer problem using the synchronized keyword along with the `wait()`, `notify()`, and `notifyAll()` methods.
## Files

- `Main.java` -  - The entry point of the application.
- `Producer.java` - Simulates a producer that generates data and stores it in the buffer. 
- `Consumer.java` - Simulates a consumer that retrieves data from the buffer. 
- `EventStorage.java` - Manages the buffer and controls access to it using synchronization.

## How it Works
1. **EventStorage.java**:
   - Manages the buffer with a maximum size.
   - The `set()` method adds data to the buffer if it is not full, otherwise, it waits.
   - The `get()` method retrieves data from the buffer if it is not empty, otherwise, it waits.
2. **Producer.java**:
   - Simulates a producer that generates data and calls the `set()` method of EventStorage.
3. **Consumer.java**:
   - Simulates a consumer that retrieves data by calling the `get()` method of EventStorage.
4. **Main.java**:
   - Sets up the producer and consumer threads and starts them.
## Why it Works
The `synchronized` keyword ensures that only one thread can execute a synchronized method or block at a time, using the object reference as a lock. 
The `wait()` and `notify()` methods manage the conditions for accessing the buffer, ensuring that producers wait when the buffer is full and consumers wait when the buffer is empty. 
This prevents race conditions and ensures data consistency.
## Usage
To run the program, execute the `Main` class. The producer and consumer threads will start, demonstrating the correct handling of the producer-consumer problem using synchronization and condition management.
## Notes
- The `synchronized` keyword can be used with methods or blocks of code.
- The `wait()`, `notify()`, and `notifyAll()` methods must be called within synchronized blocks.
- Proper synchronization and condition management are crucial to prevent data corruption and ensure consistency in concurrent applications.
- For more information on thread synchronization, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.

