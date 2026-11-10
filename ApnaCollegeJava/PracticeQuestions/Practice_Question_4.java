// Check if 2 numbers are greater,less or equal to each other.

import java.util.*;

public class Practice_Question_4 {
    public static void main(String args[]) {
        System.out.print("Enter first number : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.print("Enter second number : ");
        int b = sc.nextInt();

        if( a>b) {
            System.out.println("a is greater than b.");
        } 

        if(b>a) {
            System.out.println("a is smaller than b.");
        }

        if(a == b) {
            System.out.println("a is equal to b");
        }

        // Or we can also code

        if(a == b) {
            System.out.println("a is equal to b.");
        } else {
            if(a>b) {
                System.out.println("a is greater than b.");
            } else {
                System.out.println("a is smaller than b.");
            }
        }

        sc.close();
    }
    
}
