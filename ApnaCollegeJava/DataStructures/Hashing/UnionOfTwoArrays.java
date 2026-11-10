package DataStructures.Hashing;

import java.util.HashSet;

public class UnionOfTwoArrays {
    public static void main(String[] args) { //O(n)
        HashSet<Integer> set = new HashSet<>();

        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};

        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Size of set : " + set.size());
        System.out.println(set);
    }
}
