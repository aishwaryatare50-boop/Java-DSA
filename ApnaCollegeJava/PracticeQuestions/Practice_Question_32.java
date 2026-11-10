// Print a string in reverse.
//   "abcd" => "dcba"

// Time Complexity => O(n), here n is length of string

import java.util.*;

public class Practice_Question_32 {

    public static void reverseString(int index, String str) {
        if(index == 0) {
            System.out.print(str.charAt(index));
            return;
        }
        System.out.print(str.charAt(index));
        reverseString(index - 1, str);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string : ");
        String str = sc.nextLine();
        int index = str.length() - 1;
        
        reverseString(index, str);

        sc.close();
    }
}
