package DataStructures;

public class QueueUsingArrays {
    static class Queue {
        int[] arr;
        int size;
        int rear = -1;

        Queue(int size) {
            arr = new int[size];
            this.size = size;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        //enqueue O(1)
        public void add(int data) {
            if(rear == size-1) {
                System.out.println("Full queue!");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        //dequeue -O(n)
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }

            int front = arr[0];
            for(int i=0; i<rear; i++) {
                arr[i] = arr[i+1];
            }

            rear--;

            return front;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }

            int front = arr[0];
            return front;
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
