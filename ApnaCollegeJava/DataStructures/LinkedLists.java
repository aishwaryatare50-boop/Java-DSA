package DataStructures;

public class LinkedLists {
    Node head; // reference to first node
    private int size;

    LinkedLists() {
        this.size = 0;
    }

    public class Node {
        String data;
        Node next; // reference to next node

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // add - first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if(head == null) { // corner case
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // add - last
    public void addLast(String data) {
        Node newNode = new Node(data);
        if(head == null) { // corner case
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    // add-middle
    public void addMiddle(int index, String data) {
        if(index >= size || index < 0) {
            System.out.println("Invalid index!");
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

        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // print
    public void printList() {
        if(head == null) { // corner case
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("null");
    }

    // delete first
    public void deleteFirst() {
        if(head == null) {
            System.out.println("The list is empty");
            return;
        }
        head = head.next;
        size--;
    }

    // delete last
    public void deleteLast() {
        if(head == null) {
            System.out.println("The list is empty");
            return;
        }
        size--;
        if(head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next; // head.next = null -> lastNode = null
        while(lastNode.next != null) {// null.next
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null;

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

        size--;
        Node temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    public int getSize() {
        return size;
    }

    // get element
    public String getElement(int index) {
        if(index < 0 || index >= size) {
            System.out.println("Invvalid index!");
            return null;
        }

        Node temp = head;

        for(int i=0; i<index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    // reversing linkedlist using iteration
    public void reverseIterate() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        if(head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null) {
            Node nextNode = currNode.next;
            // step-1
            currNode.next = prevNode;

            //step-2)update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    // reversing recursively
    public Node reverseRecursive(Node head) {
        if(head == null || head.next == null ) { // base case
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }

    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();

        list.addFirst("a");
        list.addFirst("is");
        list.printList();

        list.addLast("list");
        list.printList();

        list.addFirst("This");
        list.printList();

        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();

        System.out.println(list.getSize());

        list.addFirst("This");
        System.out.println(list.getSize());

        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();

        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");

        list.printList();

        list.reverseIterate();
        list.printList();

        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();

        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");

        list.printList();

        list.head = list.reverseRecursive(list.head);
        list.printList();

    }
}