package Recursions;

// Power function(x^n)

import java.util.*;

public class Power {
    public static int power(int x, int n) {
        if(x == 0) {
            return 0;
        }
        // base case
        if(n == 0) {
            return 1;
        }

        return x*power(x, n-1);
    }

    // or we can also code
    public static int pow(int x, int n) {
        if(x == 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }

        // even power
        if(n % 2 == 0) {
            int half = power(x, n/2);
            return half * half;
        }

        // if n is odd
        return x * pow(x, n-1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base : ");
        int x = sc.nextInt();
        System.out.print("Enter power : ");
        int n = sc.nextInt();

        System.out.println(x + " raised to the power " + n + " is : " + power(x, n));

        System.out.println(x + " raised to the power " + n + " is : " + pow(x, n));

        sc.close();
    }
}