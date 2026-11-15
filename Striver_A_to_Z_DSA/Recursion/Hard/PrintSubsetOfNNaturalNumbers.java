// Print all the subsets of a set of first N natural numbers.

package Striver_A_to_Z_DSA.Recursion.Hard;

import java.util.ArrayList;

public class PrintSubsetOfNNaturalNumbers {

    // Time Complexity = O(2 ^ n)
    // Space Complexity = O(n) // recursion stack space
    public static void printSubset(int n, ArrayList<Integer> subset) {
        if(n == 0) {
            System.out.println(subset);
            return;
        }

        // to be
        subset.add(n);
        printSubset(n - 1, subset);

        // not to be
        subset.remove(subset.size() - 1);
        printSubset(n - 1, subset);
    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<Integer> subset = new ArrayList<>();
        printSubset(n, subset);
    }    
}