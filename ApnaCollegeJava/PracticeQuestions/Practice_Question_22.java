/*Find the factorial of a number. */

import java.util.*;

public class Practice_Question_22 {
    public static int factorial(int a) {
        int fac = 1;
        for(int i=1; i<=a; i++) {
            fac = fac*i;
        }
        return fac; 
        
    }

    public static void main(String args[]) {

        System.out.print("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if(a<0) {
            System.out.println("Invalid Number");
        } else {
            System.out.println("Factorial of " + a + " is : " + factorial(a));
        }

        sc.close();
    }
}