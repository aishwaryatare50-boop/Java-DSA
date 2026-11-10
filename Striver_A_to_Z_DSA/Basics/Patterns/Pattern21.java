package Striver_A_to_Z_DSA.Basics.Patterns;

/* 
Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

****
*  *
*  *
****

Print the pattern.
 */

import java.util.Scanner;

public class Pattern21 {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 || i == n-1 || j == 0 || j == n-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}