package Striver_A_to_Z_DSA.LinkedLists.Medium;

import java.util.HashSet;

public class FindIntersectionOfTwoLinkedLists {
    
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList(Node head) {
        if(head == null) return;

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Brute Approach
    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static Node bruteApproach(Node headA, Node headB) {
        HashSet<Node> set = new HashSet<>();
        Node temp = headA;
        while(temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while(temp != null) {
            if(set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    // Better Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static int findLength(Node head) {
        Node temp = head;
        int length = 0;

        while(temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public static Node betterApproach(Node headA, Node headB) {
        if(headA == null || headB == null) return null;

        int l1 = findLength(headA);
        int l2 = findLength(headB);

        if(l1 > l2) {
            return helper(headB, headA, l1 - l2);
        } else {
            return helper(headA, headB, l2 - l1);
        }

    }

    public static Node helper(Node headA, Node headB, int diff) {
        Node temp1 = headA;
        Node temp2 = headB;

        for(int i=0; i<diff; i++) {
            temp2 = temp2.next;
        }

        while(temp1 != null && temp2 != null) {
            if(temp1 == temp2) return temp1;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;
    }


    // Optimal Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node optimalApproach(Node headA, Node headB) {
        if(headA == null || headB == null) return null;

        Node temp1 = headA;
        Node temp2 = headB;
        while(temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == null) temp1 = headB;

            if(temp2 == null) temp2 = headA;
        }

        return temp1;
    } 


    public static void main(String[] args) {
        Node headA = new Node(1);
        Node headB = new Node(-3);

        // list a
        Node a1 = new Node(2);
        headA.next = a1;

        Node a2 = new Node(3);
        a1.next = a2;

        Node a3 = new Node(4);
        a2.next = a3;

        Node a4 = new Node(5);
        a3.next = a4;

        // list b
        Node b1 = new Node(-2);
        headB.next = b1;

        Node b2 = new Node(-1);
        b1.next = b2;

        Node b3 = new Node(0);
        b2.next = b3;

        // intersection
        b3.next = a2;

        System.out.println("List A:");
        printList(headA);

        System.out.println("List B:");
        printList(headB);

        // Intersection node:

        // brute approach
        System.out.println("Intersection of List A and List B occurs at: " + bruteApproach(headA, headB).data);

        // better approach
        System.out.println("Intersection of List A and List B occurs at: " + betterApproach(headA, headB).data);

        // optimal approach
        System.out.println("Intersection of List A and List B occurs at: " + optimalApproach(headA, headB).data);
    }    
}