/* Write a program to count the number of 1’s in a binary representation of the number.   */

import java.util.*;

public class Lecture_14_3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number : ");
        int n = sc.nextInt();

        int onesCount = 0;

        for(int i=0; (1<<i) <= n; i++) {
            int bitMask = 1<<i;
            if((bitMask & n) != 0) {
                onesCount ++;
            }
        }

        System.out.println("Number of 1`s in binary representation of " + n + " is : " + onesCount);

        sc.close();
    }
}
