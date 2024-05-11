import java.util.EmptyStackException;

/**
 * Implements a stack using a singly linked list structure with thread-safe
 * operations.
 * This class ensures that all operations on the stack are thread-safe by
 * synchronizing method access,
 * meaning that only one thread can modify the stack at a time, preventing data
 * corruption and ensuring data consistency.
 * 
 * @param <T> the type of elements held in this stack.
 */
public class LinkedStack<T> implements Stack<T> {

    /**
     * Private inner class representing a node in the stack.
     * Each node holds an integer value (plate) and a reference to the next node.
     */
    private static class Node<T> {
        private T plate;      // The integer value this node holds
        private Node<T> next; // Reference to the next node in the stack

        /**
         * Constructs a new node with a specified integer.
         * 
         * @param current the integer to store in this node.
         */
        public Node(T current) {
            plate = current;
        }
    }

    private Node<T> top; // Top of the stack, initialized to null
    private int count;   // Counter for the number of elements in the stack

    /**
     * Constructs an empty LinkedStack.
     */
    public LinkedStack() {
        top = null;
        count = 0;
    }

    /**
     * Adds an integer to the top of the stack.
     * This method is synchronized to make the operation thread-safe.
     * 
     * @param current the integer to add to the stack.
     */
    @Override
    public synchronized void push(T current) {
        Node<T> c = new Node<T>(current);
        c.next = top;
        top = c;
        count++;
    }

    /**
     * Removes and returns the integer at the top of the stack.
     * This method is synchronized to ensure thread safety.
     * 
     * @return the integer at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public synchronized T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T topPlate = top.plate;
        top = top.next;
        count--;
        return topPlate;
    }

    /**
     * Returns the integer at the top of the stack without removing it.
     * This method is synchronized to provide thread safety.
     * 
     * @return the integer at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public synchronized T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.plate;
    }

    /**
     * Returns the number of elements in the stack.
     * This method is synchronized to ensure thread safety.
     * 
     * @return the number of elements in the stack.
     */
    @Override
    public synchronized int size() {
        return count;
    }

    /**
     * Checks if the stack is empty.
     * This method is synchronized to ensure thread safety.
     * 
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public synchronized boolean isEmpty() {
        return top == null;
    }

}
