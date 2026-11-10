package Striver_A_to_Z_DSA.Basics.BasicRecursion;

import java.util.Scanner;

public class Print1ToN {

    private static void helper(int n, int val) {
        // Time and Space Complexity = O(n)
        if(val == n) {
            System.out.print(n + " ");
            return;
        }

        System.out.print(val + " ");
        helper(n, val+1);
    }

    public static void display(int n) {
        helper(n, 1);
    }

    // print 1 to n but by backtracking
    public static void print1ToN(int n) {
        if(n <= 0) {
            return;
        }

        print1ToN(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        display(n);

        System.out.println();

        print1ToN(n);

        sc.close();
    }    
}