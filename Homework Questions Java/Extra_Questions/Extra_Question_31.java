// WAP to implement stack using linked list.

package Extra_Questions;

public class Extra_Question_31 {
    static class Stack {
        class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        Node head;

        public boolean isEmpty() {
            return head == null;
        }

        public int pop() {
            if(isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
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

        public int peek() {
            if(isEmpty()) {
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
    }
}
