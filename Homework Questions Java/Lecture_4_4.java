// Print if a number is prime or not (Input n from the user).  
// [In this problem you will learn how to check if a number is prime or not]

import java.util.*;

public class Lecture_4_4 {
    public static void main(String args[]) {
        System.out.print("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;

        for(int i = 2; i <= n-1 ; i++) {
            if(n%i == 0) {
                a = a+1;
            }
        }

        if(n<0 || n==1 || n==0 || a>0) {
            System.out.println(n+" is not a prime number.");
        }  else {
            System.out.println(n+" is a prime number.");
        }

        sc.close();
    }
}
