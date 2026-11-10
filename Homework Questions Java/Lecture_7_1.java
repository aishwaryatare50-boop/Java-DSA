/* Make a function to check if a number is prime or not. */

import java.util.*;

public class Lecture_7_1 {
    public static void checkPrime(int n) {

        int a=0;
        for(int i=2; i<=n-1; i++) {
            if(n%i == 0) {
                a++;
            }
        }
        if(n<=1) {
            System.out.println(n + " is not a prime number.");
        } else if(a>0) {
            System.out.println(n+ " is not a prime number.");
        } else {
            System.out.println(n + " is a prime number.");
        }
        
        return;
    }

    public static void main(String args[]) {
        System.out.print("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        checkPrime(n);

        sc.close();
    }
}
