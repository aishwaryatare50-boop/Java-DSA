package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn1DArrays;

/*
*  **BINARY SEARCH**
*
* In Binary Search algorithm we divide our search space into two halves each time until our target is reached or the list ends.
*
* The Time Complexity of Binary Search is: O(logN) 
*
* The assumption of binary search is "The array or given data structure is sorted."
*/

import java.util.Scanner;

public class SearchXinSortedArray {

    // function to sort array
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivotIdx = partition(arr, low, high);

            quickSort(arr, low, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, high);
        }
    } 

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for(int j=low; j<high; j++) {
            if(arr[j] < pivot) {
                // space
                i++;
                // placement: swap element at i and j
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // finally place pivot
        i++;
        arr[high] = arr[i];
        arr[i] = pivot;

        return i;
    }

    
    // Iterative Binary Search
    // Time Complexity = O(logN)
    // Space Complexity = O(1)
    public static void binarySearchI(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int index = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                index = mid;
                break;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else if(arr[mid] < target) {
                low = mid + 1;
            }
        }

        if(index == -1) {
            System.out.println( target + " not found in given array!");
        } else {
            System.out.println(target + " found at index: " + index);
        }
    }


    // Recursive Binary Search
    // Time Complexity = O(logN)
    // Space Complexity = O(1) // O(logN) for recursive stack space
    public static void binarySearchR(int[] arr, int target) {
        int index = helper(arr, target, 0, arr.length - 1);

        if(index == -1) {
            System.out.println( target + " not found in given array!");
        } else {
            System.out.println(target + " found at index: " + index);
        }
    }

    public static int helper(int[] arr, int target, int low, int high) {
        if(low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] > target) {
            return helper(arr, target, low, mid - 1);
        } else { // (arr[mid] < target)
            return helper(arr, target, mid + 1, high);
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
        quickSort(arr, 0, size - 1);

        System.out.print("Enter element to be found: ");
        int target = sc.nextInt();

        // iterative binary search
        binarySearchI(arr, target);

        // recursive binary search
        binarySearchR(arr, target);

        sc.close();
    }
}