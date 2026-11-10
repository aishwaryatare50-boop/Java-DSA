package DataStructures.DataStructuresUsingJavaCollectionFramework;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingJCF {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

        Queue<Integer> q2 = new ArrayDeque<>();

        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        q2.add(5);

        while(!q2.isEmpty()) {
            System.out.println(q2.peek());
            q2.remove();
        } 

    }
}
