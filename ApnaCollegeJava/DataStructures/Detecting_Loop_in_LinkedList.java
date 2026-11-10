package DataStructures;

public class Detecting_Loop_in_LinkedList {
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

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
        if(head == null ) {
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

    public Node createLoop(Node head, int n) {
        Node temp1 = head;
        Node temp2 = head;

        while(temp1.next != null) {
            temp1 = temp1.next;
        }

        for(int i=0; i<n-1; i++) {
            temp2 = temp2.next;
        }

        temp1.next = temp2;
        return head;
    }

    public boolean hasCycle(Node head) {
        if(head == null) {
            return false;
        }
        Node hare = head; // fast pointer
        Node turtle = head; // slow pointer

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle) {
                return true;
            }
        }

        return false;
    }

    public Node startingOfLoop(Node head) {
        if(head == null) {
            return head;
        }

        Node hare = head;
        Node turtle = head;

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle) {
                break;
            }
        }

        turtle = head;
        while(hare != turtle) {
            turtle = turtle.next;
            hare = hare.next;
        }

        return hare;
    }

    public Node removeLoop(Node head) {
        if(head == null) {
            return head;
        }

        Node hare = head;
        Node turtle = head;
        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if(turtle == hare) {
                break;
            }
        }

        Node prev = null;

        // CORNER CASE HANDLING: 
        // If the cycle starts at the head (slow == fast immediately),
        // the standard loop below won't execute, and 'previous' would remain null.
        if (turtle == hare) {
            // Move fast until it reaches the last node (pointing to head)
            while (hare.next != turtle) {
                hare = hare.next;
            }
            hare .next = null; // Remove cycle
            return head;
        }
        
        turtle = head;
        while(turtle != hare) {
            turtle = turtle.next;
            prev = hare;
            hare = hare.next;
        }

        prev.next = null;

        return head;
    }
    
    public static void main(String[] args) {
        Detecting_Loop_in_LinkedList list = new Detecting_Loop_in_LinkedList();
        for(int i=1; i<101; i++) {
            list.addLast(i);
        }

        list.printList();
        
        list.head = list.createLoop(list.head, 89);

        System.out.println(list.hasCycle(list.head));

        System.out.println(list.startingOfLoop(list.head).data);

        list.head = list.removeLoop(list.head);

        list.printList();
    }
}
