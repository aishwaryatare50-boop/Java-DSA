/* Print the pattern : 
 * Diamond Pattern
 *                 *
 *                ***
 *               *****
 *              *******
 *              *******
 *               *****
 *                ***
 *                 *
 */

import java.util.*;

public class Practice_Question_19 {
    public static void main(String args[]) {
        System.out.print("Enter maximum number of stars : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // outer loop for upper half
        for(int i=1; i<=n; i++) {
            // spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }

            // stars 
            for(int j=1; j<=(2*i)-1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        
        // outer loop for lower half
        for(int i=n; i>=1; i--) {
            // spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }

            // stars
            for(int j=1; j<=(2*i)-1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        sc.close();
    }
}
