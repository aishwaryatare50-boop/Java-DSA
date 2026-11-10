package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn1DArrays;

/*
* The Upper Bound is the smallest index in a sorted array such that arr[index] > n.
* If no such index is found in array return the size of array i.e. last hypothetical index.
*/

import java.util.Scanner;

public class UpperBound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        System.out.println("Enter " + size + " elements: ");
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element whose upper bound is to be found: ");
        int n = sc.nextInt();

        // Brute approach will be just a linear search with condition arr[i] >= n and time complexity = O(N)

        // Optimal Approach: Binary Search
        // Time Complexity = O(logN)
        // Space Complexity = O(1)
        int upperBound = size;
        int low = 0;
        int high = size - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] > n) {
                upperBound = mid;
                high = mid - 1;
            } else if(arr[mid] <= n) {
                low = mid + 1;
            }
        }

        System.out.println("The lower bound of " + n + " is: " + upperBound);


        sc.close();
    }
}