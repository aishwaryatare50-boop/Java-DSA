package Recursions;

import java.util.*;

public class CheckPalindrome {
    public static boolean checkPalindrome(String str, int idx) {
        if(idx >= str.length()/2) {
            return true;
        }

        if(str.charAt(idx) == str.charAt(str.length()-1-idx)) {
            return checkPalindrome(str, idx+1);
        } else {
            return false;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String str = sc.nextLine();

        System.out.println(checkPalindrome(str, 0));

        sc.close();
    }
}
