// Given the head of a singly linked list, delete the middle node, and return the head of the modified linked list.
// *for even length, delete the second middle node.

package Striver_A_to_Z_DSA.LinkedLists.Medium;

public class DeleteMiddleNodeInLinkedList {
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
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    // brute force approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node bruteApproach(Node head) {
        if(head == null || head.next == null) {
            return null;
        }

        int length = 0;
        Node temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }

        temp = head;
        int idxToFind = length / 2 - 1;
        for(int i=0; i<idxToFind; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }


    // Optimal approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node optimalApproach(Node head) {
        if(head == null || head.next == null) {
            return null;
        }

        Node hare = head;
        Node turtle = head;
        Node prev = turtle;
        while(hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            prev = turtle;
            turtle = turtle.next;
        }

        if(hare.next == null) {
            prev.next = prev.next.next;
        } else {
            turtle.next = turtle.next.next;
        }

        return head;
    }

    /* We can also do this version:

    public static Node optimalApproach(Node head) {

        if(head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }
    
    */

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
        list.head = bruteApproach(list.head);
        list.printList();

        // optimal approach
        list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.printList();

        list.head = optimalApproach(list.head);
        list.printList();
    }
}