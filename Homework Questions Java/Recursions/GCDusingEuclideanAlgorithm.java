package Recursions;

/* According to Euclidean Algorithm for GCD(greatest common divisor)/ HCF(highest common factor)
 * GCD(a,b) = GCD(b%a,a) where a < b
 */

import java.util.*;

public class GCDusingEuclideanAlgorithm {
    public static int GCD(int a, int b) {
        if(b == 0) {
            return a;
        }

        return GCD(b, a%b);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int a = sc.nextInt();
        System.out.print("Enter second number : ");
        int b = sc.nextInt();

        System.out.println("GCD of " + a + " and " + b + " is : " + GCD(a, b));

        sc.close();
    }
}