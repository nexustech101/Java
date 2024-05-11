package lib;

import java.util.LinkedList;

/**
 * SinglyLinkedList extends LinkedList<Integer>
 * 
 * Custom implementation of a singly linked list that stores Integer elements.
 * 
 * SinglyLinkedList extends the standard LinkedList<Integer> to provide a
 * tailored implementation
 * that is optimized for certain operations or use cases. While retaining all
 * functionalities of
 * the standard LinkedList, this subclass can be extended to include methods
 * that are not part
 * of the standard Java Collections Framework.
 *
 * For instance, this class can be further customized to offer more efficient
 * operations specific
 * to singly linked list structures, such as optimized reverse traversal, more
 * granular control over
 * node manipulation, and operations that take advantage of the inherent
 * properties of singly
 * linked lists.
 *
 * This subclass is ideal for educational purposes, to demonstrate the inner
 * workings of linked lists,
 * or in scenarios where specific linked list behaviors are needed that go
 * beyond the default
 * capabilities provided by Java's LinkedList class.
 * 
 * In a Singly Linked List, each node only points in one direction:
 * 
 * [ 1 -> 2 -> 3 -> 4 -> null ]
 * 
 * that is, each node in the list can only point to it's
 * right-most neighbor, but never left-most.
 * 
 * The lat element in every linked list is a null reference
 * indicating the end of the list. This is convenient for
 * traversing linked lists, effectively avoiding any IndexOutOfBoundsException.
 * 
 * 
 * * Example usage:
 * 
 * <pre>{@code
 * SinglyLinkedList list = new SinglyLinkedList();
 * list.add(1);
 * list.add(2);
 * list.addFirst(0);
 * System.out.println(list); // Output: [ 0 -> 1 -> 2 -> null ]
 * }</pre>
 * 
 */

public class SinglyLinkedList extends LinkedList<Integer> {

    /**
     * Adds an element to the end of the list.
     * 
     * @param n The element to add.
     */
    public void add(int n) {
        super.add(n);
    }

    /**
     * Inserts the specified element at the specified position in the list.
     * 
     * @param index   The index at which the specified element is to be inserted.
     * @param element The element to be inserted.
     */
    public void add(int index, int element) {
        if (index < 0 || index > super.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        super.add(index, element);
    }

    /**
     * Inserts the specified element at the beginning of the list.
     * 
     * @param element The element to add.
     */
    public void addFirst(int element) {
        super.addFirst(element);
    }

    /**
     * Appends the specified element to the end of the list.
     * 
     * @param element The element to add.
     */
    public void addLast(int element) {
        super.addLast(element); // Adds element to the end of the list.
    }

    /**
     * Removes and returns the first element from the list.
     * 
     * @return The first element of the list.
     */
    public Integer removeFirst() {
        if (super.isEmpty()) { // Check if the list is empty
            throw new IllegalStateException("Cannot remove from an empty list");
        }
        return super.removeFirst(); // Remove the first element if list has elements
    }

    /**
     * Removes and returns the last element from the list.
     * 
     * @return The last element of the list.
     */
    public Integer removeLast() {
        if (super.isEmpty()) { // Check if the list is empty
            throw new IllegalStateException("Cannot remove from an empty list");
        }
        return super.removeLast(); // Remove the last element if list has elements
    }

    /**
     * Retrieves, but does not remove, the first element of the list, or returns
     * null if the list is empty.
     * 
     * @return The first element of the list, or null if the list is empty.
     */
    public Integer peek() {
        if (super.isEmpty()) { // Check if the list is empty
            throw new IllegalStateException("Cannot remove from an empty list");
        }
        return super.peek(); // Returns the first element but does not remove it
    }

    /**
     * Retrieves, but does not remove, the first element of the list, or returns
     * null if the list is empty.
     * 
     * @return The first element of the list, or null if the list is empty.
     */
    public Integer peekFirst() {
        if (super.isEmpty()) { // Check if the list is empty
            throw new IllegalStateException("Cannot remove from an empty list");
        }
        return super.peekFirst(); // Returns the first element but does not remove it
    }

    /**
     * Retrieves, but does not remove, the last element of the list, or returns null
     * if the list is empty.
     * 
     * @return The last element of the list, or null if the list is empty.
     */
    public Integer peekLast() {
        if (super.isEmpty()) { // Check if the list is empty
            throw new IllegalStateException("Cannot remove from an empty list");
        }
        return super.peekLast(); // Returns the last element but does not remove it
    }

    /**
     * Rverses the order of the list using built-in get and set methods
     */
    public void reverse() {
        if (this.isEmpty()) { // Check if the list is empty
            throw new IllegalStateException("Cannot reverse an empty list");
        }

        // Use the two-pointer technique to traverse list
        int min = 0; // Starting index reference
        int max = size() - 1; // Ending index reference
        while (min < max) {
            Integer tmp = get(min); // Get element at index min
            set(min, get(max)); // Swap the min for the max element
            set(max, tmp); // swap the max for the min element
            // Increment and decrement min and max
            min++;
            max--;
        }
    }

    /**
     * Sorts and creates a newinstance of the list.
     * 
     * @return A new instance of the sorted list.
     */
    public SinglyLinkedList sort() {
        boolean swapped = false;

        if (this.isEmpty()) {
            throw new IllegalStateException("Cannot sort an empty list");
        }
        
        do {
            swapped = false;
            for (int i = 0; i < size() - 1; i++) {
                if (get(i) > get(i + 1)) {
                    Integer temp = get(i);
                    set(i, get(i + 1));
                    set(i + 1, temp);
                    swapped = true;
                }
            }
        } while (swapped);

        return this;
    }

    /**
     * Loops through the list and checks whether each
     * corresponding element in the list is equal. We are
     * essentially checking whether the list is "symmetrical".
     * 
     * [ A, B, C, D ] false
     * _^________^
     * 
     * [ A, B, C, D ] false
     * ____^__^
     * 
     * 
     * [ A, B, B, A ] true
     * _^________^
     * 
     * [ A, B, B, A ] true
     * ____^__^
     * 
     * As you can see, we are using the two pointer technique
     * to traverse the list, allowing us to check various conditions
     * of the elements in the list in an efficient manner.
     * 
     * @return True if the list is palindromatic.
     */
    public boolean isPalindrome() {
        int min = 0;
        int max = size() - 1;
        while (min < max) {
            // Check if the two corresponding elements are not equal.
            if (get(min) != get(max)) {
                return false; // If so return false.
            }
            min++; // Increment and decrement the two pointer variables.
            max--;
        }
        return true; // Else is palindrome, so return true.
    }

    /**
     * Prints the elements of the list in a human-readable format.
     */
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (Integer element : this) {
            sb.append(element).append(" -> ");
        }
        sb.append("null");
        sb.append(" ]");
        System.out.println(sb.toString());
    }
}
