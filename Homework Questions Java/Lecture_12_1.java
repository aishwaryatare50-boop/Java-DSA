/* Take an array of Strings input from the user & find the cumulative (combined) length of all those strings. */

import java.util.*;

public class Lecture_12_1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        String arr[] = new String[size];

        for(int i=0; i<arr.length; i++) {
            System.out.print("Enter string : ");
            arr[i] = sc.next();
        }

        int length = 0;

        for(int i=0; i<size; i++) {
            // length = length + arr[i].length();
            // or we can write
            length += arr[i].length();
        }

        System.out.println("The combined length of all the strings in array is : " + length);

        sc.close();
    }
}
