package Striver_A_to_Z_DSA.LinkedLists.Medium;

public class DeleteAllOccurencesOfAKeyInDLL {

    private static class Node {
        int data;
        Node next;
        Node prev;

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
    public static Node deleteAllNodesWithOccurenceOfK(Node head, int k) {
        Node temp = head;

        while(temp != null) {
            if(temp.data == k) {
                if(temp == head) {
                    head = head.next;
                }

                Node prevNode = temp.prev;
                Node nextNode = temp.next;

                if(prevNode != null) {
                    prevNode.next = nextNode;
                }

                if(nextNode != null) {
                    nextNode.prev = prevNode;
                }

                temp = nextNode;

            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(10);
        dll.addFirst(4);
        dll.addFirst(11);
        dll.addFirst(10);
        dll.addFirst(34);
        dll.addFirst(10);
        dll.addFirst(10);
        dll.addFirst(5);
        dll.addFirst(10);
        dll.addFirst(10);
        dll.addFirst(10);
        dll.addFirst(10);
        dll.addFirst(10);
        dll.addFirst(1);
        dll.addFirst(10);
        dll.addFirst(10);
        dll.addFirst(10);
        dll.addFirst(10);

        dll.printList();

        dll.head = deleteAllNodesWithOccurenceOfK(dll.head, 10);
        dll.printList();
    }
}