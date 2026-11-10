package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class FindNthRootOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        double nthRoot = 0;
        final double EPSILON = 1e-6f;
        double low = 0;
        double high = num;

        while(high - low > EPSILON) {
            double mid = low + (high - low) / 2;

            if(Math.pow(mid, n) < num) {
                nthRoot = mid;
                low = mid;
            } else {
                high = mid;
            }
        }

        // Time Complexity = O(log(num / EPSILON))
        // Space Complexity = O(1)
        System.out.println("The " + n + "th root of " + num + " is: " + nthRoot);

        nthRoot = Math.pow(num, (double)(1 / (double)n));
        System.out.println("The " + n + "th root of " + num + " is: " + nthRoot);

        sc.close();
    }    
}