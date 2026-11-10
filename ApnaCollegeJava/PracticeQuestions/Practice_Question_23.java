/* Take an array as input from the user. Search for a given number x and 
 * print the index at which it occurs (linear search).
 */

import java.util.*; 

public class Practice_Question_23 {
    public static void main(String args[]) {
        System.out.print("Enter size of array : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        boolean found = false;
        
        int arr[] = new int[size];

        for(int i=0; i<size; i++) {
            System.out.print("Enter element of array : ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number to be searched : ");
        int x = sc.nextInt();

        for(int i=0; i<arr.length; i++) { // arr.length = size of arr
            if(arr[i] == x) {
                System.out.println(x + " occurs at index number = " + i);
                found = true;
            } 
        }

        if(!found) {
            System.out.println(x + " does not exist in this array.");
        }

        sc.close();
    }
}
