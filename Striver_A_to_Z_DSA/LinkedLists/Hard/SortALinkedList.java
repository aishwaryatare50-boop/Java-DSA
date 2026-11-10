package Striver_A_to_Z_DSA.LinkedLists.Hard;

import java.util.ArrayList;
import java.util.Collections;

public class SortALinkedList {

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

    // Brute Approach
    // Time Complexity = O(NlogN)
    // Space Complexity = O(N)
    public static Node bruteApproach(Node head) {
        if(head == null || head.next == null) return head;

        Node temp = head;
        ArrayList<Node> list = new ArrayList<>();
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        Collections.sort(list, (a, b) -> Integer.compare(a.data, b.data));

        Node dummyNode = new Node(-1);
        temp = dummyNode;
        for(Node node : list) {
            temp.next = node;
            temp = temp.next;
        }
        temp.next = null;

        return dummyNode.next;
    }


    // Optimal Approach
    // Time Complexity = O(NlogN)
    // Space Complexity = O(1) // O(LogN) recursion stack 

    public static Node findMiddle(Node head) {
        if(head == null || head.next == null) return head;

        Node hare = head;
        Node turtle = head;
        while(hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle;
    }

    public static Node mergeTwoSortedLinkedLists(Node head1, Node head2) {
        if(head1 == null && head2 == null) return null;

        if(head1 == null) return head2;

        if(head2 == null) return head1;

        Node temp1 = head1;
        Node temp2 = head2;
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        
        while(temp1 != null && temp2 != null) {
            if(temp1.data < temp2.data) {
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }

        if(temp1 != null) temp.next = temp1;

        if(temp2 != null) temp.next = temp2;

        return dummyNode.next;
    }

    public static Node sortLinkedList(Node head) {
        if(head == null || head.next == null) return head;

        Node middle = findMiddle(head);
        Node secHead = middle.next;
        middle.next = null;

        head = sortLinkedList(head);
        secHead = sortLinkedList(secHead);

        return mergeTwoSortedLinkedLists(head, secHead);
    }


    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(25);
        list1.addLast(36);
        list1.addLast(7);
        list1.addLast(45);
        list1.addLast(60);
        list1.addLast(12);
        list1.addLast(8);
        list1.addLast(90);
        list1.addLast(106);
        list1.printList();

        // Brute Approach
        list1.head = bruteApproach(list1.head);
        list1.printList();

        // Optimal Approach
        list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(25);
        list1.addLast(36);
        list1.addLast(7);
        list1.addLast(45);
        list1.addLast(60);
        list1.addLast(12);
        list1.addLast(8);
        list1.addLast(90);
        list1.addLast(106);
        list1.printList();

        // Optimal Approach
        list1.head = sortLinkedList(list1.head);
        list1.printList();
    }    
}