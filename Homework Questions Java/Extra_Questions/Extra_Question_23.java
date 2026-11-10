// Que 1) Print all the subsequences of a string.

// Que 2) Print all the unique subsequences of a string.

package Extra_Questions;

import java.util.HashSet;

public class Extra_Question_23 {
    public static void printSubsequences(String str, int idx, String newString) {
        if(idx == str.length()) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx); 
        // to be
        printSubsequences(str, idx+1, newString+currChar);

        // not to be
        printSubsequences(str, idx+1, newString);
    }

    public static void printUniqueSubsequences(String str, int idx, String newString, HashSet<String> set) {
        if(idx == str.length()) {
            if(set.contains(newString)) {
                return;
            }

            System.out.println(newString);
            set.add(newString);
            return;
        }

        char currChar = str.charAt(idx);

        // to be
        printUniqueSubsequences(str, idx+1, newString+currChar, set);

        // not to be
        printUniqueSubsequences(str, idx+1, newString, set);
    }
    public static void main(String[] args) {
        String str1 = "abcd";
        printSubsequences(str1, 0, "");

        HashSet<String> set = new HashSet<String>();
        String str2 = "aaa";
        printUniqueSubsequences(str2, 0, "", set);
    }
}