package Striver_A_to_Z_DSA.LinkedLists.Hard;

import java.util.HashMap;

public class CloneALinkedListWithARandomPointer {

    private static class Node {
        int data;
        Node next;
        Node random;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    public static void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Brute Approach
    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static Node bruteApproach(Node head) {
        Node temp = head;
        HashMap<Node, Node> map = new HashMap<>();
        while(temp != null) {
            Node node = new Node(temp.data);
            map.put(temp, node);
            temp = temp.next;
        }

        Node dummyNode = new Node(-1);
        Node temp1 = dummyNode;
        temp = head;
        while(temp != null) {
            Node node = map.get(temp);
            node.next = map.get(temp.next);
            node.random = map.get(temp.random);
            temp1.next = node;
            temp1 = temp1.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }


    // Optimal Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static Node cloneList(Node head) {
        if(head == null) return head;

        insertCloneInMiddle(head);
        connectRandom(head);

        Node newNode = separateList(head);

        return newNode;
    }

    public static void insertCloneInMiddle(Node head) {
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
    }

    public static void connectRandom(Node head) {
        Node temp = head;
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
    }

    public static Node separateList(Node head) {
        Node dummyNode = new Node(-1);
        Node temp1 = dummyNode;
        Node temp2 = head;
        while(temp2 != null) {
            temp1.next = temp2.next;
            temp2.next = temp2.next.next;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);

        Node n1 = new Node(7);
        head.next = n1;

        Node n2 = new Node(11);
        n1.next = n2;

        Node n3 = new Node(15);
        n2.next = n3;

        Node n4 = new Node(5);
        n3.next = n4;

        Node n5 = new Node(9);
        n4.next = n5;

        n1.random = n3;
        n2.random = head;
        n3.random = n5;
        n4.random = n1;
        n5.random = n2;

        printList(head);

        // brute approach
        Node newHead = bruteApproach(head);
        printList(newHead);

        // optimal approach
        newHead = cloneList(head);
        printList(newHead);
    }
}