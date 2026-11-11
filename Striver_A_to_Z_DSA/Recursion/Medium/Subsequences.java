package Striver_A_to_Z_DSA.Recursion.Medium;

import java.util.HashSet;

public class Subsequences {

    // Time Complexity = O(2^n)
    // Space Complexity = O(n) // recursion stack space
    public static void subsequences(String str, int index, StringBuilder newString) {
        if(index == str.length()) {
            System.out.println(newString);
            return;
        }

        char ch = str.charAt(index);

        // to be
        subsequences(str, index + 1, newString.append(ch));

        // not to be
        newString.deleteCharAt(newString.length() - 1);
        subsequences(str, index + 1, newString);
    }


    // Time Complexity = O(2^n)
    // Space Complexity = O(n * 2^n)// HashSet + O(n) // recursion stack space
    public static void uniqueSubsequences(String str, int index, StringBuilder newString, HashSet<String> set) {
        if(index == str.length()) {
            if(set.contains(newString.toString())) {
                return;
            } else {
                set.add(newString.toString());
                System.out.println(newString);
                
                return;
            }
        }


        char ch = str.charAt(index);

        // to be
        uniqueSubsequences(str, index + 1, newString.append(ch), set);

        // not to be
        newString.deleteCharAt(newString.length() - 1);
        uniqueSubsequences(str, index + 1, newString, set);
    }

    public static void main(String[] args) {
        // print all subsequences
        subsequences("abc", 0, new StringBuilder());

        // prints unique subsequences
        uniqueSubsequences("rabbbit", 0, new StringBuilder(), new HashSet<String>());
    }    
}