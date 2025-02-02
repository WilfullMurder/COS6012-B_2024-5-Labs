# Recipe 10: Creating Threads Through a Factory

## Overview
The factory pattern is a widely used design pattern in object-oriented programming. 
It is a creational pattern aimed at developing an object whose primary role is to create other objects of one or several classes. 
By using a factory, you can create objects without directly using the `new` operator.

This approach centralizes object creation, offering several advantages:
- It simplifies changing the class of the objects created or the way they are created.
- It allows limiting the creation of objects to manage limited resources, such as having only a certain number of objects of a given type.
- It facilitates generating statistical data about object creation.

Java provides the `ThreadFactory` interface to implement a thread object factory. Some advanced utilities in the Java concurrency API use thread factories to create threads.

## Files

- `MyThreadFactory.java` - Implements the `ThreadFactory` interface to create threads with custom names and track creation statistics.
- `Task.java` - A simple task that simulates work by sleeping for a second.
- `Main.java` - The entry point that sets up the thread factory and starts multiple threads.

## How it Works

1. **MyThreadFactory:**
    - Implements the `ThreadFactory` interface.
    - Overrides the `newThread` method to create threads with custom names and track their creation time and details.
    - Provides a method to retrieve the statistics of thread creation.

2. **Task:**
    - Implements the `Runnable` interface.
    - Simulates work by sleeping for one second.

3. **Main:**
    - Creates an instance of `MyThreadFactory`.
    - Creates and starts multiple threads using the factory.
    - Prints the statistics of thread creation.

## Why it Works
The `ThreadFactory` interface has a single method, `newThread()`, which takes a `Runnable` object as a parameter and returns a `Thread` object. 
When implementing the `ThreadFactory` interface, you must override the `newThread` method. 
A basic implementation might simply return a new `Thread` object.

However, this implementation can be enhanced in several ways:
- Creating personalized threads with custom names or even using a custom `Thread` class that extends the Java `Thread` class.
- Saving statistics about thread creation, as demonstrated in the example.
- Limiting the number of threads created.
- Validating thread creation.

Using the factory design pattern is a good programming practice. Implementing a `ThreadFactory` interface to centralize thread creation ensures consistency and allows for additional functionality, such as tracking and limiting thread creation.

## Usage
To run the program, execute the `Main` class. The program will create a thread factory, start multiple threads, and print the statistics of thread creation.

## Notes
- For more information on design patterns, refer to "Design Patterns: Elements of Reusable Object-Oriented Software" by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides (Gang of Four) and "Head First Design Patterns" by Eric Freeman and Elisabeth Robson.
- The `ThreadFactory` interface is part of the `java.util.concurrent` package, which provides a framework for managing threads and concurrency in Java.
- Using a custom `ThreadFactory` can help in scenarios where you need to apply specific configurations or policies to threads, such as setting thread priorities, daemon status, or handling uncaught exceptions.
- The factory pattern is not limited to thread creation; it can be applied to any object creation process where centralization and customization are beneficial.