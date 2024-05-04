public class Main {

    public static void main(String[] arg) {
        // Create an instance of SinglyLinkedList
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList listClone;

        // Add elements to the list
        list.add(1); // Adds 1 to the end of the list
        list.add(3); // Adds 3 to the end of the list
        list.add(1, 2); // Adds 2 at index 1 (0-based index), shifting elements to the right
        list.add(4); // Adds 4 to the end of the list

        // Print the elements of the list
        System.out.println('\n');
        list.print();

        list.reverse(); // Reverse the list
        list.print();

        listClone = list.sort(); // Effectively sort and clone the list
        listClone.print();
        System.out.println('\n');
        
    }
}
