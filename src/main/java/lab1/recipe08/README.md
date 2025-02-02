# Recipe 08: Using Thread Local Variables

## Overview
In concurrent applications, managing shared data is crucial, especially when dealing with objects that extend the `Thread` class or implement the `Runnable` interface.
When multiple threads share the same `Runnable` object, they also share its attributes, leading to potential data corruption and unpredictable behavior. 
To address this, Java provides thread-local variables, which ensure that each thread has its own independent instance of a variable. 
This approach improves performance and avoids synchronization issues, although it has drawbacks, such as retaining values for the lifetime of the thread, which can be problematic when threads are reused. 
This recipe demonstrates the use of thread-local variables to solve shared data issues.

## Files
- `Main.java` – The entry point that demonstrates the difference between an **unsafe shared variable** and a **thread-local variable**.
- `UnsafeTask.java` – A task where multiple threads share the same variable, leading to inconsistent results.
- `SafeTask.java` – A task using **ThreadLocal** to ensure each thread has its own copy of the variable, preventing data corruption.

## How it Works

The program runs two different tasks:

1. **UnsafeTask** (Incorrect approach)
    - All threads share the same instance of a variable.
    - Due to concurrency, different threads modify the variable, leading to **unexpected results**.

2. **SafeTask** (Correct approach)
    - Uses **ThreadLocal** to provide each thread with its own copy of a variable.
    - Prevents shared-state corruption, ensuring **thread safety**.

### Key Methods in ThreadLocal
- **Setting a value**: `threadLocal.set(value);`
- **Getting a value**: `threadLocal.get();`
- **Removing a value**: `threadLocal.remove();`

## Why it Works

### **UnsafeTask (Incorrect)**
When multiple threads use the same `Runnable` instance, they share instance variables. Since threads execute independently, they may modify the variable unpredictably, leading to **race conditions**.

### **SafeTask (Correct with ThreadLocal)**
With **ThreadLocal**, each thread gets its own independent copy of the variable, ensuring:
- **Thread safety**: No synchronization is needed as each thread operates on its own instance.
- **Better performance**: Avoids contention between threads.
- **Encapsulation**: Keeps thread-specific data isolated.

Additionally, the **InheritableThreadLocal** class allows child threads to inherit values from their parent thread. This can be overridden using the `childValue()` method.

## Usage

To run the program, execute the `Main` class. The program first runs the `UnsafeTask`, where multiple threads share the same variable, leading to inconsistent results. After that, it runs the `SafeTask`, which uses `ThreadLocal` to ensure each thread has its own independent copy of the variable.

The output will demonstrate the difference between the two approaches, highlighting how `ThreadLocal` provides thread safety.  

## Notes

- The `ThreadLocal` class provides methods such as `set()`, `get()`, and `remove()` to manage thread-local variables.
- Proper use of thread-local variables can significantly improve the performance and reliability of concurrent applications.
- For more information on thread management and synchronization, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.