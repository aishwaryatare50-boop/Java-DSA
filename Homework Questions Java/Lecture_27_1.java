// Make a Linked List & add the following elements to it : (1, 5, 7, 3 , 8, 2, 3). Search for the number 7 & display its index.

public class Lecture_27_1 {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
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
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Lecture_27_1 list = new Lecture_27_1();

        list.add(1);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(8);
        list.add(2);
        list.add(3);

        list.printList();

        boolean found = false;

        Node temp = list.head;

        int idx = 0;
        while(temp != null) {
            if(temp.data == 7) {
                System.out.println("Element found at index "+idx+".");
                found = true;
            }
            idx++;
            temp = temp.next;
        }

        if(!found) {
            System.out.println("Element not found in list!");
        }
    }
}
