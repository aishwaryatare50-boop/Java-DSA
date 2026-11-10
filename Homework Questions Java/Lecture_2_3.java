// 3.	Make a program that prints the table of a number that is input by the user.

import java.util.*;

class Lecture_2_3 {
    public static void main(String args[]) {

        System.out.print("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.println("Table of entered number is : ");
        System.out.println(a*1);
        System.out.println(a*2);
        System.out.println(a*3);
        System.out.println(a*4);
        System.out.println(a*5);
        System.out.println(a*6);
        System.out.println(a*7);
        System.out.println(a*8);
        System.out.println(a*9);
        System.out.println(a*10);

        sc.close();

    }
}