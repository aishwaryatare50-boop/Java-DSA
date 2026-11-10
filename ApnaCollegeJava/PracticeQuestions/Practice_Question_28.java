// Print the fibonacci sequence till nth term.

import java.util.*;

public class Practice_Question_28 {

    public static void printFibonnaci(int a, int b, int n) {
        if(n == 0) {
            return;
        }
        int c = a + b;
        System.out.println(c);
        printFibonnaci(b, c, n - 1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = sc.nextInt();
        int a = 0, b = 1;
        System.out.println(a);
        System.out.println(b);

        printFibonnaci(a, b, n - 2);

        sc.close();
    }
}
