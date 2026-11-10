package DataStructures;

import DataStructures.LinkedLists.*;

public class ReversingLinkedList {

    public static LinkedLists reverseIterative(LinkedLists list) {
        if(list.head == null) {
            System.out.println("List is empty.");
            return null;
        }

        if(list.head.next == null) {
            return list;
        }

        Node prevNode = list.head;
        Node currNode = list.head.next;
        while(currNode != null) {
            Node nextNode = currNode.next;
            // change reference of currNode from nextNode to prevNode
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }
        list.head.next = null;
        list.head = prevNode;

        return list;
    }

    public static Node reverseRecursive(Node head) {
        if(head == null || head.next == null) {
            return head ;
        }

        Node newNode = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return newNode;
    }
    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();

        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");

        list.printList();

        list = reverseIterative(list);
        list.printList();

        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();

        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");

        list.printList();

        list.head = reverseRecursive(list.head);
        list.printList();

    }
}
