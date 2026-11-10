package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn1DArrays;

import java.util.Scanner;

public class SearchXinRotatedSortedArray1 {

    // Brute Approach
    // Linear Search
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static void bruteApproach(int[] arr, int target) {
        int idx = -1;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                idx = i;
                break;
            }
        }

        if(idx == -1) {
            System.out.println(target + " not found in given array.");
        } else {
            System.out.println(target + " found at index " + idx);
        }
    }


    // Optimal Approach
    // Binary Search
    // Time Complexity = O(logN)
    // Space Complexity = O(1)
    // works only for unique elements
    public static void optimalApproach(int[] arr, int target) {
        int idx = -1;

        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + ((high - low) >> 1);

            if(arr[mid] == target) {
                idx = mid;
                break;
            }

            // left side is sorted
            if(arr[low] <= arr[mid]) {
                // figure if element lies on left half or not
                if(target >= arr[low] && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // right half is sorted 
            else {
                if(target >= arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        if(idx == -1) {
            System.out.println(target + " not found in given array.");
        } else {
            System.out.println(target + " found at index " + idx);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        System.out.println("Enter " + size + " elements: ");
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element whose index is to be found: ");
        int target = sc.nextInt();

        // brute approach
        bruteApproach(arr, target);

        // optimal approach
        optimalApproach(arr, target);

        sc.close();
    }
}