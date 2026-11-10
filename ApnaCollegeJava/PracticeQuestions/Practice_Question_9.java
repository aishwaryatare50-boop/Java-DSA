/*
 * Print the pattern :
 *   Solid rectangle 
 *    *****
 *    *****
 *    *****
 *    *****
 */

import java.util.*;
 
public class Practice_Question_9 {
    public static void main(String args[]) {
        System.out.print("*****\n*****\n*****\n*****\n");

        // or we can also code using nested loops
        System.out.print("Enter number of rows : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print("Enter number of coloumns : ");
        int m = sc.nextInt();

        // outer loop , rows
        for(int i=1; i<=n; i++) {
            // inner loop, columns
            for(int j=1; j<=m; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
