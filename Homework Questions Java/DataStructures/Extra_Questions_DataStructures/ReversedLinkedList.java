// Write a program to reverse a linked list. Time and space complexity = O(n)

package DataStructures.Extra_Questions_DataStructures;

import DataStructures.LinkedLists;
import java.util.Scanner;

public class ReversedLinkedList {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();
        System.out.print("Enter size of list : ");
        int size = sc.nextInt();
        sc.nextLine();
        
        for(int i=0; i<size; i++) {
            System.out.print("Enter element : ");
            String element = sc.nextLine();
            list.addLast(element);
        }

        list.printList();
        System.out.println("Size of list is : " + list.getSize());

        LinkedLists list2 = new LinkedLists();
        for(int i=size-1; i>=0; i--) {
            list2.addLast(list.getElement(i));
        }

        list2.printList();
        System.out.println("Size of list is : " + list2.getSize());
    }
}
