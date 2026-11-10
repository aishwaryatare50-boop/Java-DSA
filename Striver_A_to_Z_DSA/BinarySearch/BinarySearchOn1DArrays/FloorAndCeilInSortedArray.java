package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn1DArrays;

/*
You're given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1]. 
The floor of x is the largest element in the array which is smaller than or equal to x. 
The ceiling of x is the smallest element in the array greater than or equal to x. (lower bound)
*/

import java.util.Scanner;

public class FloorAndCeilInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        System.out.println("Enter " + size + " elements: ");
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter element whose floor and ceiling is to be found: ");
        int x = sc.nextInt();

        int ceiling = -1;
        int floor = -1;
        int low = 0;
        int high = size - 1;

        // ceil - lower bound
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] >= x) {
                ceiling = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // floor 
        low = 0;
        high = size - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] <= x) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("The floor and ceiling of " + x + " are " + floor + " and " + ceiling + ".");

        sc.close();
    }
}