package Striver_A_to_Z_DSA.LinkedLists.Medium;

import java.util.Stack;

public class LinkedListPalindrome {
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


    // Brute Approach
    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static boolean isPalindromeBrute(Node head) {
        if(head == null || head.next == null) return true;

        Stack<Node> s = new Stack<>();
        Node temp = head;
        while(temp != null) {
            s.push(temp);
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(temp.data != s.pop().data) return false;
            temp = temp.next;
        }

        return true;
    }


    // Optimal Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) return true;

        Node middle = findMiddle(head);
        Node head2 = reverseList(middle);
        Node temp = head;

        while(temp != null && head2 != null) {
            if(temp.data != head2.data) return false;

            temp = temp.next;
            head2 = head2.next;
        }

        return true;
    }

    public static Node findMiddle(Node head) {
        if(head == null || head.next == null) return head;

        Node hare = head;
        Node turtle = head;
        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle;
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

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(2);
        list.addLast(2);
        list.addLast(2);
        list.addLast(1);
        list.printList();

        if(isPalindromeBrute(list.head)) {
            System.out.println("Linked List is palindromic.");
        } else {
            System.out.println("Linked List is not palindromic.");
        }

        if(isPalindrome(list.head)) {
            System.out.println("Linked List is palindromic.");
        } else {
            System.out.println("Linked List is not palindromic.");
        }
    }
}