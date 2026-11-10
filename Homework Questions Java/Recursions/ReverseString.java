package Recursions;

// Print reverse of a string

import java.util.*;

public class ReverseString {

    public static void reverseString(String str, int idx) {
        if(idx < 0) {
            return;
        }

        System.out.print(str.charAt(idx));
        reverseString(str, idx-1);

        return;
    }

    // or we can also code
    public static String reverse_String(String str, int idx) {
        if(idx < 0) {
            return "";
        }

        return str.charAt(idx) + reverse_String(str, idx-1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
        String str = sc.nextLine();

        reverseString(str, str.length()-1);

        System.out.println();

        System.out.println("Reverse of " + str + " is : " + reverse_String(str, str.length()-1));

        sc.close();
    }
}
