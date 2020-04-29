import java.util.NoSuchElementException;
/**
 * A simple doubly-linked LinkedList class
 *
 * <p>Purdue University -- CS18000 -- Fall 2019 -- LB15</p>
 */

public class MyDoublyLinkedList {

    public Node head; // head of list. DO NOT MODIFY NAME OR ACCESS MODIFIER
    public Node tail; // tail of list. DO NOT MODIFY NAME OR ACCESS MODIFIER

    /**
     * Simple Node class, represents a Node
     * contained within a MyLinkedList instance
     */
    private class Node {

        int data;
        Node previousLink;
        Node nextLink; 

        /**
         * Constructor for Node
         * @param data Integer data associated with the Node
         */
        Node(int data) {
            this.data = data;
            this.previousLink = null;
            this.nextLink = null; 
        }
    }

    /**
     * Default constructor for MyLinkedList class
     */
    public MyDoublyLinkedList(){
        head = null;
        tail = null; 
    }
    
    // DO NOT MODIFY ABOVE

    /**
     * A method to create and insert a node at the front of the list
     *
     * @param data Integer data associated with the new Node
     */
    public void addNodeFront(int data) {
        Node addFront = new Node(data);
        if(head != null) {
            Node nextNode = head;
            head = addFront;
            addFront.nextLink = nextNode;
            nextNode.previousLink = addFront;
        }
        else{
            head = addFront;
        }
        if(tail == null){
            tail = head;
        }
    }
    
    /**
     * A method to create and insert a node at the end of the list
     *
     * @param data Integer data associated with the new Node
     */
    public void addNodeEnd(int data) {
        Node endNode = new Node(data);
        if(tail != null) {
            if (tail.previousLink != null) {
                Node previousNode = tail.previousLink;
                tail.previousLink = endNode;
                endNode.previousLink = previousNode;
            } else {
                tail.previousLink = endNode;
                endNode.previousLink = head;
                head.nextLink = endNode;
            }
        }
        else{
            tail = endNode;
        }
        if(head == null){
            head = endNode;
        }
    }
    
 
    
    /**
     * A method to add a Node to the list while maintaining the sorted order.  
     *
     * @param data Integer data associated with the new Node
    */
    public void addNodeSorted(int data) {
        Node sortedNode = new Node(data);
        if (head != null) {
            Node currentNode = head;
            while (currentNode.nextLink != null) {
                if (currentNode.nextLink.data >= data && currentNode.data < data) {
                    sortedNode.nextLink = currentNode.nextLink;
                    sortedNode.previousLink = currentNode;
                    currentNode.nextLink = sortedNode;
                    return;
                }
                currentNode = currentNode.nextLink;
            }
            sortedNode.previousLink = tail.previousLink;
            tail.previousLink = sortedNode;
        }
        else{
            head = sortedNode;
            sortedNode.nextLink = tail;
        }
    }

    // DO NOT MODIFY BELOW

    /**
     * A helper function to print out an
     * instance of MyDoublyLinkedList to help
     * visualize the list and assist with debugging
     */
    public void printList() {
        Node current = this.head;
        System.out.println("-----"); 
        while (current != null) {
            if(current.previousLink != null && current.nextLink != null) {
                System.out.print("<-" + current.data + "->");
            }
            else if(current.nextLink !=null && current.previousLink == null) {
                System.out.print("X<-" + current.data + "->");
            }
            else {
                System.out.println(current.data + "->X"); 
            }
            current = current.nextLink;
        }
        System.out.println("-----");
    }
    
     /**
     * A helper function to print out an
     * instance of MyDoublyLinkedList in reverse to help
     * visualize the list and assist with debugging
     */
    public void printListReverse() {
        Node current = this.tail;
        System.out.println("-----"); 
        while (current != null) {
            if(current.previousLink != null && current.nextLink != null) {
                System.out.print("<-" + current.data + "->");
            }
            else if(current.previousLink != null && current.nextLink == null) {
                System.out.print("X<-" + current.data + "->");
            }
            else {
                System.out.println(current.data + "->X"); 
            }
            current = current.previousLink;
        }
        System.out.println("-----");
    }

    public static void main(String[] args) {
        MyDoublyLinkedList newLinkedList = new MyDoublyLinkedList();
        newLinkedList.addNodeFront(10);
        newLinkedList.printList();
        newLinkedList.addNodeEnd(20);
        newLinkedList.printList();
        newLinkedList.addNodeSorted(15);
        newLinkedList.printList();
    }
}