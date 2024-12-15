package lib.errors;

// Dequeue/lib/errors/EmptyDequeException.java

/**
 * Custom exception class to handle cases when an operation is performed on an
 * empty Dequeue.
 * This exception is thrown to signal that the Dequeue is empty and cannot
 * perform certain operations.
 */
public class EmptyDequeException extends RuntimeException {

    /**
     * Constructor that takes a custom error message.
     * 
     * @param message The detail message about the exception.
     */
    public EmptyDequeException(String message) {
        super(message); // Pass the message to the superclass (RuntimeException)
    }
    
}
