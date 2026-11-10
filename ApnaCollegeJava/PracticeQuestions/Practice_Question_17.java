/* Print the pattern(0-1 triangle)
 * 1
 * 0 1
 * 1 0 1
 * 0 1 0 1
 * 1 0 1 0 1
 */

import java.util.*;

public class Practice_Question_17 {
    public static void main(String args[]) {
        System.out.print("Enter number of rows : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // outer loop
        for(int i=1; i<=n; i++) {
            // inner loop 
            for(int j=1; j<=i; j++) {
                if((i+j) % 2 == 0) {
                    System.out.print("1 ");
                } else { 
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
