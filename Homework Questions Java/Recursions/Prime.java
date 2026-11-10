package Recursions;

import java.util.*;

public class Prime {
    
    // helper function 
    public static boolean isPrimeHelper(int n, int i) {
        if(n <= 1) return false;
        
        if(i > Math.sqrt(n)) {
            return true;
        }

        if(n % i == 0) {
            return false;
        }

        return isPrimeHelper(n, i+1);
    } 

    // wrapping 
    public static void isPrime(int n) {
        System.out.println(isPrimeHelper(n, 2));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();

        isPrime(n);

        sc.close();
    }
}
