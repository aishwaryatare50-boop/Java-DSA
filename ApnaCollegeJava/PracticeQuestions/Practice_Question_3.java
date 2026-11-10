// Write a program to check if a number is odd or even.

import java.util.*;

public class Practice_Question_3 {
    public static void main(String args[]) {

        System.out.print("Enter number : ");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n % 2 == 0) {
            System.out.println("Entered number is even.");
        } else {
            System.out.println("Entered number is odd.");
        }

        sc.close();
    }
    
}
