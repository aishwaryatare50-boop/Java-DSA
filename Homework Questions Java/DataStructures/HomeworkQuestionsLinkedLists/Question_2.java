/* Take elements(numbers in the range of 1-50) of a Linked List as input 
from the user. Delete all nodes which have values greater than 25. */

package DataStructures.HomeworkQuestionsLinkedLists;

import java.util.Scanner;

class LL_2 {
    private int size;

    LL_2() {
        size = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public int getSize() {
        return size;
    }

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
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print( temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void deleteElement(int index) {
        if(index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }

        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        if(index == 0) {
            head = head.next;
            size--;
            return;
        }

        if(index == size-1) {
            Node temp = head;
            while(temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            size--;
            return;
        }

        Node temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public int getElement(int index) {
        if(index > size-1 || index < 0) {
            return 0;
        }
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

}

public class Question_2 {
    public static Scanner sc = new Scanner(System.in);

    public static LL_2 deleteGreaterThan25(LL_2 list, int index) {
        if(index >= list.getSize()) {
            return list;
        }

        int value = list.getElement(index);

        if(value > 25) {
            list.deleteElement(index);
            deleteGreaterThan25(list, index);
        } else {
            deleteGreaterThan25(list, index+1);
        }

        return list;
    }
    public static void main(String[] args) {
        LL_2 list = new LL_2();
        int n = -1;
        System.out.println("==================Enter elements between 1 and 50==================\nEnter 0 to exit.\n");
        while(true) {    
            System.out.print("Enter element : ");
            n = sc.nextInt();

            if(n == 0) {
                break;
            }

            if(n >= 1 && n <= 50) {
                list.add(n);
            } else {
                System.out.println("Enter valid element.");
            }           
        }

        list.printList();
        System.out.println("The size of list is : " + list.getSize());

        list = deleteGreaterThan25(list,0);
        list.printList();
        System.out.println("The size of list is : " + list.getSize());
        
    }
}
