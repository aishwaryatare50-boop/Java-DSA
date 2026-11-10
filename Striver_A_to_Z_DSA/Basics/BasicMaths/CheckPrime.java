package Striver_A_to_Z_DSA.Basics.BasicMaths;

/* 
Given a number n check if n is prime or not. A number n is prime if it is greater than 1 and has no positive divisors other than 1 and itself.
We can also say a prime number has only two factors, 1 and the number itself.
*/

import java.util.Scanner;

public class CheckPrime {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = sc.nextInt();

        if(n <= 1) {
            System.out.println(n + " is not a prime number.");
        } else {
            // Time Complexity = O(sqrt(n))
            boolean isPrime = true;

            for(int i=2; i*i<=n; i++) {
                if(n % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                System.out.println(n + " is a prime number.");
            } else {
                System.out.println(n + " is not a prime number.");
            }
        }
    }
}