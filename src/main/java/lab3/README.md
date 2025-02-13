# Lab 3: Advanced Thread Synchronization

## Introduction
In concurrent programming, managing access to shared resources is crucial to ensure data consistency and avoid errors.
In **Chapter 2: Basic Thread Synchronization**, we explored fundamental synchronization mechanisms such as the `synchronized` keyword,
the `Lock` interface, and the `StampedLock` class.
These tools help prevent race conditions and ensure that changes made by one thread are visible to others.
In this chapter, we will delve into high-level synchronization mechanisms provided by the Java language.
These mechanisms offer more sophisticated ways to control concurrent access, synchronize tasks, and manage data exchange between threads.
The following topics will be covered:
- **Semaphores:** Control access to one or more shared resources using a counter.
- **CountDownLatch:** Allow a thread to wait for the completion of multiple operations.
- **CyclicBarrier:** Synchronize multiple threads at a common point.
- **Phaser:** Manage the execution of concurrent tasks divided into phases.
- **Exchanger:** Provide a point of data interchange between two threads.
- **CompletableFuture:** Enable tasks to wait for the completion of another task asynchronously.

These high-level mechanisms are designed to address specific concurrency challenges and can be used to optimize performance and ensure data consistency in complex applications.

The following sections will present seven recipes demonstrating how to use these advanced synchronization mechanisms effectively.

## Recipes

1. [Recipe 01: Controlling Access to one or more copies of a resource](src/main/java/lab3/recipe01/README.md)
2. [Recipe 02: Waiting for multiple concurrent events](src/main/java/lab3/recipe02/README.md)
3. [Recipe 03: Synchronizing tasks in a common point](src/main/java/lab3/recipe03/README.md)
4. [Recipe 04: Running concurrent-phased tasks](src/main/java/lab3/recipe04/README.md)
5. [Recipe 05: Controlling phase change in concurrent-phased tasks](src/main/java/lab3/recipe05/README.md)
6. [Recipe 06: Exchanging data between concurrent tasks](src/main/java/lab3/recipe06/README.md)
7. [Recipe 07: Completing and linking tasks asynchronously](src/main/java/lab3/recipe07/README.md)