package Striver_A_to_Z_DSA.Basics.Patterns;

/* 
Given an integer N print the following pattern:
12345
1234
123
12
1

here N = 5.
*/

import java.util.Scanner;

public class Pattern6 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}