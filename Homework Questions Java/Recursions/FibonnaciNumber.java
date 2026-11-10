package Recursions;

import java.util.*;

public class FibonnaciNumber {
    public static int fibonnaciNumber(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1 ;
        }

        return fibonnaciNumber(n-1) + fibonnaciNumber(n-2);
    }

    public static void printFibonnaci(int i, int n) {
        if(i>=n) {
            return;
        }
        System.out.print(fibonnaciNumber(i) + " ");
        printFibonnaci(i+1, n);
        return;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();

        printFibonnaci(0, n);

        sc.close();
    }
}