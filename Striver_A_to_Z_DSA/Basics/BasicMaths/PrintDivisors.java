package Striver_A_to_Z_DSA.Basics.BasicMaths;

/* 
Given a number n, print all the divisors of n. A divisor of n is a number that divides n completely without leaving any remainder. 
For example, the divisors of 6 are 1, 2, 3 and 6.
*/

import java.util.Scanner;

public class PrintDivisors {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        // Approach 1: Naive Approach
        for(int i=1; i<=n; i++) {
            // Time Complexity = O(n)
            if(n % i == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        // Approach 2: Optimized Approach
        for(int i=1; i*i<=n; i++) {
            // Time Complexity = O(sqrt(n))
            if(n % i == 0) {
                System.out.print(i + " ");

                if(n / i != i) {
                    System.out.print(n / i + " ");
                }
            }
        }
    }
}