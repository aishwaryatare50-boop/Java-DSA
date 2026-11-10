/*
 * Print the pattern (inverted half pyramid(rotated by 180 deg))
 *        * 
 *       **
 *      ***
 *     ****
 */

import java.util.*;

public class Practice_Question_13 {
    public static void main(String args[]) {
        System.out.print("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // outer loop (rows)
        for(int i=1; i<=n; i++) {
            // inner loop (columns)
            for(int j=n; j>=1; j--) {
                if(i>=j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // or we can also code
        //outer loop
        for(int i=1; i<=n; i++) {
            //inner loop -> space print
            for(int j=1; j<=n-i; j++ ) {
                System.out.print(" ");
            }

            //inner loop -> star print
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        sc.close();
    }
}
