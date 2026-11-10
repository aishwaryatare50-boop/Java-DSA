package Striver_A_to_Z_DSA.LinkedLists.Hard;

/*
Given the head of a linked list, rotate the list to the right by k places.
*/

import java.util.Scanner;

public class RotateALinkedList {

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

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node rotateList(Node head, int k) {
        if(head == null || head.next == null) return head;

        int length = 0;
        Node temp = head;
        Node tail = head;
        while(temp != null) {
            length++;
            tail = temp;
            temp = temp.next;
        }

        if(k % length == 0) return head;
        k = k % length;

        // tail should point to head
        tail.next = head;

        // new last node
        int count = length - k;
        temp = head;
        for(int i=0; i<count-1; i++) {
            temp = temp.next;
        }

        head = temp.next; // new head
        temp.next = null; // new tail

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.printList();

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        list.head = rotateList(list.head, k);
        list.printList();

        sc.close();
    }
}