# Recipe 01: Synchronizing a method

## Overview
In concurrent programming, managing access to shared resources is essential to prevent data corruption and ensure consistency.
Java provides the `synchronized` keyword to control concurrent access to methods or blocks of code.
When a method is declared with the `synchronized` keyword, only one thread can execute it at a time, 
preventing race conditions and data inconsistencies.

This recipe demonstrates the use of the `synchronized` keyword to implement an application simulating a parking area. 
The application includes sensors that detect when a car or motorcycle enters or exits the parking area, 
an object to store vehicle statistics, and a mechanism to control cash flow. 
We will implement two versions: 
one without synchronization, which produces incorrect results, and one with synchronization, which works correctly.

## Files

- `Main.java` - The entry point of the application.
- `Sensor.java` - Simulates a sensor that detects vehicles entering or exiting the parking area.
- `ParkingCash.java` - Manages the cash flow of the parking area.
- `ParkingStats.java` - Stores statistics about the vehicles in the parking area.

## How it Works
1. **ParkingCash.java**:
    - Manages the cash flow of the parking area.
    - The `vehiclePay()` method is called when a vehicle exits the parking area and pays the fee.
    - The `close()` method is called to close the parking area and display the total cash earned.
2. **ParkingStats.java**:
    - Stores the number of cars and motorcycles.
    - Methods to increment and decrement the number of cars and motorcycles.
3. **Sensor.java**:
   - Simulates vehicle movements by calling methods in `ParkingStats`.
4. **Main.java**:
   - Sets up multiple sensors and starts them as threads.
   - Joins the threads and prints the final statistics.

## Why it Works
The `synchronized` keyword ensures that only one thread can execute a `synchronized` method or block at a time, using the object reference as a lock. 
This prevents race conditions and ensures data consistency.
In the un-synchronized version, the `ParkingCash` and `ParkingStats` classes do not use synchronization,
which can lead to incorrect statistics due to concurrent access to shared resources.
In the synchronized version, the `ParkingCash` and `ParkingStats` classes use synchronized methods and blocks to control access to shared resources, 
ensuring that the final statistics are correct.

## Usage
To run the program, execute the `Main` class in both the NotSynchronized and Synchronized packages. Compare the results to see the difference in data consistency and correctness.

## Notes
- The `synchronized` keyword can be used with methods or blocks of code.
- When synchronizing a block of code, an object reference must be provided as a lock.
- Proper synchronization is crucial to prevent data corruption and ensure consistency in concurrent applications.
- For more information on thread synchronization, refer to "Java Concurrency in Practice" by Brian Goetz and "Effective Java" by Joshua Bloch.