# Example 2: Run Method Example

This example demonstrates the difference between calling the `run()` method and the `start()` method when working with threads in Java.

## Files

- `RunMethodExample.java`: Demonstrates the common pitfall of calling the `run()` method directly instead of the `start()` method.
- `RunMethodExample2.java`: Demonstrates the correct usage of the `start()` method to run threads concurrently.

## How It Works

1. **RunMethodExample.java**:
    - Implements the `Runnable` interface.
    - The `run()` method prints a message three times, with a one-second pause between each print.
    - In the `main()` method, two threads are created and the `run()` method is called directly. This does not start new threads but runs the `run()` method in the current thread.
    - **Explanation**: Calling the `run()` method directly is a common pitfall because it does not start a new thread. Instead, it executes the `run()` method in the current thread, which means the code runs sequentially rather than concurrently. This defeats the purpose of using threads for parallel execution.

2. **RunMethodExample2.java**:
    - Implements the `Runnable` interface.
    - The `run()` method prints a message three times, with a one-second pause between each print.
    - In the `main()` method, two threads are created and the `start()` method is called. This starts new threads and runs the `run()` method concurrently in separate threads.
    - **Explanation**: Calling the `start()` method on a `Thread` object actually creates a new thread and invokes the `run()` method in that new thread, allowing for concurrent execution. This is the correct way to utilize threads for parallel processing in Java.

## Usage

To run the examples, execute the `RunMethodExample` and `RunMethodExample2` classes. Observe the difference in output when using `run()` versus `start()`.