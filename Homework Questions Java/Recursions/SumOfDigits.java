package Recursions;

import java.util.*;

public class SumOfDigits {
    public static int sumOfDigits(int n) {
        if(n == 0) {
            return 0;
        }

        if(n < 0) {
            n *= -1;
        }

        return (n % 10) + sumOfDigits(n/10); 
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();

        System.out.println("The sum of digits of " + n + " is : " + sumOfDigits(n));

        sc.close();
    }
}
