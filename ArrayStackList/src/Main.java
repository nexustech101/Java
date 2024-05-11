package src;

import java.util.ArrayList;
import lib.ArrayStackList;

public class Main {

    /**
     * Prints the elements of the list in a human-readable format.
     */
    public static void print(ArrayList<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (Integer element : stack) {
            sb.append(element).append(" -> ");
        }
        sb.append("null");
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ArrayStackList<Integer> stack = new ArrayStackList<Integer>();

        stack.push(3);
        stack.push(6);
        stack.push(9);
        stack.push(12);
        System.out.println('\n');
        System.out.println(stack.peek());

        System.out.println(stack.undo());
        System.out.println(stack.redo());
        System.out.println(stack.undo());
        System.out.println(stack.redo());
        System.out.println(stack.undo());
        System.out.println(stack.undo());
        System.out.println(stack.undo());
        // stack.reset();
        
        if (stack.undo() == null) {
            System.out.println("The stack is empty: " + stack.peek());
        }

    }
}
