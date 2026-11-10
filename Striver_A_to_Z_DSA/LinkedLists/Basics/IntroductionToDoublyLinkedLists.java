package Striver_A_to_Z_DSA.LinkedLists.Basics;

class DoublyLinkedList<D> {

    class Node {
        D data;
        Node next;
        Node prev;

        Node(D data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            size++;
        }
    }

    Node head;
    Node tail;
    private int size = 0;

    public void addFirst(D data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = head;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void addLast1(D data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = head;
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
        tail = newNode;
    }

    public void addLast2(D data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = head;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printListReverse() {
        Node temp = tail;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }

        System.out.println("null");
    }

    public void deleteFirst() {
        if(head == null) {
            System.out.println("Liinked List is empty!");
            return;
        }

        size--;
        head = head.next;
        head.prev = null;
    }

    public void deleteLast1() {
        if(head == null) {
            System.out.println("Liinked List is empty!");
            return;
        }

        size--;
        tail = tail.prev;
        tail.next = null;
    }

    public void deleteLast2() {
        if(head == null) {
            System.out.println("Liinked List is empty!");
            return;
        }

        size--;
        Node temp1 = head;
        Node temp2 = head;

        while(temp1.next != null) {
            temp2 = temp1;
            temp1 = temp1.next;
        }

        tail = temp2;
        temp2.next = null;
    }

    public void insertMiddle(D data, int index) {
        if(index >= size || index < 0) {
            throw new Error("Invalid index for insertion");
        }

        if(index == 0) {
            addFirst(data);
            return;
        }

        if(index == size - 1) {
            addLast2(data);
            return ;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for(int i=0; i<index; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void deleteMiddle(int index) {
        if(index >= size || index < 0) {
            throw new Error("Invalid index for deletion");
        }

        if(index == 0) {
            deleteFirst();
            return;
        }

        if(index == size - 1) {
            deleteLast2();
            return ;
        }

        Node temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }
}

public class IntroductionToDoublyLinkedLists {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.addLast1(5);
        dll.addLast2(6);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addFirst(7);

        dll.printList();
        dll.printListReverse();

        dll.deleteLast1();
        dll.printList();

        dll.deleteFirst();
        dll.printList();

        dll.deleteLast2();
        dll.printList();

        dll.insertMiddle(5, 3);
        dll.insertMiddle(0, 0);
        dll.printList();

        dll.deleteMiddle(4);
        dll.printList();
    }
}