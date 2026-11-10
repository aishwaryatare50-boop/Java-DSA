/* Take an array of names as input from the user and print them on the screen. */

import java.util.*;

public class Lecture_10_1 {
    public static void main(String args[]) {

        System.out.print("Enter array size : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); // nextInt(), nextDouble(), nextFloat() leaves a next line which needs to be handled.
        sc.nextLine();

        String arr[] = new String[size];

        for(int i=0; i<arr.length; i++) {
            System.out.print("Enter name : ");
            arr[i] = sc.nextLine();
        }

        for(int i=0; i<size; i++) {
            System.out.println((i+1) + " name is : " + arr[i]);
        }

        sc.close();
    }
}
