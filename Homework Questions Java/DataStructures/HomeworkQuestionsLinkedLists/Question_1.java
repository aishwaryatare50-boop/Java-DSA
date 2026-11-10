/* 
Make a Linked List & add the following elements to it : (1, 5, 7, 3 , 8, 2, 3). 
Search for the number 7 & display its index.  */

package DataStructures.HomeworkQuestionsLinkedLists;

class LL_1 {

    LL_1() {
        size = 0;
    }

    private int size;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
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

    public void getData(int data) {
        boolean notFound = true;
        int index = -1;
        Node temp = head;
        while(temp != null) {
            index++;
            if(temp.data == data) {
                System.out.println("Element " + data + " found at index " + index);
                notFound = false;
            }
            temp = temp.next;
        }
        if(notFound) {
            System.out.println("Element " + data + " does not exist in above list.");
        }
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int getSize() {
         return size;
    }
}
public class Question_1 {

    public static void main(String[] args) {
        LL_1 list = new LL_1();
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(8);
        list.add(2);
        list.add(3);

        list.printList();
        System.out.println("The size of list is : " + list.getSize());
        list.getData(7);
    }
}
