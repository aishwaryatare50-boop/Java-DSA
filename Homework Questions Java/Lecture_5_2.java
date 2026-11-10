/* Print a number pyramid : 
 *      1
 *     2 2
 *    3 3 3
 *   4 4 4 4
 *  5 5 5 5 5
 */

import java.util.*;

public class Lecture_5_2 {
    public static void main(String args[]) {
        System.out.print("Enter number of rows : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            // spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            // numbers - print row number, row number times
            for(int j=1; j<=i; j++) {
                System.out.print(i+" ");
            }
    
            System.out.println();
        }

        sc.close();
    }
}
