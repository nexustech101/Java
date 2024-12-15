package lib.errors;

// Dequeue/lib/errors/NullElementDequeException.java

/**
 * Custom exception class to handle cases when a null element is added to the
 * Dequeue.
 * This exception is thrown to signal that null elements are not allowed in the
 * Dequeue.
 */
public class NullElementDequeException extends RuntimeException {

    /**
     * Constructor that takes a custom error message.
     * 
     * @param message The detail message about the exception.
     */
    public NullElementDequeException(String message) {
        super(message); // Pass the message to the superclass (RuntimeException)
    }
    
}
