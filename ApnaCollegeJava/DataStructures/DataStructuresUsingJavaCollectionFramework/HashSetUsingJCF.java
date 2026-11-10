package DataStructures.DataStructuresUsingJavaCollectionFramework;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetUsingJCF {
    public static void main(String[] args) {
        // Creation
        HashSet<Integer> set = new HashSet<>();

        // Insertion
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        // Search - contains
        if(set.contains(1)) {
            System.out.println("Set contains 1");
        }

        if(!set.contains(6)) {
            System.out.println("Set does not contains 6");
        }

        // Deletion - remove
        set.remove(1);
        if(!set.contains(1)) {
            System.out.println("Set does not contain 1 - we deleted 1");
        }

        // Size of set
        System.out.println("Size of set is : " + set.size());

        // Print all elements of set
        System.out.println(set);

        // Iterator
        Iterator<Integer> it = set.iterator();
        // hasNext; next;

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
