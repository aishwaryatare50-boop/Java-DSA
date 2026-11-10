package Striver_A_to_Z_DSA.LinkedLists.Basics;

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

public class ConvertArrayToDll {

    public static void printDll(Node head) {
        if(head == null) {
            System.out.println("List is Empty!");
            return;
        }

        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void printDllReverse(Node tail) {
        if(tail == null) {
            System.out.println("List is Empty!");
            return;
        }

        while(tail != null) {
            System.out.print(tail.data + " -> ");
            tail = tail.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Node head = new Node(arr[0]);
        Node tail = head;

        // method 1 - using tail pointer
        for(int i=1; i<n; i++) {
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        printDll(head);
        printDllReverse(tail);

        // method 2 - using head pointer
        head = new Node(arr[0]);
        tail = head;
        
        Node temp = head;
        for(int i=1; i<n; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
            tail = newNode;
        }

        printDll(head);
        printDllReverse(tail);

        sc.close();
    }
}