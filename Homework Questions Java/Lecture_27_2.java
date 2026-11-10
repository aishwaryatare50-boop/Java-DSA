// Take elements(numbers in the range of 1-50) of a Linked List as input from the user. Delete all nodes which have values greater than 25.

import java.util.Scanner;

public class Lecture_27_2 {
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        static class LinkedList {
            Node head;

            public void add(int data) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList list = new LinkedList();

        System.out.println("=================Enter elements (elements should be between 1-50)=================");

        int counter = 0;
        while(true) {
            System.out.print("Enter element : ");
            int n = sc.nextInt();

            if(n >= 1 && n <= 50) {
                list.add(n);
            } else {
                System.out.println("Enter valid element!");
                continue;
            }

            counter++;
            if(counter % 10 == 0) {
                System.out.print("Do you want to continue adding elements : ");
                String input = sc.next();
                if(input.equals("No") || input.equals("NO") || input.equals("no")) {
                    break;
                }
            }
            
        }

        System.out.println("List entered by user : ");
        list.printList();

        Node temp = list.head;
        Node prevNode = null;

        while(temp != null) {
            if(temp.data > 25) {
                if(temp == list.head) { // deleting head
                    list.head = list.head.next;
                    temp = list.head;
                } else {
                    prevNode.next = temp.next;
                    temp = temp.next;
                }
            } else {
                prevNode = temp;
                temp = temp.next;
            }
            
        }

        System.out.println("List after deleting elements greater than 25 : ");

        list.printList();

        sc.close();
    }
}
