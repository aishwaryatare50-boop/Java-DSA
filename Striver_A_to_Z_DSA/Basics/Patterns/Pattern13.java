package Striver_A_to_Z_DSA.Basics.Patterns;

/* 
Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

1
2 3
4 5 6
7 8 9 10
11 12 13 14 15

Print the pattern.
 */


import java.util.Scanner;

public class Pattern13 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = 1;

        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print(m + " ");
                m++;
            }
            System.out.println();
        }
    }
}