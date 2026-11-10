package Striver_A_to_Z_DSA.LinkedLists.Medium;

/*
Given the head of a singly linked list representing a non-negative integer, add one to the number and return the updated linked list. The head node stores the most significant digit, and each node stores one digit.
*/

public class Add1toANumberRepresentedWithLinkedList {

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

    // Iterative Approach
    // Time Complexity = O(n)
    // Space Complexity = O(1)
    public static Node addOneIterative(Node head) {
        if(head == null || head.data == 0) {
            return new Node(1);
        }

        head = reverseLinkedList(head);
        int carry = 1;
        Node temp = head;
        Node prev = null;

        while(temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;
            prev = temp;
            temp = temp.next;
            if(carry == 0) {
                break;
            }
        }

        if(carry != 0) {
            prev.next = new Node(carry);
        }

        head = reverseLinkedList(head);

        return head;
    }

    public static Node reverseLinkedList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null) {
            Node nextNode = currNode.next;
            
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;

        return head;
    }


    // Recursive Approach
    // Time Complexity = O(n)
    // Space Complexity = O(1) // O(N) recursion stack space
    public static Node addOneRecursive(Node head) {
        int carry = addOneHelper(head);

        if(carry != 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
            return head;
        }

        return head;
    }

    public static int addOneHelper(Node head) {
        if(head == null) {
            return 1;
        }

        int carry = addOneHelper(head.next);
        int sum = head.data + carry;

        head.data = sum % 10;

        return sum / 10;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);

        list.printList();

        list.head = addOneIterative(list.head);
        list.printList();

        list = new LinkedList();
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);

        list.printList();

        list.head = addOneRecursive(list.head);
        list.printList();
    }
}