package Striver_A_to_Z_DSA.LinkedLists.Medium;

/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
*/

import java.util.ArrayList;

public class SegregateOddAndEvenElementsInLinkedList {

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

    // Brute Approach
    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static Node bruteApproach(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        ArrayList<Integer> list = new ArrayList<>();

        while(temp != null && temp.next != null) {
            list.add(temp.data);
            temp = temp.next.next;
        }

        if(temp != null && temp.next == null) {
            list.add(temp.data);
        }

        temp = head.next;
        while(temp != null && temp.next != null) {
            list.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null && temp.next == null) {
            list.add(temp.data);
        }

        temp = head;
        for(int n : list) {
            temp.data = n;
            temp = temp.next;
        }

        return head;
    }

    // Optimal Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node optimalApproach(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
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