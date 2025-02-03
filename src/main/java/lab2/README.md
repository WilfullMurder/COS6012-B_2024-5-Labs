# Lab 2: Basic Thread Synchronization

## Introduction
In concurrent programming, multiple threads often share resources such as data structures, files, or database connections.
This can lead to race conditions, where the final result depends on the order of thread execution, often resulting in errors or data inconsistencies.
Another issue is change visibility, where changes made by one thread to a shared variable may not be visible to other threads.
These issues arise because threads may read or write shared resources simultaneously, leading to unpredictable outcomes.

To address these issues, the concept of a **critical section** is used.
A critical section is a block of code that accesses a shared resource and cannot be executed by more than one thread at a time.
By ensuring that only one thread can execute the critical section at a time, we can prevent race conditions and ensure that changes made by one thread are visible to others.

Java provides synchronization mechanisms to help implement critical sections.
When a thread wants to access a critical section, it uses one of these synchronization mechanisms to check if any other thread is currently executing the critical section. If not, the thread enters the critical section. If another thread is executing the critical section, the thread is suspended until the critical section becomes available. Once the critical section is free, one of the waiting threads is allowed to enter, ensuring orderly access to shared resources.

This lab presents a number of recipes that demonstrate how to use the two basic synchronization mechanisms offered by the Java language:
- The `synchronized` keyword: Ensures that only one thread can execute a block of code or method at a time.
- The `Lock` interface and its implementations: Provides more flexible and sophisticated synchronization capabilities compared to the `synchronized` keyword.

By using these mechanisms, you can prevent race conditions and ensure that changes made by one thread are visible to others, maintaining data consistency and correctness in concurrent applications.


## Recipe Packages

### Recipe 01: Synchronizing a method
### Recipe 02: Using conditions in synchronized code
### Recipe 03: Synchronizing a block of code with a lock
### Recipe 04: Synchronizing data access with read/write locks