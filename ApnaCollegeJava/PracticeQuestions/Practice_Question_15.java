/* Print the pattern
 * 1 2 3 4 5
 * 1 2 3 4
 * 1 2 3
 * 1 2
 * 1
 */

 import java.util.*;

public class Practice_Question_15{
    public static void main(String args[]) {
        System.out.print("Enter number of rows : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=n; i>=1; i--) {
            for(int j=1; j<=i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

        // or we can also code
        for(int i=1; i<=n; i++) {
            // inner loop
            for(int j=1; j<=n-i+1; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

        sc.close();
    }
}
