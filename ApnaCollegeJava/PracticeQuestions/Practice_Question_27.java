// Print the factorial of a number n.

import java.util.*;

public class Practice_Question_27 {

    public static void printFactorial(int i, int n, int fac ) {

        if( i == n) {
            fac = fac * i;
            System.out.println(fac);
            return;
        }

        fac = fac * i;
        printFactorial(i + 1 , n, fac);
    }

    // or we can also make
    public static int calcFactorial(int n) {
        if( n == 1 || n == 0) {
            return 1;
        }
        int fac_nm1 = calcFactorial( n - 1);
        int fac_n = n * fac_nm1;
        return fac_n;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = sc.nextInt();

        printFactorial(1, n, 1);

        int ans = calcFactorial(n);
        System.out.println(ans);

        sc.close();
    }
}