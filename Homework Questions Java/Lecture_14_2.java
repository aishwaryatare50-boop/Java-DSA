/* Write a program to toggle a bit a position = “pos” in a number “n”. */

import java.util.*;

public class Lecture_14_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number : ");
        int n = sc.nextInt();

        System.out.print("Enter position : ");
        int pos = sc.nextInt();

        int bitMask = 1 << pos;

        if((bitMask & n) == 0) {
           int newNumber = bitMask | n;
           System.out.println(newNumber);
        } else {
            int newBitMask = ~bitMask;
            int newNumber = newBitMask & n;
            System.out.println(newNumber);
        }

        // or we can also use XOR(^) operator

        int newNumber= n ^ (bitMask);
        System.out.println(newNumber);

        sc.close();
    }
}
