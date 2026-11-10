package Striver_A_to_Z_DSA.Basics.Patterns;

/* 
Given an integer N print the following pattern:

*****
****
***
**
*

here N = 5.
*/

import java.util.Scanner;

public class Pattern5 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=n-i; j>=1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}