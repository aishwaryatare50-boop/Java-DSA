package Striver_A_to_Z_DSA.Basics.BasicRecursion;

import java.util.Scanner;

public class FibonnaciNumber {

    public static int fibonnaciNumber(int n) {
        // Time and Space Complexity = O(2^n) exponential time complexity
        if(n <= 1) {
            return n;
        }

        return fibonnaciNumber(n-1) + fibonnaciNumber(n-2);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibonnaciNumber(n));

        sc.close();
    }    
}