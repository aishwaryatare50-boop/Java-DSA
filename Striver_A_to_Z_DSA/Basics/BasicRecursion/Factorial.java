package Striver_A_to_Z_DSA.Basics.BasicRecursion;

import java.util.Scanner;

public class Factorial {

    public static long factorial(int n) {
        // Time and Space Complexity = O(n)
        if(n < 0) {
            return 0;
        }

        if(n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(factorial(n));

        sc.close();
    }
}