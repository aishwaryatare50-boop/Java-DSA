/*  Write a program to print Fibonacci series of n terms where n is input by user : 
0 1 1 2 3 5 8 13 21 .....  
In the Fibonacci series, a number is the sum of the previous 2 numbers that 
came before it.  */

import java.util.*;

public class Exercise_1_10 {
    
    public static void main(String args[]) {
        System.out.print("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Fibonacci series of " + n + " terms is : ");

        int fib_1 = 0;
        int fib_2 = 1;

        for(int i=1; i<=n; i++) {
            System.out.print(fib_1 + " ");
            
            int fib = fib_1 + fib_2;
            fib_1 = fib_2;
            fib_2 = fib;
        }
        sc.close();
    }
}
