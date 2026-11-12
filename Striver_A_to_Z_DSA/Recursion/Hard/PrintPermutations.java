package Striver_A_to_Z_DSA.Recursion.Hard;

public class PrintPermutations {

    // Time Complexity = O(n!) where n is the length of the string (only for generating permutations)
    // (O(n * n!)) for creating and printing permutation
    // Space Complexity = O(n) // recursion stack space
    public static void printPermutations(String str, StringBuilder permutation) {
        if(str.length() == 0) {
            System.out.println(permutation);
            return;
        }

        int n = str.length();
        for(int i=0; i<n; i++) {
            char currentChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);

            printPermutations(newStr, permutation.append(currentChar));
            permutation.deleteCharAt(permutation.length() - 1);
        }

    }

    public static void main(String[] args) {
        printPermutations("abcdefgh", new StringBuilder(""));
    }
}