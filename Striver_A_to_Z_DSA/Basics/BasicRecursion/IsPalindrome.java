package Striver_A_to_Z_DSA.Basics.BasicRecursion;

import java.util.Scanner;

public class IsPalindrome {

    public static boolean helper(String str, int idx) {
        if(idx == str.length() / 2) {
            return true;
        }

        int n = str.length();
        if(str.charAt(idx) != str.charAt(n - idx - 1)) {
            return false;
        }

        return helper(str, idx+1);
    }

    public static boolean isPalindrome(String str) {
        return helper(str, 0);    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if(isPalindrome(str)) {
            System.out.println(str + " is palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }

        sc.close();
    }
}