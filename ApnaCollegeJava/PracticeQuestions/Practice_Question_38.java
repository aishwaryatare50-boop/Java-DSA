// Print all the unique subsequences of a string.
// "aaa"

import java.util.*;

public class Practice_Question_38 {
    public static void subsequences(String str, int index, String newString, HashSet<String> set) {
        if(index == str.length()) {
            if(set.contains(newString)) {
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }

        char currChar = str.charAt(index);

        // to be
        subsequences(str, index+1, newString+currChar, set);

        // not to be
        subsequences(str, index+1, newString, set);
    }
    public static void main(String args[]) {
        String str = "aaa";
        HashSet<String> set = new HashSet<>();

        subsequences(str, 0, "", set);

        // int a,b,c,d;
        // a = b = c = d = 10;
    }
}