# SinglyLinkedList Project

## Overview

The `SinglyLinkedList` class is a custom implementation of a singly linked list that stores Integer elements. It extends the standard `LinkedList<Integer>` from Java's Collections Framework but is tailored for operations optimized specifically for singly linked lists.

This subclass is ideal for educational purposes, to understand the inner workings of linked lists, or in scenarios where specific behaviors are needed that go beyond the default capabilities of Java's `LinkedList` class.

## Features

- **Single Direction Nodes**: Each node points to its right-most neighbor, with the last element pointing to `null`.
- **Customized Methods**: Includes methods for optimized traversal, reversing the list, sorting, and checking if the list is palindromic.
- **Exception Handling**: Robust handling of edge cases such as operations on empty lists.

## Example Usage

Here's how you can use the `SinglyLinkedList` in a simple Java application:

```java
public class Main {
    public static void main(String[] arg) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1); // Adds 1 to the end of the list
        list.add(3); // Adds 3 to the end of the list
        list.add(1, 2); // Adds 2 at index 1
        list.add(4); // Adds 4 to the end of the list

        list.print(); // Print list
        list.reverse(); // Reverse the list
        list.print(); // Print reversed list

        SinglyLinkedList listClone = list.sort(); // Sort and clone the list
        listClone.print(); // Print sorted list
    }
}
```

## Methods

### Overview of Methods
Below is a detailed description of the methods provided by the `SinglyLinkedList` class:

### Adding Elements
- **`add(int n)`**: Adds an element to the end of the list.
- **`add(int index, int element)`**: Inserts an element at the specified position within the list. Validates that the index is within the current bounds.
- **`addFirst(int element)`**: Inserts an element at the beginning of the list, equivalent to `add(0, element)`.
- **`addLast(int element)`**: Appends an element to the end of the list, functionally identical to `add(int n)`.

### Removing Elements
- **`removeFirst()`**: Removes and returns the first element of the list. If the list is empty, throws an `IllegalStateException`.
- **`removeLast()`**: Removes and returns the last element of the list. Also throws an `IllegalStateException` if the list is empty.

### Peeking Elements
- **`peek()`, `peekFirst()`**: Retrieves but does not remove the first element of the list. Returns `null` if the list is empty.
- **`peekLast()`**: Retrieves but does not remove the last element of the list. Also returns `null` if the list is empty.

### List Manipulation
- **`reverse()`**: Reverses the order of the elements in the list. Throws an `IllegalStateException` if the list is empty.
- **`sort()`**: Sorts the elements of the list and returns a new instance of the sorted list. If the list is empty, throws an `IllegalStateException`.

### Utility Methods
- **`isPalindrome()`**: Checks if the list's sequence of elements is symmetric, meaning identical forwards and backwards. Returns `true` if the list is a palindrome, otherwise `false`.
- **`print()`**: Prints the elements of the list in a readable format, each element followed by an arrow pointing to the next, ending with `null`.

### Customization

The `SinglyLinkedList` can be further customized to offer more efficient operations specific to singly linked list structures, such as granular control over node manipulation or operations that take advantage of the inherent properties of singly linked lists. This customization makes it suitable for specific applications where typical array-based lists might not be as efficient.

