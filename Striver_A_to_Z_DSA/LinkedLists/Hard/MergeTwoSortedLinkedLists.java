package Striver_A_to_Z_DSA.LinkedLists.Hard;

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedLinkedLists {

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
    // Time Complexity = O((N1+N2)log(N1+N2))
    // Space Complexity = O(N1 + N2)
    public static Node bruteApproach(Node head1, Node head2) {
        if(head1 == null && head2 == null) return null;

        if(head1 == null) return head2;
        
        if(head2 == null) return head1;
        
        ArrayList<Node> list = new ArrayList<>();

        Node temp = head1;
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        temp = head2;
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        Collections.sort(list, (a, b) -> {
            return Integer.compare(a.data, b.data);
        });
        Node newHead = list.removeFirst();
        temp = newHead;
        
        for(Node node : list) {
            temp.next = node;
            temp = temp.next;
        }

        temp.next = null;

        return newHead;
    }

    // Optimal Approach
    // Time Complexity = O(N1 + N2)
    // Space Complexity = O(1)
    public static Node optimalApproach(Node head1, Node head2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        Node temp1 = head1;
        Node temp2 = head2;

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

        if(temp1 != null) {
            temp.next = temp1;
        }

        if(temp2 != null) {
            temp.next = temp2;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);
        list1.addLast(9);
        list1.addLast(10);
        list1.printList();
        
        LinkedList list2 = new LinkedList();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(7);
        list2.addLast(8);
        list2.addLast(9);
        list2.addLast(10);
        list2.printList();

        LinkedList sortedList = new LinkedList();

        // Brute Approach
        sortedList.head = bruteApproach(list1.head, list2.head);
        sortedList.printList();


        // Optimal Approach
        list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);
        list1.addLast(9);
        list1.addLast(10);
        list1.printList();

        list2 = new LinkedList();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(7);
        list2.addLast(8);
        list2.addLast(9);
        list2.addLast(10);
        list2.printList();

        sortedList.head = optimalApproach(list1.head, list2.head);
        sortedList.printList();
    }
}