package DataStructures.DataStructuresUsingJavaCollectionFramework;

import java.util.ArrayList; // we are not importing java.util.* as it will consume more memory
import java.util.Collections;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // add elements
        list.add(0);
        list.add(2);
        list.add(3);

        System.out.println(list);

        // get elements
        int element = list.get(0);
        System.out.println(element);

        // add element in between
        list.add(1,1);
        System.out.println(list);

        // set element
        list.set(0, 5);
        System.out.println(list);

        // delete element
        list.remove(3);
        System.out.println(list);

        // size of ArrayList
        int size = list.size();
        System.out.println(size);

        // loops
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // sorting
        // ascending order
        Collections.sort(list);
        System.out.println(list);
        // descending order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // reverse 
        Collections.reverse(list);
        System.out.println(list);
    }
}
