// WAP to implement queue using linked list.

package Extra_Questions;

public class Extra_Question_37 {
    static class Queue {
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        Node head = null;
        Node tail = null;

        public boolean isEmpty() {
            return head == null;
        }

        public void add(int data) {
            Node newNode = new Node(data);

            if(head == null) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public int remove() {
            if(isEmpty()) {
                System.out.println("Empty Queue !");
                return -1;
            }

            int front = head.data;
            head = head.next;

            if(head == null) {
                tail = null;
            }

            return front;
        }

        public int peek() {
            if(isEmpty()) {
                System.out.println("Empty Queue !");
                return -1;
            }

            return head.data;
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
