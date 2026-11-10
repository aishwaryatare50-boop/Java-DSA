package Striver_A_to_Z_DSA.Basics.Patterns;

/* 
Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

*****
*****
*****
*****
*****

Print the pattern in the function given to you.
 */

import java.util.Scanner;

public class Pattern1 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}