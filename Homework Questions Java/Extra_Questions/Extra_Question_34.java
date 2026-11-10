// WAP to implement queue using 2 stacks

package Extra_Questions;

import java.util.Stack;

public class Extra_Question_34 {
    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        public void add(int data) {
            s1.push(data);
        }

        public int remove() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int front = s2.pop();

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return front;
        }

        public int peek() {
            
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int front = s2.peek();

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }

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
