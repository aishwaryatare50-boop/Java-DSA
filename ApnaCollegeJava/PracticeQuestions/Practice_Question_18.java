/* Print the pattern : 
 Butterfly Pattern
 *    *      *
 *    **    **
 *    ***  ***
 *    ********
 *    ********
 *    ***  ***
 *    **    **
 *    *      *
 */

import java.util.*;

public class Practice_Question_18 {
    public static void main(String args[]) {
        System.out.print("Enter number of maximum stars : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // outer loop for 1st half - upper half
        for(int i=1; i<=n; i++) {
            // inner loop for 1st half stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }

            // inner loop for spaces
            for(int j=1; j<=2*(n-i); j++) {
                System.out.print(" ");
            }

            // inner loop for 2nd half stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // outer loop for 2nd half - lower half
        for(int i=n; i>=1; i--) {
            //inner loop for 1st half stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }

            // inner loop for spaces
            for(int j=1; j<= 2*(n-i); j++) {
                System.out.print(" ");
            }

            // inner loop for 2nd half stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
