package Striver_A_to_Z_DSA.Basics.BasicMaths;

// Given two integers N1 and N2, find their greatest common divisor.

import java.util.Scanner;

public class GCD_HCF {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N1 = sc.nextInt();
        int N2 = sc.nextInt();

        int n = Math.min(N1, N2);
        int gcd = 0;

        // Approach 1

        for(int i=1; i<=n; i++) {
            // Time Complexity = O(min(N1, N2))
            if(N1 % i == 0 && N2 % i == 0) {
                gcd = i;
            }
        }

        System.out.println(gcd);

        // Approach 2

        for(int i=n; i>=1; i--) {
            // Time Complexity = O(min(N1, N2))
            if(N1 % i == 0 && N2 % i == 0) {
                gcd = i;
                break;
            }
        }

        System.out.println(gcd);

        // Approach 3 (Euclidean Algorithm)

        int a = N1;
        int b = N2;
        // Time Complexity = O(log(min(a, b)))
        while(a > 0 && b > 0) {
            if(a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        if(a == 0) {
            gcd = b;
        } else {
            gcd = a;
        }

        System.out.println(gcd);
    }    
}