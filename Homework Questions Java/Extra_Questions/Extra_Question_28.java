// Find number of ways of playing tiles of size 1xm in a floor of size nxm.

package Extra_Questions;

import java.util.Scanner;

public class Extra_Question_28 {
    public static int placeTiles(int n, int m) {
        if(n == 0) {
            return 1;
        }

        if(n == m) {
            return 2;
        }

        if(n < m) {
            return 1;
        }

        // horizontal placements
        int horPlace = placeTiles(n-1, m);

        // vertical placements
        int verPlace = placeTiles(n-m,m);

        return verPlace+horPlace;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions of floor");
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        System.out.print("Enter m : ");
        int m = sc.nextInt();

        System.out.println(placeTiles(n, m));
        sc.close();
    }
}
