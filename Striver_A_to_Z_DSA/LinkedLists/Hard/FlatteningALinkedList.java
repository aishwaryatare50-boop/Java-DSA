package Striver_A_to_Z_DSA.LinkedLists.Hard;

import java.util.ArrayList;
import java.util.Collections;

public class FlatteningALinkedList {
    
    private static class Node {
        int data;
        Node next;
        Node child;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    public static void printLinkedVertical(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.child;
        }
        System.out.println("null");
    }


    // Brute Approach
    // Time Complexity = O((N*M)log(N*M))
    // Space Complexity = O(N*M)
    public static Node flattenListBruteApproach(Node head) {
        Node temp = head;
        ArrayList<Node> list = new ArrayList<>();

        while(temp != null) {
            Node temp2 = temp;
            while(temp2 != null) {
                list.add(temp2);
                temp2 = temp2.child;
            }

            temp = temp.next;
        }

        Collections.sort(list, (a, b) -> Integer.compare(a.data, b.data));

        Node dummyNode = new Node(-1);
        temp = dummyNode;
        for(Node n : list) {
            temp.child = n;
            temp = temp.child;
        }

        return dummyNode.child;
    }


    // Optimal Approach
    // Time Complexity = O(N*(N+M))
    // Space Complexity = O(1)
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
                temp.child = temp1;
                temp = temp.child;
                temp1 = temp1.child;
            } else {
                temp.child = temp2;
                temp = temp.child;
                temp2 = temp2.child;
            }
            temp.next = null;
        }

        if(temp1 != null) temp.child = temp1;
 
        if(temp2 != null) temp.child = temp2;

        return dummyNode.child;
    }

    public static Node flattenLinkedList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node newHead = mergeTwoSortedLinkedLists(head, flattenLinkedList(head.next));

        return newHead;
    }


    public static void main(String[] args) {
        Node head = new Node(3);

        Node n1 = new Node(2);
        head.next = n1;
        
        Node n2 = new Node(10);
        n1.child = n2;

        Node n3 = new Node(1);
        n1.next = n3;

        Node n4 = new Node(7);
        n3.child = n4;

        Node n5 = new Node(11);
        n4.child = n5;

        Node n6 = new Node(12);
        n5.next = n6;
        
        Node n7 = new Node(4);
        n3.next = n7;

        Node n8 = new Node(9);
        n7.child = n8;

        // Brute Approach
        printLinkedVertical(flattenListBruteApproach(head));

        // Optimal Approach
        head = new Node(3);

        n1 = new Node(2);
        head.next = n1;
        
        n2 = new Node(10);
        n1.child = n2;

        n3 = new Node(1);
        n1.next = n3;

        n4 = new Node(7);
        n3.child = n4;

        n5 = new Node(11);
        n4.child = n5;

        n6 = new Node(12);
        n5.next = n6;
        
        n7 = new Node(4);
        n3.next = n7;

        n8 = new Node(9);
        n7.child = n8;

        printLinkedVertical(flattenLinkedList(head));
    }
}