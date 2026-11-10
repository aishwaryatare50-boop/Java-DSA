/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
*/

package Striver_A_to_Z_DSA.LinkedLists.Hard;

import java.util.Scanner;

public class ReverseNodesinKGroupSizeOfLinkedList {

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

    public static Node reverseList(Node head) {
        if(head == null || head.next == null) return head;

        Node prevNode = null;
        Node currNode = head;
        while(currNode != null) {
            Node nextNode = currNode.next;

            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }

        head = prevNode;

        return head;
    }

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node reverseInKGroups(Node head, int k) {
        if(head == null || k <= 1) return head;
        
        Node temp = head;
        Node nextNode;
        Node prevNode = null;
        while(temp != null) {
            Node kthNode = findKthNode(temp, k);

            if(kthNode == null) {
                if(prevNode != null) prevNode.next = temp;
                break;
            }

            nextNode = kthNode.next;
            kthNode.next = null;

            if(temp == head) {
                head = reverseList(temp);
            } else {
                prevNode.next = reverseList(temp);
            }

            prevNode = temp;
            temp = nextNode;
        }


        return head;
    }

    public static Node findKthNode(Node head, int k) {
        Node temp = head;
        for(int i=0; i<k-1; i++) {
            if(temp == null) break;
            temp = temp.next;
        }

        return temp;
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

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        list.head = reverseInKGroups(list.head, k);

        list.printList();

        sc.close();
    }
}