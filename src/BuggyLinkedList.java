public class BuggyLinkedList {

    public Node head; //DO NOT MODIFY NAME OR ACCESS MODIFIER

    private class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert a Node at the front of the list. 
    public void insert(int data) {
        Node newEntry = new Node(data);
        if(head == null) {
            head = newEntry;
            return;
        } else if(head.link != null) {
            newEntry.link = head.link;
            head.link = newEntry;
            return;
        }  else{
            head.link = newEntry;
        }

    }

    // Print the list from the beginning. 
    public void printList() {
        Node current = head;
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
    }

    public static void main(String[] args) {
        BuggyLinkedList bll = new BuggyLinkedList();
        bll.insert(5);
        bll.insert(10);
        bll.printList();
    }
}
