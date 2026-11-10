package Striver_A_to_Z_DSA.Basics.Patterns;

/* 
Given an integer N print the following pattern:
1
22
333
4444
55555

here N = 5.
*/

import java.util.Scanner;

public class Pattern4 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}