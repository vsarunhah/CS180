import java.util.NoSuchElementException;
/**
 * A simple singly-linked LinkedList class
 *
 * <p>Purdue University -- CS18000 -- Fall 2019 -- LB15</p>
 */

public class MyLinkedList {

    public Node head; // head of list. DO NOT MODIFY NAME OR ACCESS MODIFIER

    /**
     * Simple Node class, represents a Node
     * contained within a MyLinkedList instance
     */
    private class Node {

        int data;
        Node link;

        /**
         * Constructor for Node
         * @param data Integer data associated with the Node
         */
        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    /**
     * Default constructor for MyLinkedList class
     */
    public MyLinkedList(){
        head = null;
    }

    /**
     * A method to create and insert a node at the end of the list
     *
     * @param data Integer data associated with the new Node
     */
    public void addNode(int data) {
        // Create the new Node.  
        Node newEntry = new Node(data);
    
        // If the list is empty, make the new 
        // entry the head. 
        if(head == null) {
            head = newEntry;
            return;
        }
    
        // Create a Node to traverse the list. 
        Node current = head;

        // Traverses the list to the last entry.
        while(current.link != null) {
            current = current.link;
        }

        // Add the new entry to the list. 
        current.link = newEntry;
    }
    
    // DO NOT MODIFY ABOVE
    
    /**
     * A method to delete the first occurrence of a Node whose data matches value. 
     *
     * @param value Integer value associated with the Node to be deleted.
     * @throws NoSuchElementException if the specified value is not in the list. 
    */
    public void deleteNode(int value) throws NoSuchElementException {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == value)
        {
            head = temp.link; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != value)
        {
            prev = temp;
            temp = temp.link;
        }
        if(temp.data == value){
            prev.link = temp.link;
        }
        // If key was not present in linked list
        if (temp == null){
            throw new NoSuchElementException();
        }

        // Unlink the node from
    }
    
    /**
     * A method to add a Node to the list while maintaining the sorted order.  
     *
     * @param data Integer data associated with the new Node
    */
    public void addNodeSorted(int data) {
        Node currentNode = head;
        Node add = new Node(data);
        while(currentNode.link != null){
            if(currentNode.data < data && currentNode.link.data >= data){
                add.link = currentNode.link;
                currentNode.link = add;
                return;
            }
            currentNode = currentNode.link;
        }
        currentNode.link = add;
    }

    // DO NOT MODIFY BELOW

    /**
     * A helper function to print out an
     * instance of MyLinkedList to help
     * visualize the list and assist with debugging
     */
     public void printList() {
        Node current = this.head;
        System.out.println("-----"); 
        while (current != null) {
            if(current.link != null) {
                System.out.print(current.data + "->");
            }
            else {
                System.out.println(current.data+ "->X"); 
            }
            current = current.link;
        }
        System.out.println("-----");
    }

    public static void main(String[] args) {
        MyLinkedList newLinkedList = new MyLinkedList();
        newLinkedList.addNode(10);
        newLinkedList.printList();
        newLinkedList.addNode(20);
        newLinkedList.printList();
        newLinkedList.addNodeSorted(15);
        newLinkedList.printList();
        newLinkedList.deleteNode(20);
        newLinkedList.printList();
    }
}