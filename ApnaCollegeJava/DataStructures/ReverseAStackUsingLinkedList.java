package DataStructures;

public class ReverseAStackUsingLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        Node head;

        public boolean isEmpty() {
            return head == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);

            if(isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if(isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek() {
            if(isEmpty()) {
                return -1;
            }

            return head.data;
        }

    }

    public static void pushAtBottom(Stack s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverse(Stack s) {
        if(s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverse(s);
        pushAtBottom(s, top);

    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println();

        reverse(s);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}