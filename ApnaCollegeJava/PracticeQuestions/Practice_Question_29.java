// Print x^n (stack height = n).

import java.util.*;

public class Practice_Question_29 {

    public static int calculatePower(int x, int n) {

        if(x == 0) { // base case 1
            return 0;
        }
        
        if(n == 0) { // base case 2
            return 1;
        }

        int xPnM1 = calculatePower(x, n-1); // kaam
        int xPn = x * xPnM1;
        return xPn;
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
