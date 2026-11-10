/* Print the half pyramid : 
 * 1111
 * 222
 * 33
 * 4
 */

import java.util.*;

public class Lecture_6_5 {
    public static void main(String args[]) {
        System.out.print("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number = 1;

        for(int i=n; i>=1; i--) {
            
            // numbers 
            for(int j=1; j<=i; j++) {
                System.out.print(number + " ");
            }

            number++;

            //next line
            System.out.println();
        }

        sc.close();
    }
}
