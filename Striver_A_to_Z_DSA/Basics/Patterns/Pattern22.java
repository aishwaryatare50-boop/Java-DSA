package Striver_A_to_Z_DSA.Basics.Patterns;

/* 
Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

4 4 4 4 4 4 4
4 3 3 3 3 3 4
4 3 2 2 2 3 4
4 3 2 1 2 3 4
4 3 2 2 2 3 4
4 3 3 3 3 3 4
4 4 4 4 4 4 4

Print the pattern.
 */

import java.util.Scanner;

public class Pattern22 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int i=0; i<2*n-1; i++) {
            for(int j=0; j<2*n-1; j++) {
                int topDist = i;
                int lefttDist = j;
                int bottomDist = (2*n-1) - 1 - i;
                int rightDist = (2*n-1) - 1 - j;

                int digit = n - Math.min(Math.min(rightDist, lefttDist), Math.min(bottomDist, topDist));
                System.out.print(digit + " ");
            }

            System.out.println();
        }
    }
}