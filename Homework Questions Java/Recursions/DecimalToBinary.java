package Recursions;

import java.util.*;

public class DecimalToBinary {
    public  static void decimalToBinary(int n) {
        if(n == 0) {
            return ;
        }
        decimalToBinary(n/2);
        System.out.print(n % 2);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter decimal number : ");
        int n = sc.nextInt();

        if(n == 0) {
            System.out.print("Binary of " + n + " is : 0");
        } else {
            System.out.print("Binary of " + n + " is : ");
            decimalToBinary(n);
        }
        
        sc.close();
    }
}
