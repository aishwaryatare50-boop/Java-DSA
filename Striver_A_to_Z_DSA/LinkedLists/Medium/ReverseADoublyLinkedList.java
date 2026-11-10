package Striver_A_to_Z_DSA.LinkedLists.Medium;

import java.util.Scanner;
import java.util.Stack;

class DoublyLinkedLists {
    Node head;
    Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = head;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = head;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void printDll() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class ReverseADoublyLinkedList {

    // Brute Approach
    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static void bruteApproach(Node head) {
        if(head == null || head.next == null) {
            return;
        } 

        Stack<Integer> s = new Stack<>();
        Node temp = head;
        while(temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while(temp != null || !s.isEmpty()) {
            temp.data = s.pop();
            temp = temp.next;
        }
    }


    // Optimal Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node optimalApproach(Node head) {
        if(head == null || head.next == null) {
            return null;
        } 

        Node currNode = head;
        Node prevNode = currNode.prev;
       

        while(currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            currNode.prev = nextNode;

            // updation
            prevNode = currNode;
            currNode = nextNode;
        }

        head = prevNode;
        return head;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DoublyLinkedLists dll = new DoublyLinkedLists();
        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);

        dll.printDll();

        bruteApproach(dll.head);
        dll.printDll();

        dll.head = optimalApproach(dll.head);
        dll.printDll();
        
        sc.close();
    }
}