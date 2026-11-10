package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn1DArrays;

import java.util.Scanner;

public class FirstAndLastOccurence {

    // Brute Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static void bruteApproach(int[] arr, int target) {
        int first = -1;
        int last = -1;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                if(first == -1) {
                    first = last = i;
                } else {
                    last = i;
                }
            }
        }

        System.out.println("First and last occurence of " + target + " is at indices " + first + " and " + last + " respectively.");
    }


    // Optimal Approach 1 // Given list is sorted 
    // Using upper bound and lowerbound concept
    // Time Complexity = O(logN)
    // Space Complexity = O(1)
    public static void optimalApproach1(int[] arr, int target) {
        int first = lowerBound(arr, target);

        if(first == arr.length || arr[first] != target) {
            System.out.println(target + " is not present in array.");
        } else {
            int last = upperBound(arr, target) - 1;
            System.out.println("First and last occurence of " + target + " is at indices " + first + " and " + last + " respectively.");
        }
    }

    public static int lowerBound(int[] arr, int x) {
        int lb = arr.length; 
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] >= x) {
                lb = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lb;
    }

    public static int upperBound(int[] arr, int x) {
        int ub = arr.length; 
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] > x) {
                ub = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ub;
    }


    // Optimal Approach 2 // Given list is sorted 
    // using simple binary search
    // Time Complexity = O(logN)
    // Space Complexity = O(1)
    public static void optimalApproach2(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int first = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = arr.length - 1;
        int last = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("First and last occurence of " + target + " is at indices " + first + " and " + last + " respectively.");
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

        System.out.print("Enter element whose first and last occurence is to be found: ");
        int target = sc.nextInt();

        // brute approach
        bruteApproach(arr, target);

        // optimal approach 1
        optimalApproach1(arr, target);

        // optimal approach 2
        optimalApproach2(arr, target);

        sc.close();
    }
}