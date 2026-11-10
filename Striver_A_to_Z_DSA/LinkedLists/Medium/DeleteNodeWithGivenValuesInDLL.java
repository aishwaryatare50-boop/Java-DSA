package Striver_A_to_Z_DSA.LinkedLists.Medium;

/*
Given a linked-list. Delete nodes with value "val".
*/

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

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
        newNode.prev = temp;
    }

    public void printDLL() {
        if(head == null) {
            System.out.println("List is empty!");
        }

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class DeleteNodeWithGivenValuesInDLL {

    public static Node deleteNodeWithValues(Node head, int val) {
        if(head == null) {
            return null;
        }

        head.next = deleteNodeWithValues(head.next, val);

        if(head.data == val) {
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in linked-list: ");
        int n = sc.nextInt();

        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println("Enter " + n + " elements: ");
        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            list.addLast(num);
        }

        System.out.print("Enter values to be deleted in linked-list: ");
        int value = sc.nextInt();

        list.head = deleteNodeWithValues(list.head, value);
        list.printDLL();

        sc.close();
    }
}