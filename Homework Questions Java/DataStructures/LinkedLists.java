package DataStructures;

public class LinkedLists {

    private int size;
    
    class Node {
        String data;
        Node next; // reference to next node

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public  Node head; // reference to first node

    public LinkedLists() {
        this.size = 0;
    }

    // addFirst
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if(head == null) { // corner case
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    // addLast
    public void addLast(String data) {
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

    // addMiddle
    public void addMiddle(int index, String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        if(index == 0) {
            addFirst(data);
            return;
        }

        if(index == size-1) {
            addLast(data);
            return;
        }

        if(index >= size) {
            System.out.println("Invalid index");
            return;
        }

        Node temp = head;
        for(int i=0; i< index-1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // printList
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // get size
    public int getSize() {
        return size;
    }

    // delete-first
    public void deleteFirst() {
        if(head == null) {
            System.out.println("List is empty. Deletion not possible!");
            return;
        }
        head = head.next;
        size--;
    }

    // delete-last
    public void deleteLast() {
        // list is empty
        if(head == null) {
            System.out.println("List is empty. Deletion not possible!");
            return;
        }

        size--;

        // if list contain only 1 element
        if(head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

    }

    // delete middle
    public void deleteMiddle(int index) {
        if(index >= size || index < 0) {
            System.out.println("Invalid index!");
            return;
        }

        if(index == 0) {
            deleteFirst();
            return;
        }

        if(index == size-1) {
            deleteLast();
            return;
        }

        Node temp = head;
        size--;

        for(int i=0; i<index-1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    // get element
    public String getElement(int index) {
        if(index >= size || index < 0) {
            System.out.println("Invalid index!");
            return null;
        }

        Node temp = head;

        for(int i=0; i<index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();
        list.addFirst("is");
        list.addFirst("a");
        list.addFirst("This");

        list.printList();
        System.out.println("Size of list is : " + list.getSize());

        list.addLast("list");

        list.printList();
        System.out.println("Size of list is : " + list.getSize());

        list.addMiddle(3, "singular");
        list.printList();
        System.out.println("Size of list is : " + list.getSize());

        list.addMiddle(4, "linked");
        list.printList();
        System.out.println("Size of list is : " + list.getSize());

        list.deleteLast();
        list.printList();
        System.out.println("Size of list is : " + list.getSize());

        list.deleteFirst();
        list.printList();
        System.out.println("Size of list is : " + list.getSize());

        list.deleteMiddle(2);
        list.printList();
        System.out.println("Size of list is : " + list.getSize());

        System.out.println(list.getElement(2));
    }
}
