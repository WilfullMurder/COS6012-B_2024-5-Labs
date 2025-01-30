# Grouping threads and processing uncontrolled exceptions in a group of threads

## Overview
An interesting functionality offered by the concurrency API of Java is the ability to group
threads. This allows us to treat the threads of a group as a single unit and provide access to
the thread objects that belong to a group in order to do an operation with them. For
example, you have some threads doing the same task and you want to control them. You
can, for example, interrupt all the threads of the group with a single call.
Java provides the ThreadGroup class to work with a groups of threads. A ThreadGroup
object can be formed by thread objects and another ThreadGroup object, generating a tree
structure of threads.
In the Controlling the interruption of a thread recipe, you learned how to use a generic method
to process all the uncaught exceptions that are thrown in a thread object. In the Processing
uncontrolled exceptions in a thread recipe, we wrote a handler to process the uncaught
exceptions thrown by a thread. We can use a similar mechanism to process the uncaught
exceptions thrown by a thread or a group of threads.

## Files

- `MyThreadGroup.java` - Stores thread objects and other ThreadGroup objects associated
   with it so it can access all of their information (status, for example) and perform operations
   over all its members (interrupt, for example).
- `Task.java` -
- `Main.java` - 

## How it Works
1. **MyThreadGroup:**
2. **Task:**
3. **Main:**

## Why it Works
When an uncaught exception is thrown in a Thread object, the JVM looks for three possible
handlers for this exception.
First, it looks for the uncaught exception handler of the thread, as explained in the
Processing uncontrolled exceptions in a thread recipe. If this handler doesn't exist, then the JVM
looks for the uncaught exception handler of the ThreadGroup class of the thread, as learned
in this recipe. If this method doesn't exist, the JVM looks for the default uncaught exception
handler, as explained in the Processing uncontrolled exceptions in a thread recipe.
If none of the handlers exists, the JVM writes the stack trace of the exception in the console
and ends the execution of the thread that had thrown the exception.
## Usage

## Notes