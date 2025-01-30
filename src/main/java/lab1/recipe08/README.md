# Using Thread-Local Variables

## Overview

Handling shared data correctly is one of the biggest challenges in concurrent programming. When multiple threads operate on the same object, changes made by one thread can unexpectedly affect others, leading to unpredictable behavior.

In some cases, it's necessary for each thread to maintain its own separate copy of a variable. Java provides a solution for this through **thread-local variables**, which ensure that each thread has an independent instance of a variable rather than sharing it with others. While this approach improves performance and avoids synchronization issues, it also has drawbacks—such as the persistence of values for as long as the thread exists, which can lead to problems when threads are reused.

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

