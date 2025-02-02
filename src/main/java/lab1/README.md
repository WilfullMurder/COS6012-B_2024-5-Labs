# Lab 1: Thread Management

## Introduction
In the realm of computing, concurrency refers to the simultaneous execution of independent tasks. 
This can be achieved either through multiple processors or multi-core processors (real concurrency) or through a single-core processor (apparent concurrency). 
Modern operating systems support concurrent task execution, allowing users to perform multiple activities, such as reading emails while listening to music.
Within a single process, multiple concurrent tasks are known as threads. 
Concurrency and parallelism are related concepts, with concurrency often referring to the execution of multiple threads on a single-core processor without a predefined order, 
and parallelism referring to the ordered execution of threads on multi-core processors or multiple processors.
This lab provides a series of recipes demonstrating basic thread operations using the Java 9 API. 
You will learn how to create and manage threads, control their execution, handle exceptions, and group threads for collective operations. 
For detailed information on specific concepts, refer to the README files in each recipe package.

## Recipe Packages

### Recipe 01: Creating, Running, and Setting the Characteristics of a Thread
This package demonstrates how to create, run, and set the characteristics of a thread.

### Recipe 02: Interrupting a Thread
This package shows how to interrupt a thread and handle the interruption.

### Recipe 03: Controlling the Interruption of a Thread
This package explains how to control the interruption of a thread and manage its state.

### Recipe 04: Sleeping and Resuming a Thread
This package illustrates how to make a thread sleep and resume its execution.

### Recipe 05: Waiting for the Finalization of a Thread
This package demonstrates how to wait for a thread to complete its execution.

### Recipe 06: Creating and Running a Daemon Thread
This package shows how to create and run a daemon thread, which runs in the background.

### Recipe 07: Processing Uncontrolled Exceptions in a Thread
This package explains how to process uncontrolled exceptions thrown by a thread.

### Recipe 08: Using Thread Local Variables
This package demonstrates the use of thread-local variables to maintain thread-specific data.

### Recipe 09: Grouping Threads and Processing Uncontrolled Exceptions in a Group of Threads
This package shows how to group threads and handle uncaught exceptions within a group.

### Recipe 10: Creating Threads Through a Factory
This package illustrates the use of the factory pattern to create threads with custom characteristics.