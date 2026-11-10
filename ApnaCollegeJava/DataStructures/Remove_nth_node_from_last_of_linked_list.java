package DataStructures;

public class Remove_nth_node_from_last_of_linked_list {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

        
    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void printList() {
        Node temp = head;
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node removeNthNode(Node head, int n) {
        if(head.next == null) {
            return null;
        }

        int size = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        if(n == size) {
            return head.next;
        }

        int indexToSearch = size-n;
        temp = head;
        int i=1;
        while(i < indexToSearch) {
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;

        return head;
    }

    public static void main(String[] args) {
        Remove_nth_node_from_last_of_linked_list list = new Remove_nth_node_from_last_of_linked_list();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.printList();

        list.removeNthNode(list.head, 2);
        list.printList();
    }

    
}
