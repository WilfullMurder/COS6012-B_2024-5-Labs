# Recipe 04: Synchronizing data access with read/write locks

## Overview
One of the most significant improvements offered by locks in Java is the `ReadWriteLock` interface and its implementation, the `ReentrantReadWriteLock` class.
This class provides two separate locks:
one for read operations and one for write operations.
Multiple threads can hold the read lock simultaneously,
allowing concurrent read access, but only one thread can hold the write lock at a time, ensuring exclusive write access.
If a thread holds the write lock, no other threads can read or write.  
In this recipe, you will learn how to use the `ReadWriteLock` interface to control access to an object that stores the prices of two products.
You will see how to obtain and use the read and write locks provided by the `ReentrantReadWriteLock` class to ensure data consistency and prevent race conditions.

## Files

- `Main.java` - The entry point of the application.
- `Reader.java` - Simulates a reader that accesses the prices.
- `Writer.java` - Simulates a writer that updates the prices.
- `PricesInfo.java` - Stores the prices and manages access using read/write locks.

## How it Works
1. **PricesInfo.java:**
   - Manages the prices of two products.
   - Uses a `ReentrantReadWriteLock` to control access.
   - The `getPrice1()` and `getPrice2()` methods acquire the read lock to allow concurrent reads.
   - The `setPrices()` method acquires the write lock to ensure exclusive write access.
2. **Reader.java:**
   - Simulates a reader that repeatedly reads the prices by calling the `getPrice1()` and `getPrice2()` methods of PricesInfo.
3. **Writer.java:**
   - Simulates a writer that updates the prices by calling the `setPrices()` method of PricesInfo.
4. **Main.java:**
   - Sets up multiple reader threads and a single writer thread, demonstrating the use of read/write locks.
## Why it Works
The `ReadWriteLock` interface and its implementation, `ReentrantReadWriteLock`, provide a mechanism to separate read and write operations, allowing multiple threads to read data concurrently while ensuring exclusive access for write operations. 
This improves performance by allowing concurrent reads and ensures data consistency by preventing simultaneous writes or reads during a write operation.
## Usage
To run the program, execute the `Main` class. The reader and writer threads will start, demonstrating the correct handling of concurrent read and write operations using read/write locks.

## Notes
- The `ReadWriteLock` interface provides separate locks for read and write operations.
- The Reentrant`ReadWriteLock` class implements the `ReadWriteLock` interface.
- Proper use of read and write locks is crucial to prevent data corruption and ensure consistency in concurrent applications.
- For more information on thread synchronization, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.