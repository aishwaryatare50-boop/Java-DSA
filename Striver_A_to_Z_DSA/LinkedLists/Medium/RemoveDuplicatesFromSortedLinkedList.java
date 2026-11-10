package Striver_A_to_Z_DSA.LinkedLists.Medium;

public class RemoveDuplicatesFromSortedLinkedList {

    private static class Node {
        int data;
        Node next;
        @SuppressWarnings("unused") Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private static class DoublyLinkedList {
        Node head;

        public void addFirst(int data) {
            Node newNode = new Node(data);

            if(head == null) {
                head = newNode;
                return;
            }

            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }  

        public void printList() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " <--> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node removeDuplicatesFromSortedLL(Node head) {
        if(head == null || head.next == null) return head;

        Node temp = head;
        while(temp != null && temp.next != null) {
            Node nextNode = temp.next;
            while(nextNode != null && temp.data == nextNode.data) {
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
            if(nextNode != null) {
                nextNode.prev = temp;
            }

            temp = nextNode;
        }

        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addFirst(10);
        dll.addFirst(10);
        dll.addFirst(9);
        dll.addFirst(8);
        dll.addFirst(7);
        dll.addFirst(6);
        dll.addFirst(6);
        dll.addFirst(5);
        dll.addFirst(5);
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addFirst(1);
        dll.addFirst(1);

        dll.printList();

        dll.head = removeDuplicatesFromSortedLL(dll.head);
        dll.printList();
    }    
}