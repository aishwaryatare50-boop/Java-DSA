package Striver_A_to_Z_DSA.LinkedLists.Medium;

import Striver_A_to_Z_DSA.LinkedLists.Medium.DeleteNodesWithGivenValues.LinkedList;
import java.util.Scanner;

public class ReverseASinglyLinkedList {

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static LinkedList<Integer>.Node reverseLinkedListIterative(LinkedList<Integer>.Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        LinkedList<Integer>.Node prevNode = head;
        LinkedList<Integer>.Node currNode = head.next;

        while(currNode != null) {
            LinkedList<Integer>.Node nextNode = currNode.next;
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;

        return head;
    } 

    // Time Complexity = O(N)
    // Space Complexity = O(1) // O(N) for recursion stack
    public static LinkedList<Integer>.Node reverseLinkedListRecursive(LinkedList<Integer>.Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        LinkedList<Integer>.Node newHead = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();
        System.out.print("Enter number of elements in linked list: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int val = sc.nextInt();
            list.addLast(val);
        }
        
        list.printLinkedList();

        LinkedList<Integer>.Node head = list.head;

        // Iterative Approach
        list.head = reverseLinkedListIterative(head);
        list.printLinkedList();

        // Recursive Approach
        list.head = reverseLinkedListRecursive(head);
        list.printLinkedList();

        sc.close();
    }
}