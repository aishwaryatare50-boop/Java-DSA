/*
 * Print the pattern(inverted half pyramid) 
 *   ****
 *   ***
 *   **
 *   *
 */
import java.util.*;

public class Practice_Question_12 {
    public static void main(String args[]) {
        System.out.print("Enter number of rows and columns : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            for(int j=n; j>=i; j--) {
                System.out.print("*");
            }
            System.out.println();
        } 
        // or we can also code
        for(int i=n; i>=1; i--) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // or we can also code
        for(int i=n; i>=1; i--) {
            for(int  j=1; j<=n; j++) {
                if(i>=j) {
                    System.out.print("*");
                } else {
                    System.out.print("");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
