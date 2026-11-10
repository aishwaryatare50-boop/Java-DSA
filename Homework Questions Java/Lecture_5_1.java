/* Print a solid rhombus :
 *       *****
 *      *****
 *     *****
 *    *****
 *   *****
 */

import java.util.*;

public class Lecture_5_1 {
    public static void main(String args[]) {
        System.out.print("Enter number of rows : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 9;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                int sum = i+j;
                if(sum >= 6 && sum <= 10) {
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
            // inner loop for spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            // inner loop for stars
            for(int j=1; j<=n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
