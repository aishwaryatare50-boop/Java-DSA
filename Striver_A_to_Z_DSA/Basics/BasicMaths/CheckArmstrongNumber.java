package Striver_A_to_Z_DSA.Basics.BasicMaths;

/* 
Given an integer n check if a number is an Armstrong number or not. A nubmer is an Armstrong number if it is equal to the sum of its own digits each raised to the power of number of digits.  
*/

import java.util.Scanner;

public class CheckArmstrongNumber {
    static Scanner sc = new Scanner(System.in);

    public static float power(int x, int n) {
        if(x == 0) {
            if(n == 0) {
                return 1;
            }
            
            return 0;
        }

        if(n == 0) {
            return 1;
        }

        if(n == 1) {
            return x;
        }

        if(n < 0) {
            return 1 / power(x, -n);
        }

        float half = power(x, n/2);

        if(n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    
    public static void main(String[] args) {
        int n = sc.nextInt();

        int count = (int)Math.log10(n) + 1;

        int amsNum = 0;
        int temp = n;

        while(temp != 0) {
            int digit = temp % 10;
            amsNum += power(digit, count);
            temp /= 10;
        }

        if(n == amsNum) {
            // Time Complexity = O(log n)
            System.out.println(n + " is an Armstrong number.");
        } else {
            System.out.println(n + " is not an Armstrong number.");
        }
    }
}