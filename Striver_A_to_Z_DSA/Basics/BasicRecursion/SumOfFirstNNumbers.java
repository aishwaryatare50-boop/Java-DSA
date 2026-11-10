package Striver_A_to_Z_DSA.Basics.BasicRecursion;

import java.util.Scanner;

public class SumOfFirstNNumbers {

    public static int sumOfNNumbers(int n) {
        // Time and Space Complexity = O(n)
        if(n == 0) {
            return 0;
        }

        return n + sumOfNNumbers(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = sumOfNNumbers(n);

        System.out.println(sum);

        // or most optimised approach
        // Time Complexity = O(1)
        sum = n * (n + 1) / 2;
        System.out.println(sum);

        sc.close();
    }
}