// WAP to implement stack using arraylist.

package Extra_Questions;

import java.util.ArrayList;

public class Extra_Question_33 {
    static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if(isEmpty()) {
                return -1;
            }

            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        public int peek() {
            if(isEmpty()) {
                return -1;
            }

            return list.get(list.size()-1);
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
