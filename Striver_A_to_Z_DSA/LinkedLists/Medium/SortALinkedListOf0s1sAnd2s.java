package Striver_A_to_Z_DSA.LinkedLists.Medium;

/*
Given the head of a singly linked list, where every node contains only 0, 1, or 2, sort the linked list in non-decreasing order.

Return the head of the sorted linked list.
*/

public class SortALinkedListOf0s1sAnd2s {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
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
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node bruteApproach(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        int countZero = 0, countOne = 0, countTwo = 0;
        Node temp = head;

        while(temp != null) {
            int data = temp.data;
            
            if(data == 0) countZero++;
            else if(data == 1) countOne++;
            else countTwo++;

            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(countZero != 0) {
                temp.data = 0;
                countZero--;
            } else if(countOne != 0) {
                temp.data = 1;
                countOne--;
            } else if(countTwo != 0) {
                temp.data = 2;
                countTwo--;
            }
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

        Node zeroHead = new Node(-1);
        Node zero = zeroHead;

        Node oneHead = new Node(-1);
        Node one = oneHead;

        Node twoHead = new Node(-1);
        Node two = twoHead;

        Node temp = head;

        while(temp != null) {
            int data = temp.data;

            if(data == 0) {
                zero.next = temp;
                zero = temp;
            } else if(data == 1) {
                one.next = temp;
                one = temp;
            } else {
                two.next = temp;
                two = temp;
            }

            temp = temp.next;
        }

        zero.next = oneHead.next == null ? twoHead.next : oneHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    } 


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(0);
        list.addLast(1);
        list.addLast(0);
        list.addLast(2);
        list.addLast(0);
        list.addLast(1);

        list.printList();

        // brute approach
        list.head = bruteApproach(list.head);
        list.printList();

        list = new LinkedList();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(0);
        list.addLast(1);
        list.addLast(0);
        list.addLast(2);
        list.addLast(0);
        list.addLast(1);

        list.printList();

        // optimal approach
        list.head = optimalApproach(list.head);
        list.printList();
    }
}