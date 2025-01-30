# Creating threads through a factory

## Overview
The factory pattern is one of the most used design patterns in the object-oriented
programming world. It is a creational pattern, and its objective is to develop an object
whose mission should be this: creating other objects of one or several classes. With this, if
you want to create an object of one of these classes, you could just use the factory instead of
using a new operator.

With this factory, we centralize the creation of objects with some advantages:
It's easy to change the class of the objects created or the way you'd create them.
It's easy to limit the creation of objects for limited resources; for example, we can
only have n objects of a given type.

It's easy to generate statistical data about the creation of objects.
Java provides an interface, the ThreadFactory interface, to implement a thread object
factory. Some advanced utilities of the Java concurrency API use thread factories to create
threads

## Files

- `MyThreadFactory.java` -
- `Task.java` -
- `Main.java` -

## How it Works

1. **MyThreadFactory:**
2. **Task:**
3. **Main:**

## Why it Works

he ThreadFactory interface has only one method, called newThread(). It receives a
Runnable object as a parameter and returns a Thread object. When you implement a
ThreadFactory interface, you have to implement it and override the newThread method.
The most basic ThreadFactory has only one line:
return new Thread(r);

You can improve this implementation by adding some variants, as follows:
Creating personalized threads, as in the example, using a special format for the
name or even creating your own Thread class that would inherit the Java Thread
class
Saving thread creation statistics, as shown in the previous example
Limiting the number of threads created
Validating the creation of the threads
You can add anything else you can imagine to the preceding list. The use of the factory
design pattern is a good programming practice, but if you implement a ThreadFactory
interface to centralize the creation of threads, you will have to review the code to guarantee
that all the threads are created using the same factory.

## Usage

## Notes