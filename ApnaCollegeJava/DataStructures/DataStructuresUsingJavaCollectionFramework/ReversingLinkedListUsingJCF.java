package DataStructures.DataStructuresUsingJavaCollectionFramework;

import java.util.LinkedList;
import java.util.Collections;

public class ReversingLinkedListUsingJCF {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        list = list.reversed();

        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);
    }
}
