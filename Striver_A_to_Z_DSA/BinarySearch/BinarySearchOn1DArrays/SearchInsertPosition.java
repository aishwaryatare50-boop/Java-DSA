package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn1DArrays;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

*/

import java.util.Scanner;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        System.out.println("Enter " + size + " elements: ");
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to be found: ");
        int target = sc.nextInt();

        // Problem is equivalent to finding the lowerbound of an array
        int idx = size;
        int low = 0;
        int high = size - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] >= target) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("The index at which " + target + " can be inserted in given array is: " + idx + ".");

        sc.close();
    }
}