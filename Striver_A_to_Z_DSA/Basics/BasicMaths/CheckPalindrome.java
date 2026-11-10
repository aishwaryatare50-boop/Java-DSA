package Striver_A_to_Z_DSA.Basics.BasicMaths;

/* 
Given a number n check if n is palindrome or not. A number n is palindrome if it is same as its reverse.
*/
import java.util.Scanner;

public class CheckPalindrome {
    static Scanner sc = new Scanner(System.in);

    public static int reverseNum(int n) {
        int revNum = 0;

        while(n != 0) {
            int digit = n % 10;

            revNum = revNum*10 + digit;
            n /= 10;
        }

        return revNum;
    }
    
    public static void main(String[] args) {
        int n = sc.nextInt();

        if(n == reverseNum(n)) {
            System.out.println(n + " is a palindrome.");
        } else {
            System.out.println(n + " is not a palindrome.");
        }
    }
}