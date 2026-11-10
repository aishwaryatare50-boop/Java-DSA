/* Print the pattern(Floyd's Triangle) : 
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 * 11 12 13 14 15
 */

import java.util.*; 

public class Practice_Question_16 {
    public static void main(String args[]) {
        System.out.print("Enter number of rows : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int number = 1;

        // outer loop (rows)
        for(int i=1; i<=n; i++) {
            // inner loop
            for(int j=1; j<=i; j++) {
                System.out.print(number+" ");
                number++;
            }
            System.out.println();
        }

        sc.close();
    }
}
