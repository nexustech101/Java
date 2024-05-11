public class Main {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.push(10);
        stack.push(20);
        System.out.println("\nPeek: " + stack.peek()); // Outputs: Peek: 20
        System.out.println("Pop: " + stack.pop()); // Outputs: Pop: 20
        System.out.println("Is Empty: " + stack.isEmpty()); // Outputs: Is Empty: false
        System.out.println("Size: " + stack.size()); // Outputs: Size: 1
    }
}
