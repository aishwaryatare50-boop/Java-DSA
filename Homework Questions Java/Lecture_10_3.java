/* Take an array of numbers as input and check if it is an array sorted in 
ascending order. 
Eg : { 1, 2, 4, 7 } is sorted in ascending order. 
       {3, 4, 6, 2} is not sorted in ascending order.  */

import java.util.*;

public class Lecture_10_3 {
    public static void main(String args[]) {
        System.out.print("Enter size of array : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        boolean notSorted = false;

        int numbers[] = new int[size];

        for(int i=0; i<numbers.length; i++) {
            System.out.print("Enter number : ");
            numbers[i] = sc.nextInt();
        }

        for(int i=0; i<size-1; i++) {
            if(numbers[i] <= numbers[i+1]) {

            } else {
                notSorted = true;
                break;
            }
        }

        if(notSorted) {
            System.out.println("Array is not sorted in ascending order.");
        } else {
            System.out.println("Array is sorted in ascending order.");
        }

        sc.close();
    }
}
