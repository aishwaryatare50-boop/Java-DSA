package Striver_A_to_Z_DSA.Basics.BasicMaths;

/* Given an integer number n. Print the number of digits in it. 
   Also find the sum of digits in number.
*/

import java.util.Scanner;

public class Digits {
    static Scanner sc = new Scanner(System.in);

    public static int sumOfDigits(int n) {
        int sum = 0;
        while(n != 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }

        return sum;
    }

    public static int countDigitsBasicApproach(int n) {
        // Time Complexity = O(log10(n))
        int count = 0;
        while(n != 0) {
            count++;
            n /= 10;
        }

        return count;
    }

    public static int countDigitsOptimalApproach(int n) {
        // Time Complexity = O(1)
        int count = (int)Math.log10(n) + 1;

        return count;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        System.out.println("Sum of digits of " + n + " is = " + sumOfDigits(n));
        System.out.println("Count of digits in " + n + " is = " + countDigitsBasicApproach(n));
        System.out.println("Count of digits in " + n + " is = " + countDigitsOptimalApproach(n));
    }
}