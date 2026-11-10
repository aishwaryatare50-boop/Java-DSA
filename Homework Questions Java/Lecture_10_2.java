/* Find the maximum & minimum number in an array of integers.   */

import java.util.*;

public class Lecture_10_2 {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int max = 0;
        int min = 100;

        for(int i=0; i<arr.length; i++) {

            if(arr[i] > max) {
                max = arr[i];
            }

            if(arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Maximum number is given array is : " + max + " and minimum number in given array is : " + min);

        // or we can also code it in advanced manner

        System.out.print("Enter size of array : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int numbers[] = new int[size];

        max = Integer.MIN_VALUE; // minimum integer value in java 
        min = Integer.MAX_VALUE; // maximum integer value in java


        for(int i=0; i<numbers.length; i++) {
            System.out.print("Enter " + (i+1) + " number : ");
            numbers[i] = sc.nextInt();
        }

        for(int i=0; i<size; i++) {

            if(numbers[i] > max) {
                max = numbers[i];
            }

            if(numbers[i] < min) {
                min = numbers[i];
            }
        }

        System.out.println("Maximum number is given array is : " + max + " and minimum number in given array is : " + min);

        sc.close();
    }
}
