package Recursions;

// Print characters of a string one by one.

import java.util.*;

public class PrintString {
    public static void printString(String str, int idx) {
        if(idx == str.length()) {
            return;
        }

        System.out.print(str.charAt(idx) + "    ");
        printString(str, idx+1);
        return;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
        String str = sc.nextLine();

        printString(str, 0);

        sc.close();
    }
}
