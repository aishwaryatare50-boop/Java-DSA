/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
*/

package Striver_A_to_Z_DSA.LinkedLists.Medium;

public class RemoveNthNodeFromEndOfLinkedList {

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

    // Approach 1
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node approach1(Node head, int n) {
        if(head == null || head.next == null) {
            return null;
        }

        int length = 0;
        Node temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }

        if(length == n) return head.next;

        int prev = length - n;
        temp = head;
        for(int i=0; i<prev-1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }


    // Approach 2
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node approach2(Node head, int n) {
        if(head == null || head.next == null) {
            return null;
        }

        Node fast = head;
        for(int i=0; i<n; i++) {
            fast = fast.next;
        }

        if(fast == null) {
            return head.next;
        }

        Node slow = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

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

        // approach 1
        list.head = approach1(list.head, 3);
        list.printList();

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

        // approach 2
        list.head = approach2(list.head, 6);
        list.printList();
    }
}