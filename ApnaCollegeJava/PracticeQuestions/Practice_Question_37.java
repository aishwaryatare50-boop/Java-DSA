/*
 *  IMPORTANT
 * Print all the subsequences of a string.
 *  "abc"
 */

// Time Complexity = O(2^n), here n is length of string

public class Practice_Question_37 {
    public static void subsequences(String str, int index, String newString) {
        if(index == str.length()) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(index);

        // to be
        subsequences(str, index+1, newString+currChar);

        // or not to be
        subsequences(str, index+1, newString);
    }
    public static void main(String args[]) {
        String str = "abc";

        subsequences(str, 0, "");
    }
}
