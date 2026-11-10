package DataStructures;

public class CircularQueueUsingArrays {
    static class CircularQueue {
        int[] arr;
        int size;
        int rear = -1;
        int front = -1;

        CircularQueue(int size) {
            arr = new int[size];
            this.size = size;
        }

        // is empty
        public boolean isEmpty() {
            return front== -1 && rear == -1;
        }

        // is full
        public boolean isFull() {
            return (rear+1) % size == front;
        }

        // enqueue - O(1)
        public void add(int data) {
            if(isFull()) {
                System.out.println("Queue is full!");
                return;
            }

            // 1st element add
            if(front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // dequeue - O(1)
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty !");
                return -1;
            }

            int result = arr[front];
            // single element condition
            if(rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        // peek - O(1)
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(q.remove());
        q.add(6);
        System.out.println(q.remove());
        q.add(7);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }

}
