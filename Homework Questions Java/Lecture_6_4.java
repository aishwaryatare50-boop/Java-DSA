/* Print half pyramid : 
 * 1
 * 1 2
 * 1 2 3
 * 1 2 3 4
 * 1 2 3 4 5
 */

import java.util.*;

public class Lecture_6_4 {
    public static void main(String args[]) {
        System.out.print("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            
            // numbers
            for(int j=1; j<=i; j++) {
                System.out.print(j + " ");
            }

            // next line
            System.out.println();
        }

        sc.close();
    }
}