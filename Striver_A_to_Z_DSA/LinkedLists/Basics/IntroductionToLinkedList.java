package Striver_A_to_Z_DSA.LinkedLists.Basics;

import java.util.Scanner;

public class IntroductionToLinkedList {

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

        // delete first
        public void deleteFirst() {
            if(head == null) {
                System.out.println("The list is empty");
                return;
            }

            head = head.next;
            size--;
        }

        // delete last
        public void deleteLast() {
            if(head == null) {
                System.out.println("The list is empty");
                return;
            }

            Node temp = head;
            Node temp1 = temp;

            while(temp.next != null) {
                temp1 = temp;
                temp = temp.next;
            }

            temp1.next = null;
            size--;
        }

        public int getSize() {
            return size;
        }

        // insert in middle
        public void addMiddle(D data, int index) {
            if(index >= size) {
                throw new Error("Invalid insertion index");
            }

            if(head == null) {
                throw new Error("Cannot insert in empty list");
            }

            Node newNode = new Node(data);
            Node temp = head;

            for(int i=0; i<index-1; i++) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }

        // delete in middle
        public void deleteMiddle(int index) {
            if(index >= size) {
                throw new Error("Invalid deletion index");
            }

            if(head == null) {
                throw new Error("Cannot delete empty list");
            }

            Node temp = head;
            Node temp1 = head;

            for(int i=0; i<index; i++) {
                temp1 = temp;
                temp = temp.next;
            }

            temp1.next = temp.next;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<String> ll = new LinkedList<>();

        ll.addFirst("is");
        ll.addFirst(("This"));
        ll.addLast("a");
        ll.addLast("linked");
        ll.addLast("list");
        ll.printLinkedList();

        ll.deleteFirst();
        ll.printLinkedList();

        ll.deleteLast();
        ll.printLinkedList();
        System.out.println("The length of linked list is: " + ll.getSize());

        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);
        list.addLast(3);
        list.addFirst(0);
        list.addMiddle(2, 2);
        list.printLinkedList();
        list.deleteMiddle(2);
        list.printLinkedList();

        sc.close();
    }
}