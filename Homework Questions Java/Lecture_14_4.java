/* Write 2 functions => decimalToBinary() & binaryToDecimal() to convert a number from one number system to another.  */

import java.util.*;

public class Lecture_14_4 {
    public static int decimalToBinary(int n) {
        int ans = 0; // binary number
        int pow = 1; // 10^0 

        while(n > 0) {
            int remainder = n % 2;
            n /= 2;

            ans += (remainder*pow);
            pow *= 10; 
        }

        return ans; // binary form
    }

    public static int binaryToDecimal(int n) {
        int ans = 0; // decimal number
        int pow = 1; // 2^0

        while(n > 0) {
            int remainder = n % 10;
            n = n/10;

            ans += (remainder)*pow;
            pow *= 2;
        }

        return ans; // binary number
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter decimal number : ");
        int n = sc.nextInt();

        System.out.println("Binary form of " + n + " is : " + decimalToBinary(n));

        System.out.print("Enter binary number : ");
        int m = sc.nextInt();

        System.out.println("Decimal form of " + m + " is : " + binaryToDecimal(m));

        sc.close();
    }
}