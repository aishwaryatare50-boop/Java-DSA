package Striver_A_to_Z_DSA.LinkedLists.Medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllPairsWithGivenSumInSortedDLL {
    
    private static class Node {
        int data;
        Node next;
        @SuppressWarnings("unused") Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private static class DoublyLinkedList {
        Node head;

        public void addFirst(int data) {
            Node newNode = new Node(data);

            if(head == null) {
                head = newNode;
                return;
            }

            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }  

        public void printList() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " <--> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }


    // Brute Approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1)
    public static ArrayList<ArrayList<Integer>> bruteApproach(Node head, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Node temp1 = head;
        while(temp1 != null) {
            Node temp2 = temp1.next;
            while(temp2 != null && temp1.data + temp2.data <= target) {
                if(temp1.data + temp2.data == target) {
                    ans.add(new ArrayList<>(List.of(temp1.data, temp2.data)));
                }
                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        return ans;
    } 


    // Optimal Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static ArrayList<ArrayList<Integer>> optimalApproach(Node head, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node left = head;
        Node temp = head;
        Node right = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        right = temp;
        while(left.data < right.data) {
            if(left.data + right.data == target) {
                ans.add(new ArrayList<>(List.of(left.data, right.data)));
                left = left.next;
                right = right.prev;
            } else if(left.data + right.data > target) {
                right = right.prev;
            } else {
                left = left.next;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addFirst(10);
        dll.addFirst(9);
        dll.addFirst(8);
        dll.addFirst(7);
        dll.addFirst(6);
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        dll.printList();

        // brute approach
        System.out.println(bruteApproach(dll.head, 6));

        // optimal approach
        System.out.println(optimalApproach(dll.head, 6));
    }
}