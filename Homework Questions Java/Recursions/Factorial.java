package Recursions;

import java.util.*;

public class Factorial {

    public static long factorial(long n) {
        if(n == 0 || n == 1) return 1;
        return n * factorial(n-1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        long n = sc.nextLong();
        System.out.println("Factorial of " + n + " is : " + factorial(n));

        sc.close();
    }
}
