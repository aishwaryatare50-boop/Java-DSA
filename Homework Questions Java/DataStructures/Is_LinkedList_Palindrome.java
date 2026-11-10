package DataStructures;

public class Is_LinkedList_Palindrome {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void addLast(int data) {
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
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public Node reverse(Node head) {
        Node prev = head;
        Node curr = head.next;
        while(curr != null) {
            Node next = curr.next;
            // change reference
            curr.next = prev;

            //update
            prev = curr;
            curr = next;
        }
        head.next = null;
        head = prev;
        return head;
    }

    // Hare turtle approach
    public Node findMiddle(Node head) {
        Node hare = head;
        Node turtle = head;
        
        while(hare.next != null && hare.next.next != null) {
            hare = hare.next.next; // two steps
            turtle = turtle.next;
        }

        return turtle;
    }

    public boolean isPalindrome(Node head) {
        if(head == null || head.next == null) {
            return true;
        }

        Node middle = findMiddle(head);
        Node newNode = reverse(middle.next);

        Node temp = head;
        while(newNode != null) {
            if(temp.data != newNode.data) {
                return false;
            }
            temp = temp.next;
            newNode = newNode.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Is_LinkedList_Palindrome list = new Is_LinkedList_Palindrome();
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(1);

        list.printList();

        System.out.println(list.isPalindrome(list.head));
    }
}
