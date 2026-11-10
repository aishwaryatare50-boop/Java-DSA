/* Write a function to print the sum of all odd numbers from 1 to n. */

import java.util.*;

public class Exercise_1_2 {
    public static int sumOdd(int n) {
        int sum = 0;
        for(int i=1; i<=n; i++) {
            if(i % 2 != 0) {
                sum = sum + i;
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        System.out.print("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Sum of all odd numbers from 1 to " + n + " is : " + sumOdd(n));

        sc.close();
    }
}
