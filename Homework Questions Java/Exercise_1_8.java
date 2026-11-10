/*  Two numbers are entered by the user, x and n. Write a function to find 
the value of one number raised to the power of another.  */

import java.util.*;

public class Exercise_1_8 {

    public static int power(int x, int n) {
        int power = 1 ;
        for(int i=1; i<=n; i++) {
            power = power * x;
        }
        return power;
    }
    public static void main(String args[]) {
        System.out.print("Enter 1st number : ");

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        System.out.print("Enter 2nd number : ");
        int n = sc.nextInt();

        System.out.println(power(x,n));

        sc.close();
    }
}
