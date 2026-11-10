// Given a non-empty, singly linked list with head node head, return a middle node of linked list.

package Striver_A_to_Z_DSA.LinkedLists.Medium;

public class FindMiddleNodeInLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static class LinkedList {
        Node head;

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
            if(head == null) {
                System.out.println("List is empty!");
                return;
            }

            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    // Brute approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node bruteApproach(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        int length = 0;
        Node temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }

        int middleIndex = length / 2;
        temp = head;
        for(int i=0; i<middleIndex; i++) {
            temp = temp.next;
        }

        return temp;
    }


    // Optimal approach 1
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // for finding the second middle node in case of even length linked list
    public static Node optimalApproach1(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node hare = head;
        Node turtle = head;
        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle;
    }


    // Optimal approach 2
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // for finding the first middle node in case of even length linked list
    public static Node optimalApproach2(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node hare = head;
        Node turtle = head;
        while(hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.printList();

        // brute approach
        System.out.println(bruteApproach(list.head).data);

        // optimal approach
        // first middle in even length linked list
        System.out.println(optimalApproach2(list.head).data);
        // second middle in even length linked list
        System.out.println(optimalApproach1(list.head).data);
    }
}