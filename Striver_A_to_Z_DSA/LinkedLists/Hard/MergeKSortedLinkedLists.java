package Striver_A_to_Z_DSA.LinkedLists.Hard;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

public class MergeKSortedLinkedLists {

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
    // Time Complexity = O(N*M(Log(N*M)))
    // Space Complexity = O(N*M)
    public static Node bruteApproach(ArrayList<LinkedList> lists) {
        ArrayList<Node> nodeList = new ArrayList<>();
        for(LinkedList list : lists) {
            Node temp = list.head;
            while(temp != null) {
                nodeList.add(temp);
                temp = temp.next;
            }
        }

        Collections.sort(nodeList, (a, b) -> Integer.compare(a.data, b.data));

        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        for(Node node : nodeList) {
            temp.next = node;
            temp = temp.next;
        }
        temp.next = null;

        return dummyNode.next;
    }


    // Better Approach
    // Time Complexity = O(N * (N * M))
    // Space Complexity = O(1)
    
    public static Node mergeTwoSortedLinkedLists(Node head1, Node head2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != null && temp2 != null) {
            if(temp1.data < temp2.data) {
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }

        if(temp1 != null) {
            temp.next = temp1;
        }

        if(temp2 != null) {
            temp.next = temp2;
        }

        return dummyNode.next;
    }


    public static Node betterApproach(ArrayList<LinkedList> lists) {
        int n = lists.size();
        if(n == 0) return null;

        Node head = lists.get(0).head;
        if(n == 1) {
            return head;
        }

        for(int i=1; i<n; i++) {
            head = mergeTwoSortedLinkedLists(head, lists.get(i).head);
        }

        return head;
    }

    // Optimal Approach
    // Time Complexity = O((N * M)log N)
    // Space Complexity = O(N)
    public static Node optimalApproach(ArrayList<LinkedList> lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.data, b.data));
        for(LinkedList list : lists) {
            if(list.head != null) pq.add(list.head);
        }

        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while(!pq.isEmpty()) {
            Node head = pq.remove();
            if(head.next != null) {
                pq.add(head.next);
            }
            temp.next = head;
            temp = temp.next;
        }
        temp.next = null;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);
        list1.addLast(9);
        list1.addLast(10);
        list1.printList();

        LinkedList list2 = new LinkedList();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(7);
        list2.addLast(8);
        list2.addLast(9);
        list2.addLast(10);
        list2.printList();

        LinkedList list3 = new LinkedList();
        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(3);
        list3.addLast(4);
        list3.addLast(5);
        list3.addLast(6);
        list3.addLast(7);
        list3.addLast(8);
        list3.addLast(9);
        list3.addLast(10);
        list3.printList();

        LinkedList list4 = new LinkedList();
        list4.addLast(1);
        list4.addLast(2);
        list4.addLast(3);
        list4.addLast(4);
        list4.addLast(5);
        list4.addLast(6);
        list4.addLast(7);
        list4.addLast(8);
        list4.addLast(9);
        list4.addLast(10);
        list4.printList();

        LinkedList list5 = new LinkedList();
        list5.addLast(1);
        list5.addLast(2);
        list5.addLast(3);
        list5.addLast(4);
        list5.addLast(5);
        list5.addLast(6);
        list5.addLast(7);
        list5.addLast(8);
        list5.addLast(9);
        list5.addLast(10);
        list5.printList();

        // Brute Approach
        ArrayList<LinkedList> lists = new ArrayList<>(List.of(list1, list2, list3, list4, list5));
        LinkedList sortedList = new LinkedList();
        sortedList.head = bruteApproach(lists);
        sortedList.printList();


        // Better Approach

        list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);
        list1.addLast(9);
        list1.addLast(10);
        list1.printList();

        list2 = new LinkedList();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(7);
        list2.addLast(8);
        list2.addLast(9);
        list2.addLast(10);
        list2.printList();

        list3 = new LinkedList();
        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(3);
        list3.addLast(4);
        list3.addLast(5);
        list3.addLast(6);
        list3.addLast(7);
        list3.addLast(8);
        list3.addLast(9);
        list3.addLast(10);
        list3.printList();

        list4 = new LinkedList();
        list4.addLast(1);
        list4.addLast(2);
        list4.addLast(3);
        list4.addLast(4);
        list4.addLast(5);
        list4.addLast(6);
        list4.addLast(7);
        list4.addLast(8);
        list4.addLast(9);
        list4.addLast(10);
        list4.printList();

        list5 = new LinkedList();
        list5.addLast(1);
        list5.addLast(2);
        list5.addLast(3);
        list5.addLast(4);
        list5.addLast(5);
        list5.addLast(6);
        list5.addLast(7);
        list5.addLast(8);
        list5.addLast(9);
        list5.addLast(10);
        list5.printList();

        // Better Approach - Iterative
        lists = new ArrayList<>(List.of(list1, list2, list3, list4, list5));
        sortedList = new LinkedList();
        sortedList.head = betterApproach(lists);
        sortedList.printList();

        // Optimal Approach

        list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);
        list1.addLast(9);
        list1.addLast(10);
        list1.printList();

        list2 = new LinkedList();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(7);
        list2.addLast(8);
        list2.addLast(9);
        list2.addLast(10);
        list2.printList();

        list3 = new LinkedList();
        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(3);
        list3.addLast(4);
        list3.addLast(5);
        list3.addLast(6);
        list3.addLast(7);
        list3.addLast(8);
        list3.addLast(9);
        list3.addLast(10);
        list3.printList();

        list4 = new LinkedList();
        list4.addLast(1);
        list4.addLast(2);
        list4.addLast(3);
        list4.addLast(4);
        list4.addLast(5);
        list4.addLast(6);
        list4.addLast(7);
        list4.addLast(8);
        list4.addLast(9);
        list4.addLast(10);
        list4.printList();

        list5 = new LinkedList();
        list5.addLast(1);
        list5.addLast(2);
        list5.addLast(3);
        list5.addLast(4);
        list5.addLast(5);
        list5.addLast(6);
        list5.addLast(7);
        list5.addLast(8);
        list5.addLast(9);
        list5.addLast(10);
        list5.printList();

        // Optimal Approach
        lists = new ArrayList<>(List.of(list1, list2, list3, list4, list5));
        sortedList = new LinkedList();
        sortedList.head = optimalApproach(lists);
        sortedList.printList();
    }
}