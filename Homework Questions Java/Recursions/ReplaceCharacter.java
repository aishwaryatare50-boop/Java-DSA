package Recursions;

import java.util.*;

public class ReplaceCharacter {
    // helper function
    public static StringBuilder replaceCharacterHelper(StringBuilder str, char ch, char newChar, int idx) {
        if(idx == str.length()) {
            return str;
        }
        if(str.charAt(idx) == ch) {
            str.setCharAt(idx, newChar);
        }
        return replaceCharacterHelper(str, ch, newChar, idx+1);
    }
    // wrapping
    public static void replaceCharacter(String str, char ch, char newChar) {
        StringBuilder sb = new StringBuilder(str);
        System.out.println("New string is " + replaceCharacterHelper(sb, ch, newChar, 0));
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // input string
        System.out.print("Enter string : ");
        String str = sc.nextLine();
        // input character to be replaced
        System.out.print("Enter character to be replaced : ");
        char ch = sc.next().charAt(0);
        // input character inplace of ch
        System.out.print("Enter character inplace of " + ch + " : ");
        char newChar = sc.next().charAt(0);

        replaceCharacter(str, ch, newChar);

        sc.close();
    }
}
