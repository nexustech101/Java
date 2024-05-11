# LinkedStack<T> Documentation

## Overview

The `LinkedStack<T>` class is a generic Java implementation of a stack data structure using a singly linked list. It supports the Last In, First Out (LIFO) principle, which is critical for stack operations. This implementation is thread-safe, making it suitable for use in multi-threaded environments where multiple threads might access the stack concurrently.

This class is ideal for educational purposes, to understand the inner workings of stack operations, or in scenarios where specific thread-safe behaviors are needed that go beyond the capabilities of non-synchronized collections.

## Features

- **Generic Implementation**: Can store elements of any type `T`, providing flexibility across different data types.
- **Thread Safety**: All public methods are synchronized to prevent concurrent modification issues.
- **Fundamental Stack Operations**: Includes essential methods such as `push`, `pop`, `peek`, alongside methods to check the stack's size and its empty status.

## Example Usage

Here's how you can use the `LinkedStack<T>` in a simple Java application:

```java
public class Main {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(10); // Pushes 10 to the top of the stack
        stack.push(20); // Pushes 20 to the top of the stack
        System.out.println("Peek: " + stack.peek()); // Outputs: Peek: 20
        System.out.println("Pop: " + stack.pop()); // Outputs: Pop: 20
        System.out.println("Is Empty: " + stack.isEmpty()); // Outputs: Is Empty: false
        System.out.println("Size: " + stack.size()); // Outputs: Size: 1
    }
}
```

# Methods

## Overview of Methods

Below is a detailed description of the methods provided by the `LinkedStack<T>` class:

### Stack Operations

- **`push(T element)`**: Adds an element to the top of the stack.
- **`pop()`**: Removes and returns the top element of the stack. Throws `EmptyStackException` if the stack is empty.
- **`peek()`**: Returns the top element without removing it from the stack. Throws `EmptyStackException` if the stack is empty.
- **`size()`**: Returns the number of elements in the stack.
- **`isEmpty()`**: Checks if the stack is empty.

## Thread Safety

The entire class is designed to be thread-safe. This is achieved by synchronizing each method to ensure that only one thread at a time can modify the state of the stack. While this provides safety against concurrent access, it may introduce performance bottlenecks under high load, which should be considered when using this stack in performance-critical applications.

## Customization

The `LinkedStack<T>` can be further customized to handle different types of data more efficiently or to integrate with other data handling mechanisms seamlessly. This flexibility allows it to be used in a variety of applications where typical non-generic or non-thread-safe stacks might not be adequate.

This Markdown documentation now includes a comprehensive overview, detailed method descriptions, example usage, and notes on thread safety and customization, making it highly informative and useful for users of the `LinkedStack<T>` class.
