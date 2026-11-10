/* Write a function that calculates the Greatest Common Divisor and Lowest common multiple of 2 numbers */

import java.util.*;

public class Exercise_1_9 {
    public static int greaterNumber(int a, int b) {
        if(a>b) {
            return a;
        } else {
            return b;
        }
    }

    public static int GCD(int a, int b) {
        for(int i= greaterNumber(a,b); i>=2; i--) {
            if(a % i == 0 && b % i ==0) {
                return i;
            }
        }
        return 1;
    }

    public static int LCM(int a, int b) {
        for(int i=1; ; i++) {
            for(int j=1; j<=greaterNumber(a,b); j++) {
                if(a*i == b*j) {
                    return a*i;
                }
            } 
        }
    }
    public static void main(String args[]) {
        System.out.print("Enter 1st number : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.print("Enter 2nd number : ");
        int b = sc.nextInt();

        System.out.println("Greatest common divisor of " + a + " and " + b + " is : " + GCD(a,b));

        System.out.println("Lowest common multiple of " + a + " and " + b + " is : " + LCM(a,b));

        sc.close();
    }
}
