package Extra_Questions;
/* Write a program to print tthe sum of digits of a number. */

import java.util.*;

public class Extra_Question_1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number : ");
        int n = sc.nextInt();

        int sum = 0;

        while(n > 0) {
            sum += n % 10;
            n = n/10;
        } 

        System.out.println("The sum of digits of given number is : " + sum);

        sc.close();
    }
} 
