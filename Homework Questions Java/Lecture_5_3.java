/* Print the pattern : 
*  Palindromic pattern - same from both sides
                1 
              2 1 2
            3 2 1 2 3
          4 3 2 1 2 3 4
        5 4 3 2 1 2 3 4 5  
*/
import java.util.*;

public class Lecture_5_3 {
    public static void main(String args[]) {
        System.out.print("Enter number of rows : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            // spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            
            // 1st half numbers - backward loop
            for(int j=i; j>=1; j--) {
                System.out.print(j);
            }

            // 2nd half numbers - forward loop
            for(int j=2; j<=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        sc.close();
    }
}
