package Striver_A_to_Z_DSA.Basics.Patterns;


/* 
Given an integer N print the following pattern:

*********
 *******
  *****
   ***
    *

here N = 5.
*/

import java.util.Scanner;

public class Pattern8 {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            for(int j=1; j<i; j++) {
                System.out.print(" ");
            }

            for(int j=2*(n-i)+1; j>=1; j--) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}