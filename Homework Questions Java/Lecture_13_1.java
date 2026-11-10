/* Take an array of Strings input from the user & find the cumulative (combined) length of all those strings. */

import java.util.*;

public class Lecture_13_1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        sc.nextLine();

        String Array[] = new String[size];
        
        for(int i=0; i<size; i++) {
            System.out.print("Enter string : ");
            Array[i] = sc.nextLine();
        }

        int totalLength = 0;

        for(int i=0; i<Array.length; i++) {
            StringBuilder sb = new StringBuilder(Array[i]);
            totalLength += sb.length();
        }

        System.out.println("Total length = " + totalLength);

        sc.close();
    }
}
