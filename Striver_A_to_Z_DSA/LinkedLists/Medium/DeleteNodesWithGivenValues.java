package Striver_A_to_Z_DSA.LinkedLists.Medium;

/*
Given a linked-list. Delete nodes with value "val".
*/

import java.util.Scanner;

public class DeleteNodesWithGivenValues {
    static class LinkedList<D> {

        Node head = null;
        private int size;

        LinkedList() {
            this.size = 0;
        }

        class Node {
            D data;
            Node next;

            Node(D data) {
                this.data = data;
                this.next = null;
                size++;
            }
        }

        // add - first
        public void addFirst(D data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        // add - last
        public  void addLast(D data) {
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

        // print list
        public void printLinkedList() {
            if(head == null) {
                System.out.println("List is empty");
                return;
            }

            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public int getSize() {
            return size;
        }

        public Node deleteNodeWithValues(Node node, D val) {
            if(node == null) {
                return null;
            }

            node.next = deleteNodeWithValues(node.next, val);

            if(node.data == val) {
                return node.next;
            }

            return node;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();

        System.out.print("Enter number of elements in linked-list: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements: ");
        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            list.addLast(num);
        }

        System.out.print("Enter values to be deleted in linked-list: ");
        int value = sc.nextInt();

        list.head = list.deleteNodeWithValues(list.head, value);
        list.printLinkedList();

        sc.close();
    }
}