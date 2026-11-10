/* Make a function to add 2 numbers and return the sum. */

import java.util.*;

public class Practice_Question_20 {

    public static int calculateSum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String args[]) {
        System.out.print("Enter a : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.print("Enter b : ");
        int b = sc.nextInt();

        System.out.println("Sum is : " + calculateSum(a,b));

        sc.close();
    }
}
