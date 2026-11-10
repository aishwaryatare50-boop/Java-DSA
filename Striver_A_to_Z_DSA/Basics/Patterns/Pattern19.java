package Striver_A_to_Z_DSA.Basics.Patterns;

/* 
Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

**********
****  ****
***    ***
**      **
*        *
**      **
***    ***
****  ****
**********

Print the pattern.
 */

import java.util.Scanner;

public class Pattern19 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=n-i; j>=1; j--) {
                System.out.print("*");
            }

            for(int j=1; j<=2*i; j++) {
                System.out.print(" ");
            }

            for(int j=n-i; j>=1; j--) {
                System.out.print("*");
            }

            System.out.println();
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }

            for(int j=2*(n-i-1); j>=1; j--) {
                System.out.print(" ");
            }

            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}