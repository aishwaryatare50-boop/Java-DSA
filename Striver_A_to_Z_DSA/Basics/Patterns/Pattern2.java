package Striver_A_to_Z_DSA.Basics.Patterns;

/* 
Given an integer N, print the following pattern : 

*
**
***
****
*****

Here, N = 5.
 */

import java.util.Scanner;

public class Pattern2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}