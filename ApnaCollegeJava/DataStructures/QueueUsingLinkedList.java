package DataStructures;

public class QueueUsingLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        Node head = null;
        Node tail = null;

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        // enqueue - O(1)
        public void add(int data) {
            Node newNode = new Node(data);
            // 1st element add
            if(tail == null) {
                tail = head = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // dequeue - O(1)
        public int remove() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            int front = head.data;
            if(head == tail) {
                tail = null;
            }
            head = head.next;

            return front;
        }

        // peek - O(1)
        public int peek() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            int front = head.data;

            return front;
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
