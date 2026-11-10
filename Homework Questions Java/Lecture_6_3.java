/* Print Pascal's triangle
 *      1
 *     1 1
 *    1 2 1
 *   1 3 3 1
 *  1 4 6 4 1 
*/
import java.util.*;

public class Lecture_6_3 {
    public static void main(String args[]) {
        System.out.print("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            // spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }

            // numbers
            for(int j=1; j<=i; j++) {
                if(j==1 || j==i) {
                    System.out.print("1 ");
                } else if(i%2 ==0 || j%2 == 0) {
                    System.out.print(i-1+" ");
                } else {
                    
                }
            }
            // next line
            System.out.println();
        }

        sc.close();
    }
}
