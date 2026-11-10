package Striver_A_to_Z_DSA.Basics.Patterns;

/* 
Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
1
0 1
1 0 1
0 1 0 1
1 0 1 0 1

Print the pattern.
 */

import java.util.Scanner;

public class Pattern11 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = -1;

        for(int i=1; i<=n; i++) {
            if(i % 2 == 0) {
                m = 0;
            } else {
                m = 1;
            }

            for(int j=0; j<i; j++) {
                System.out.print(m + " ");
                if(m == 1) {
                    m = 0;
                } else {
                    m = 1;
                }
            }

            System.out.println();
        }
    }
}