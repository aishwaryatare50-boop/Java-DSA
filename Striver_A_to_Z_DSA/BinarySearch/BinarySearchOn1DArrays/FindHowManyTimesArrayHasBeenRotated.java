package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn1DArrays;

import java.util.Scanner;

public class FindHowManyTimesArrayHasBeenRotated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        System.out.println("Enter " + size + " elements: ");
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        int minimum = Integer.MAX_VALUE;
        int low = 0;
        int high = size - 1;
        int idx = -1;

        // Time Complexity = O(logN)
        // Space Complexity = O(1)
        // only for unique elements for duplicates t.c = O(N) and s.c. = O(1)
        while(low <= high) {
            int mid = low + (high - low) / 2;

            // if search space is already sorted
            if(arr[low] < arr[high]) {
                if(minimum > arr[low]) {
                    minimum = arr[low];
                    idx = low;
                }
                break;
            }

            // if duplicates then only
            /*
            if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
                if(minimum > arr[low]) {
                    minimum = arr[low];
                    idx = low;
                }
                low++;
                high--;
                continue;    
            }
             */

            // left part is sorted 
            if(arr[low] <= arr[mid]) {
                if(minimum > arr[low]) {
                    minimum = arr[low];
                    idx = low;
                }
                low = mid + 1; // eliminate left half
            }
            // right part is sorted 
            else {
                if(minimum > arr[mid]) {
                    minimum = arr[mid];
                    idx = mid;
                }
                high = mid - 1; // eliminate right half
            }
        }

        System.out.println("Minimum element in rotated sorted array is: " + minimum + ".");

        System.out.println("Array has been rotated " + idx + " times.");


        sc.close();
    }
}