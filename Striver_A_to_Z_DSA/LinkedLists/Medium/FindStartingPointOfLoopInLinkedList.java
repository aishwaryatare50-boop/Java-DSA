package Striver_A_to_Z_DSA.LinkedLists.Medium;

import java.util.HashSet;

public class FindStartingPointOfLoopInLinkedList {
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


    // Brute Approach
    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static Node bruteApproach(Node head) {
        if(head == null || head.next == null) return head;

        HashSet<Node> set = new HashSet<>();
        Node temp = head;
        while(temp != null) {
            if(set.contains(temp)) return temp;
            set.add(temp);

            temp = temp.next;
        }

        return null;
    }

    
    // Optimal Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node optimalApproach(Node head) {
        if(head == null || head.next == null) return head;

        Node hare = head;
        Node turtle = head;
        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle) {
                turtle = head;
                while(hare != turtle) {
                    hare = hare.next;
                    turtle = turtle.next;
                }

                return hare;
            }
        }

        return null;
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

        list.createLoop(5);

        // Brute Approach
        System.out.println("Starting point of loop is: " + bruteApproach(list.head).data);

        // Optimal Approach
        System.out.println("Starting point of loop is: " + optimalApproach(list.head).data);
    }
}