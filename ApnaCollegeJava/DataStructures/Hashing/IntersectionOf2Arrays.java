package DataStructures.Hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOf2Arrays {
    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();

        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++) {
            if(set.contains(arr2[i])) {
                ans.add(arr2[i]);
                set.remove(arr2[i]);
            }
        }

        System.out.println("Size of intersection : " + ans.size());
        System.out.println(ans);
    }
}
