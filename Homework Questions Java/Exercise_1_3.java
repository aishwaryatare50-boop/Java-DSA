/* Write a function which takes in 2 numbers and returns the greater of those two.  */

import java.util.*;

public class Exercise_1_3 {
    public static void greaterNumber(int a, int b) {
        if(a>b) {
            System.out.println(a + " is greater number.");
        } else if(b>a) {
            System.out.println(b + " is greater number.");
        } else {
            System.out.println("Both numbers are equal.");
        }
        return;
    }

    public static void main(String args[]) {
        System.out.print("Enter 1st number : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.print("Enter 2nd number : ");
        int b = sc.nextInt();

        greaterNumber(a,b);

        sc.close();
    }
}