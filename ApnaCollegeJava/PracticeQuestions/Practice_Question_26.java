// Print sum of first n natural numbers

import java.util.*;

public class Practice_Question_26 {

    public static void printSum(int i, int n, int sum ) {
        if( i == n) {
            sum += i;
            System.out.println(sum);
            return;
        }

        sum += i;
        printSum(i+1, n, sum);
        System.out.println(i);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = sc.nextInt();

        printSum(1, n, 0);

        sc.close();
    }
}
