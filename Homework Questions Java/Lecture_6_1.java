/* Print a hollow buttergly
 *       *        *
 *       **      **
 *       * *    * *
 *       *  *  *  *
 *       *   **   *
 *       *   **   *
 *       *  *  *  *
 *       * *    * *
 *       **      **
 *       *        *
 */

import java.util.*; 

public class Lecture_6_1 {
    public static void main(String args[]) {
        System.out.print("Enter value of n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // for upper half
        for(int i=1; i<=n; i++) {

            // stars for upper half
            for(int j=1; j<=i; j++) {
                if(j==1 || i==j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            // spaces
            for(int j=1; j<=2*(n-i); j++) {
                System.out.print(" ");
            }

            // stars for lower half
            for(int j=1; j<=i; j++) {
                if(j==1 || i==j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            // next line
            System.out.println();
        }

        // for lower half
        for(int i=n; i>=1; i--) {

            // stars for upper half
            for(int j=1; j<=i; j++) {
                if(j==1 || i==j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            // spaces
            for(int j=1; j<=2*(n-i); j++) {
                System.out.print(" ");
            }

            // stars for lower half
            for(int j=1; j<=i; j++) {
                if(j==1 || i==j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            // next line 
            System.out.println();
        }

        sc.close();
    }
}
