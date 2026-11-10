/* Make a function to check if a given number n is even or not. */

import java.util.*;

public class Lecture_7_2 {
    public static void checkEven(int n) {
        if(n % 2 == 0) {
            System.out.println(n + " is even.");
        } else {
            System.out.println(n + " is odd.");
        }
        return;
    }

    public static void main(String args[]) {
        System.out.print("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        checkEven(n);

        sc.close();
    }

}
