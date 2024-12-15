# Dequeue (Double-Ended Queue)

## Overview

The `Dequeue` class implements a double-ended queue (Deque), allowing efficient insertion and removal of elements from both ends (front and rear) using a doubly linked list. This data structure supports the following operations:

- Add elements to the front and back of the dequeue.
- Remove elements from the front and back.
- Check if the dequeue is empty or symmetrical.
- Get the current size of the dequeue.

This class is designed to be thread-safe and ensures that only one thread can modify the data structure at a time using `ReentrantLock`. Additionally, custom error handling is implemented to prevent invalid operations, such as attempting to add `null` elements or remove elements from an empty dequeue.

## Features

- **Efficient Operations**: Insertions and deletions at both ends are performed in constant time (O(1)) due to the doubly linked list structure.
- **Thread Safety**: The class uses a `ReentrantLock` to ensure thread-safe operations in multi-threaded environments.
- **Custom Error Handling**: Includes custom exceptions to handle cases like attempting to add `null` elements or remove from an empty dequeue.

## Key Operations

### 1. `addFirst(E element)`
Adds an element to the front of the dequeue.

#### Parameters:
- `E element`: The element to be added to the dequeue.

#### Throws:
- `NullElementDequeException`: If the provided element is `null`.

### 2. `addLast(E element)`
Adds an element to the back of the dequeue.

#### Parameters:
- `E element`: The element to be added to the dequeue.

#### Throws:
- `NullElementDequeException`: If the provided element is `null`.

### 3. `popFirst()`
Removes and returns the element at the front of the dequeue.

#### Returns:
- `E`: The element removed from the front of the dequeue.

#### Throws:
- `EmptyDequeException`: If the dequeue is empty.

### 4. `popLast()`
Removes and returns the element at the back of the dequeue.

#### Returns:
- `E`: The element removed from the back of the dequeue.

#### Throws:
- `EmptyDequeException`: If the dequeue is empty.

### 5. `isSymmetrical()`
Checks if the dequeue is symmetrical (palindromic). A dequeue is symmetrical if it reads the same forward and backward.

#### Returns:
- `boolean`: `true` if the dequeue is symmetrical, `false` otherwise.

### 6. `size()`
Returns the number of elements currently in the dequeue.

#### Returns:
- `int`: The size of the dequeue.

### 7. `isEmpty()`
Checks if the dequeue is empty.

#### Returns:
- `boolean`: `true` if the dequeue is empty, `false` otherwise.

### 8. `printDequeue()`
Prints all elements in the dequeue from front to back. It traverses the doubly linked list from the head to the tail, printing the data of each node.

#### Returns:
- `void`

## Thread Safety

The `Dequeue` class uses a `ReentrantLock` to synchronize access to the data structure. This ensures that only one thread can modify the dequeue at a time, making it safe for use in multi-threaded environments.

### Example Usage

```java
import lib.models.Dequeue;
import lib.errors.EmptyDequeException;
import lib.errors.NullElementDequeException;

public class Main {
    public static void main(String[] args) {
        // Create a new Dequeue
        Dequeue<Integer> dequeue = new Dequeue<>();

        // Add elements to the front and back
        dequeue.addFirst(1);
        dequeue.addLast(2);
        dequeue.addFirst(0);

        // Print the current dequeue
        dequeue.printDequeue(); // Output: 0 1 2

        // Remove elements from the front and back
        System.out.println(dequeue.popFirst()); // Output: 0
        System.out.println(dequeue.popLast());  // Output: 2

        // Check if the dequeue is empty
        System.out.println(dequeue.isEmpty()); // Output: false

        // Add more elements and check if it's symmetrical
        dequeue.addFirst(1);
        dequeue.addLast(1);
        System.out.println(dequeue.isSymmetrical()); // Output: true

        // Get the size of the dequeue
        System.out.println(dequeue.size()); // Output: 2
    }
}
```

## Error Handling

The class defines two custom exceptions to handle specific error scenarios:

- **`NullElementDequeException`**: Thrown when attempting to add a `null` element to the dequeue.
- **`EmptyDequeException`**: Thrown when attempting to remove an element from an empty dequeue.

## Implementation Details

### Doubly Linked List
The `Dequeue` class uses a doubly linked list where each node points to both the previous and the next node, allowing efficient insertions and deletions from both ends of the dequeue.

Each node contains the following:

- `data`: The element stored in the node.
- `next`: A reference to the next node in the dequeue.
- `prev`: A reference to the previous node in the dequeue.

### `ReentrantLock`
A `ReentrantLock` is used to ensure that only one thread can perform operations on the `Dequeue` at a time, providing thread safety. This is particularly useful in multi-threaded environments where multiple threads may try to modify the dequeue concurrently.

## Conclusion

The `Dequeue` class provides a flexible, efficient, and thread-safe implementation of a double-ended queue. With constant-time insertions and deletions at both ends, it is well-suited for applications requiring dynamic data storage where elements need to be accessed from both ends frequently.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
