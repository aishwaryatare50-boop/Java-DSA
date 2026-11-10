package Striver_A_to_Z_DSA.Basics.BasicRecursion;

import java.util.Scanner;

public class PrintNto1 {

    public static void printN(int n) {
        // Time and Space Complexity = O(n)
        if(n == 0) {
            return;
        }
        System.out.print(n + " ");
        printN(n-1);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printN(n);

        sc.close();
    }
}