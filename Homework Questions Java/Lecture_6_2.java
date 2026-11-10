/* Print a hollow rhombus 
 *       *****
 *      *   *
 *     *   *
 *    *   *
 *   *****
 */

import java.util.*;

public class Lecture_6_2 {
    public static void main(String args[]) {
        System.out.print("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            // spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }

            // stars
            for(int j=1; j<=n; j++) {
                if(i==1 || i==n || j==1 || j==n) {
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
