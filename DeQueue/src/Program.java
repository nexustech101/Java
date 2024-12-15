package src;

import lib.models.*;

/**
 * A simple program to test the Dequeue class implementation.
 */
public class Program {

    public static void main(String[] args) {
        // Creating a Dequeue of integers
        Dequeue<Integer> dequeue = new Dequeue<>();

        // Testing adding elements to both ends
        System.out.println("Adding elements to the Dequeue...");
        dequeue.addFirst(10);  // Adds 10 to the front
        dequeue.addLast(20);   // Adds 20 to the end
        dequeue.addFirst(5);   // Adds 5 to the front
        dequeue.addLast(30);   // Adds 30 to the end

        // Print Dequeue state
        System.out.print("Dequeue state after adding elements: ");
        dequeue.printDequeue();  // Expected: [5, 10, 20, 30]

        // Testing removing elements from both ends
        System.out.println("\nRemoving elements from the Dequeue...");
        System.out.println("Removed from front: " + dequeue.popFirst());  // Should remove 5
        System.out.println("Removed from end: " + dequeue.popLast());   // Should remove 30

        // Print Dequeue state after removals
        System.out.print("Dequeue state after removals: ");
        dequeue.printDequeue();  // Expected: [10, 20]

        // Testing size and isEmpty
        System.out.println("\nSize of Dequeue: " + dequeue.size());  // Should return 2
        System.out.println("Is the Dequeue empty? " + dequeue.isEmpty());  // Should return false

        // Removing all elements
        System.out.println("\nRemoving all elements...");
        dequeue.popFirst();  // Should remove 10
        dequeue.popLast();   // Should remove 20

        // Final state of Dequeue
        System.out.print("Dequeue state after removing all elements: ");
        dequeue.printDequeue();  // Expected: []
        System.out.println("Is the Dequeue empty now? " + dequeue.isEmpty());  // Should return true
    }

}
