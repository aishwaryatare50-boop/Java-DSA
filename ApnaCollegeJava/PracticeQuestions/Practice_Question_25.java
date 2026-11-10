/* Write a program to reverse a string */

import java.util.*;

public class Practice_Question_25 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string : ");
        String str = sc.nextLine();

        for(int i=str.length()-1 ; i>=0; i--) {
            System.out.print(str.charAt(i));
        }

        System.out.println();

        // or we can also code

        StringBuilder sb = new StringBuilder("hello");

        for(int i=0; i<sb.length()/2; i++) {
            int front = i;
            int back = sb.length() - 1 - i;

            char frontChar = sb.charAt(front);
            char backChar = sb.charAt(back);

            sb.setCharAt(front, backChar);
            sb.setCharAt(back, frontChar);
        }

        System.out.println(sb);

        sc.close();
    }
}
