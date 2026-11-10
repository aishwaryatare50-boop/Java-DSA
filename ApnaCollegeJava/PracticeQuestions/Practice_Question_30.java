// Print x^n (stack height = logn)

import java.util.*;

public class Practice_Question_30 {

    public static int calculatePower(int x, int n) {
        if(x == 0) { // base case 1
            return 0;
        }

        if(n == 0) { // base case 2
            return 1;
        }
        // if n is even
        if(n % 2 == 0) {
            return calculatePower(x, n/2) * calculatePower(x, n/2);
        } else { // n is odd
            return calculatePower(x, n/2) * calculatePower(x, n/2) * x;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x : ");
        int x = sc.nextInt();

        System.out.print("Enter n : ");
        int n = sc.nextInt();

        System.out.println("Result = " + calculatePower(x,n));

        sc.close();
    }
}
