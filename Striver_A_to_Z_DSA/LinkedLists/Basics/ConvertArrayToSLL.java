package Striver_A_to_Z_DSA.LinkedLists.Basics;

import java.util.Scanner;

public class ConvertArrayToSLL {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Node head = new Node(arr[0]);

        Node temp = head;
        for(int i=1; i<n; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }

        LinkedList list = new LinkedList();
        list.head = head;

        list.printList();

        sc.close();
    }
}