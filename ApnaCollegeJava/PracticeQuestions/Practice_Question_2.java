// Take 2 variables 'a' and 'b' as input and print their sum

import java.util.*;

class Practice_Question_2 {
    public static void main(String args[]) {

        System.out.print("Enter first number : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.print("Enter second number : ");
        int b = sc.nextInt();

        int Sum = a+b;

        System.out.println(Sum);

        sc.close();
    }
}