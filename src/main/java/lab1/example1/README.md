# Example 1: Math Expression Calculation Using Threads

This example was written by Dr. D. Scrimieri and demonstrates the use of threads in Java to perform concurrent calculations of a mathematical expression. The program calculates the value of the expression `2 * K * a * t * e^(-a * t^2)` using two separate threads.

## Files

- `MathExpression.java`: The main class that initiates the threads and calculates the final value of the expression.
- `Thread1.java`: A thread class that calculates the value of `2 * K * a * t`.
- `Thread2.java`: A thread class that calculates the value of `e^(-a * t^2)`.

## How It Works

1. **MathExpression.java**:
    - Initializes the variables `K`, `a`, and `t`.
    - Creates instances of `Thread1` and `Thread2` with the given parameters.
    - Starts both threads.
    - Waits for both threads to complete using the `join()` method.
    - Multiplies the results from both threads and prints the final value of the expression.

2. **Thread1.java**:
    - Extends the `Thread` class.
    - Calculates the value of `2 * K * a * t` in the `run()` method.
    - Provides a method `getValue()` to retrieve the calculated value.

3. **Thread2.java**:
    - Extends the `Thread` class.
    - Calculates the value of `e^(-a * t^2)` in the `run()` method.
    - Provides a method `getValue()` to retrieve the calculated value.

## Usage

To run the program, execute the `MathExpression` class. The program will output the value of the mathematical expression after both threads have completed their calculations.
