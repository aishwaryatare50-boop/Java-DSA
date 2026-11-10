/* Make a function to print the table of a given number n. */

import java.util.*;

public class Lecture_7_3 {
    public static void table(int n) {
        System.out.println("Table of " + n + " is : ");
        for(int i=1; i<=10; i++) {
            System.out.print(n*i + "  ");
        }
    }

    public static void main(String args[]) {
        System.out.print("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        table(n);

        sc.close();
    }
}
