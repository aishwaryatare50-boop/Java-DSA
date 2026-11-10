/* Write a program to find if a number is a power of 2 or not. */

import java.util.*;

public class Lecture_14_1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean isPower = false; 

        for(int i=0; (1<<i) <= n ; i++) {
            if((1<<i) == n ) {
                isPower = true;
                break;
            }
        }

        if(isPower) {
            System.out.println("Entered number is power of 2.");
        } else {
            System.out.println("Entered number is not power of 2.");
        }
        
        sc.close();
    }
}