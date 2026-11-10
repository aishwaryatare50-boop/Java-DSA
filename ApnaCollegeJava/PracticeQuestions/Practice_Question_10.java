/*
 * Print the pattern (Hollow Rectangle)
 *     *****
 *     *   *
 *     *   *
 *     *****
 */

import java.util.*;

public class Practice_Question_10 {
    public static void main(String args[]) {
        System.out.println("*****\n*   *\n*   *\n*****\n");

        // or using nested loops
        System.out.print("Enter number of rows : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print("Enter number of coloumns : ");
        int m = sc.nextInt();

        // outer loop, rows
        for(int i=1; i<=n; i++) {
            // inner loop, columns
            for(int j=1; j<=m; j++) {
                // cell ->(i,j)
                if(i==1 || j==1 || i==n || j==m) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}