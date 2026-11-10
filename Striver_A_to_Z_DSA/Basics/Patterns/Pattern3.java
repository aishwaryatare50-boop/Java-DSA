package Striver_A_to_Z_DSA.Basics.Patterns;

/* 
Given an integer N print the following pattern:
1
12
123
1234
12345

here N = 5.
*/

import java.util.Scanner;

public class Pattern3 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}