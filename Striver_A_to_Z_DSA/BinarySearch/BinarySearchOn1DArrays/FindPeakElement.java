package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn1DArrays;


// An element is a peak if it is NOT smaller than its neighbors. For corner elements, we need to consider only one neighbor.
// arr[i-1] < arr[i] > arr[i+1] is a peak element

import java.util.Scanner;

public class FindPeakElement {

    // Brute Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static int bruteApproach(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        if(arr[0] > arr[1]) {
            return arr[0];
        } 

        if(arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        for(int i=1; i<arr.length - 1; i++) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                return arr[i];
            }
        }

        return -1;
    }

    // Optimal Approach
    // Time Complexity = O(logN)
    // Space Complexity = O(1)
    public static int optimalApproach(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        if(arr[0] > arr[1]) {
            return arr[0];
        } 

        if(arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        int low = 1;
        int high = arr.length - 2;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if(arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else if(arr[mid] > arr[mid + 1]) {
                high = mid - 1;
            } else {
                low = mid + 1; // [1, 5, 1, 2, 3] => mid = 1 => arr[mid] > arr[mid-1] => low = mid + 1
            }    
        }

        return -1;
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

        // brute approach
        System.out.println("Peak Element is: " + bruteApproach(arr));

        // optimal approach
        System.out.println("Peak Element is: " + optimalApproach(arr));

        sc.close();
    }
}