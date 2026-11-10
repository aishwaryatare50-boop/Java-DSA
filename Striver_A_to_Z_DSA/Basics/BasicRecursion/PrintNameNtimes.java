package Striver_A_to_Z_DSA.Basics.BasicRecursion;

import java.util.Scanner;

public class PrintNameNtimes {

    public static void display(int n) {

        // Time and Space Complexity = O(n)
        
        if(n == 0) {
            return;
        }

        System.out.println("Hello from display!");
        display(n-1);
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        display(n);
        sc.close();
    }
}