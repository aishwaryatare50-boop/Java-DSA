package Recursions;

// Print count of digits of a number

import java.util.*;

public class CountDigits {
    public static int countDigits(int n) {
        if(n == 0) {
            return 0;
        }

        return 1 + countDigits(n/10);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();

        System.out.println("Number of digits in " + n + " is : " + countDigits(n));

        sc.close();
    }
}
