/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

*/

package Striver_A_to_Z_DSA.LinkedLists.Medium;

public class Add2NumbersInLinkedList {

    static class Node {
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

    // Time Complexity = O(max(n1, n2))
    // Space Complexity = O(1) // O(max(n1, n2)) for returning answer
    public static Node addTwoNumbers(Node head1, Node head2) {
        Node dummyNode = new Node(-1);
        int carry = 0;
        Node currNode = dummyNode;
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != null || temp2 != null) {
            int sum = carry;
            if(temp1 != null) {
                sum += temp1.data;
            }

            if(temp2 != null) {
                sum += temp2.data;
            }

            Node newNode = new Node(sum % 10);
            carry = sum / 10;
            currNode.next = newNode;
            currNode = currNode.next;

            if(temp1 != null) {
                temp1 = temp1.next;
            }
            
            if(temp2 != null) {
                temp2 = temp2.next;
            }
        }

        if(carry != 0) {
            Node newNode = new Node(carry);
            currNode.next = newNode;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.addLast(3);
        list1.addLast(5);

        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(9);
        list2.addLast(9);

        LinkedList sum = new LinkedList();
        sum.head = addTwoNumbers(list1.head, list2.head);
        sum.printList();
    }
}