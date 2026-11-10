package DataStructures;

public class Is_LinkedList_palindrome {
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

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

    public void printList() {
        Node temp = head;

        if(head == null) {
            System.out.println("List is empty!");
            return;
        }

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
            Node nextNode = curr.next;

            // shift reference
            curr.next = prev;

            // update
            prev = curr;
            curr = nextNode;
        }

        head.next = null;
        head = prev;
        return head;
    }

    public Node findMiddle(Node head) { // Hare-turtle approach
        Node hare = head;
        Node turtle = head;

        while(hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle;
    }
    public boolean isPalindrome(Node head) {
        if(head == null || head.next == null) {
            return true;
        } 

        Node middle = findMiddle(head); // 1st half's end
        Node secondHalfStart = reverse(middle.next);

        Node temp = head;
        while(secondHalfStart != null) {
            if(temp.data != secondHalfStart.data) {
                return false;
            }
            temp = temp.next;
            secondHalfStart = secondHalfStart.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Is_LinkedList_palindrome list = new Is_LinkedList_palindrome();
        list.addLast("1");
        list.addLast("2");
        list.addLast("2");
        list.addLast("1");

        list.printList();

        System.out.println(list.isPalindrome(list.head));
    }
}
