package Recursions;

import java.util.*;

public class DigitsInWords {
    public static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void digitsInWords(int n) {
        if(n == 0) {
            return;
        }

        digitsInWords(n/10);
        System.out.print(digits[n%10] + " " );
        
        return;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();

        if(n == 0 ) {
            System.out.println(digits[n]);
        } else {
            digitsInWords(n);
        }

        sc.close();    
    }
}
