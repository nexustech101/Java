
/**
 * Defines the operations for a stack data structure.
 * A stack is a collection of elements that supports the Last In, First Out
 * (LIFO) principle.
 * This interface defines the basic operations such as push, pop, peek, and
 * methods to query the stack's size and emptiness.
 *
 * @param <T> the type of elements held in this stack.
 */
public interface Stack<T> {

    /**
     * Adds an element to the top of the stack.
     * 
     * @param n the element to add to the stack.
     */
    void push(T n);

    /**
     * Removes and returns the element at the top of the stack.
     * This method may throw an exception if the stack is empty, depending on the
     * implementation.
     * 
     * @return the element at the top of the stack.
     */
    T pop();

    /**
     * Returns the element at the top of the stack without removing it.
     * This method may throw an exception if the stack is empty, depending on the
     * implementation.
     * 
     * @return the element at the top of the stack.
     */
    T peek();

    /**
     * Returns the number of elements in the stack.
     * 
     * @return the number of elements in the stack.
     */
    int size();

    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack contains no elements, false otherwise.
     */
    boolean isEmpty();
    
}
