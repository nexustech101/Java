package lib.models;

import java.util.concurrent.locks.ReentrantLock;

import lib.errors.EmptyDequeException;
import lib.errors.NullElementDequeException;

// Dequeue/lib/models/Dequeue.java

/**
 * The Dequeue class implements a double-ended queue (Deque) using a doubly
 * linked dequeue paradigm, allowing efficient insertion and removal of elements
 * from both ends (front and rear).
 * 
 * This class is designed to be thread-safe in multi-threaded environments by
 * using a ReentrantLock to synchronize access to the internal data structure.
 * The lock ensures that only one thread can modify the Dequeue at a time.
 *
 * @param <E>  The type of elements held in the Dequeue
 * @param head The head node represents the first element in the dequeue
 * @param tail The tail node represents the last element in the dequeue
 */
public class Dequeue<E> {
    private final ReentrantLock lock = new ReentrantLock(); // Thread lock for thread-safety
    private Node<E> head; // The head node of the dequeue, representing the first element
    private Node<E> tail; // The tail node of the dequeue, representing the last element
    private int size; // The size of the dequeue (number of elements)

    /**
     * Default constructor that initializes an empty dequeue.
     */
    public Dequeue() {
        this.head = null; // No elements in the dequeue
        this.tail = null; // No elements in the dequeue
        this.size = 0; // Size is 0 initially
    }

    /**
     * The Node class represents an individual element in the dequeue.
     * Each node stores data and a reference to the next node. 
     * 
     * This Node keeps track of a next pointer and a prev pointer for
     * efficient insertion, deletion, and traversal. These operations
     * are O(1) (constant time) due to the doubly linked dequeue structure
     * 
     * @param <E>  Generic data type for the node
     * @param data Data to be stored in the node
     * @param next Reference to the next node in the dequeue
     * @param prev Reference to the next node in the dequeue
     */
    private static class Node<E> {
        private E data; // Data stored in the node
        private Node<E> next; // Reference to the next node in the dequeue
        private Node<E> prev; // Reference to the prev node in the dequeue

        /**
         * Constructor to initialize a node with data and no next or prev references.
         * 
         * @param data The data to store in the node
         */
        public Node(E data) {
            this.data = data;
            this.next = null; // No next node initially
            this.prev = null; // No prev node initially
        }
    }

    /**
     * Adds an element to the beginning (head) of the dequeue.
     * 
     * @param a The element to be added to the dequeue
     */
    public void addFirst(E a) {
        lock.lock();
        try {
            if (a == null) {
                throw new NullElementDequeException("Cannot add null type to the dequeue.");
            }
            Node<E> newNode = new Node<>(a); // Create a new node with the provided data
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head; // The new node points to the current head
                head.prev = newNode;
                head = newNode; // The head is now the new node
            }
            size++; // Increment the size of the dequeue
        } finally {
            lock.unlock();
        }
    }

    /**
     * Adds an element to the end (tail) of the dequeue.
     * 
     * @param a The element to be added to the dequeue
     */
    public void addLast(E a) {
        lock.lock();
        try {
            if (a == null) {
                throw new NullElementDequeException("Cannot add null type to the dequeue.");
            }
            Node<E> newNode = new Node<>(a); // Create a new node with the provided data
            if (head == null) { // If the dequeue is empty
                head = tail = newNode; // The new node becomes the head of the dequeue
            } else {
                tail.next = newNode; // The current tail's next points to the new node
                newNode.prev = tail; // The new node's prev points to the current tail
                tail = newNode; // The tail is now the new node
            }
            size++; // Increment the size of the dequeue
        } finally {
            lock.unlock();
        }
    }

    /**
     * Removes and returns the first element from the dequeue.
     * 
     * @return The removed element from the beginning of the dequeue
     * @throws EmptyDequeException if the dequeue is empty
     */
    public E popFirst() {
        lock.lock();
        try {
            if (head == null) {
                throw new EmptyDequeException("Cannot remove from an empty dequeue.");
            }
            E value = head.data; // Get the data from the head node
            if (head.next == null) {
                head = tail = null; // If there is only one element, set head and tail to null
            } else {
                head = head.next; // Move the head to the next node
                head.prev = null; // The new head's prev should be null
            }
            size--; // Decrement the size of the dequeue
            return value;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Removes and returns the last element from the dequeue.
     * 
     * @return The removed element
     * @throws EmptyDequeException if the dequeue is empty
     */
    public E popLast() {
        lock.lock();
        try {
            if (head == null) {
                throw new EmptyDequeException("Cannot remove from an empty dequeue.");
            }
            E value = tail.data; // Get the data from the tail node
            if (tail.prev == null) { // If there is only one element in the dequeue
                head = tail = null; // Set head and tail to null
            } else {
                tail = tail.prev; // Move the tail to the previous node
                tail.next = null; // The new tail's next should be null
            }
            size--; // Decrement the size of the dequeue
            return value;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Checks if the dequeue is symmetrical (palindromic).
     * A dequeue is symmetrical if it reads the same forward and backward.
     * 
     * @return true if the dequeue is symmetrical, false otherwise
     */
    public boolean isSymmetrical() {
        lock.lock();
        try {
            if (head == null || head.next == null || head == tail) {
                return true; // An empty or single-element dequeue is symmetrical
            }

            // Set up two pointers: one at the head, one at the tail
            Node<E> left = head;
            Node<E> right = tail;

            while (left != null && right != null) {
                // Compare the data of the nodes from both ends
                if (!left.data.equals(right.data)) {
                    return false; // Elements do not match, not symmetrical
                }
                left = left.next; // Move the left pointer forward
                right = right.prev; // Move the right pointer backward
            }
            return true; // All elements matched, dequeue is symmetrical
        } finally {
            lock.unlock();
        }
    }

    /**
     * Prints all elements in the dequeue from front (head) to back (tail).
     * It traverses the linked list starting from the head node and prints
     * the data of each node until it reaches the tail.
     */
    public void printDequeue() {
        lock.lock();
        try {
            if (head == null) {
                System.out.println("Dequeue is empty.");
                return;
            }

            // Start from the head node and traverse to the tail
            Node<E> current = head;
            while (current != null) {
                System.out.print(current.data + " "); // Print each element
                current = current.next; // Move to the next node
            }
            System.out.println(); // Print a new line after all elements
        } finally {
            lock.unlock();
        }
    }

    /**
     * Gets the current size of the dequeue.
     * 
     * @return The number of elements in the dequeue
     */
    public int size() {
        lock.lock();
        try {
            return this.size; // Return the size of the dequeue
        } finally {
            lock.unlock();
        }
    }

    /**
     * Checks if the dequeue is empty.
     * 
     * @return true if the dequeue is empty, false otherwise
     */
    public boolean isEmpty() {
        try {
            return size == 0; // Dequeue is empty if size is 0
        } finally {
            lock.unlock();
        }
    }
    
}
