package Striver_A_to_Z_DSA.LinkedLists.Medium;

import java.util.HashMap;

public class LengthOfLoopInLinkedList {
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

        public void createLoop(int position) {
            if(position <= 0) {
                return;
            }

            Node start = head;
            for(int i=0; i<position-1; i++) {
                start = start.next;
            }

            Node last = head;
            while(last.next != null) {
                last = last.next;
            }

            last.next = start;
        }
    }


    // Brute Force Approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int bruteApproach(Node head) {
        if(head == null || head.next == null) {
            return 0;
        }

        HashMap<Node, Integer> map = new HashMap<>();
        int timer = 1;
        Node temp = head;
        while(temp != null) {
            if(map.containsKey(temp)) {
                return timer - map.get(temp);                       
            }

            map.put(temp, timer);
            timer++;
            temp = temp.next;
        }

        return 0;
    }


    // Optimal Approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int loopLength(Node head) {
        if(head == null || head.next == null) {
            return 0;
        }

        Node hare = head;
        Node turtle = head;

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle) {
                return helper(hare, turtle);
            }
        }

        return 0;
    }

    public static int helper(Node hare, Node turtle) {
        int length = 1;
        hare = hare.next;
        while(hare != turtle) {
            hare = hare.next;
            length++;
        }

        return length;
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

        list.createLoop(4);

        System.out.println("Length of loop in given linked list is: " + bruteApproach(list.head));

        System.out.println("Length of loop in given linked list is: " + loopLength(list.head));
    }
}