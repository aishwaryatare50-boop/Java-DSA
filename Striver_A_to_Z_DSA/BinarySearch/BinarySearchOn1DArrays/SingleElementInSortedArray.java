package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn1DArrays;

import java.util.Scanner;

public class SingleElementInSortedArray {

    // Brute Approach 1
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static int bruteApproach1(int[] arr) {
        int sglEle = -1;

        for(int i=0; i<arr.length; i++) {
            if(i == 0) {
                if(arr[i] != arr[i+1]) {
                    sglEle = arr[i];
                    break;
                }
            } else if(i == arr.length - 1) {
                if(arr[i] != arr[i-1]) {
                    sglEle = arr[i];
                    break;
                }
            } else {
                if(arr[i] != arr[i-1] && arr[i] != arr[i+1]) {
                    sglEle = arr[i];
                    break;
                }
            }
        }

        return sglEle;
    }

    // Brute Approach 2
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static int bruteApproach2(int[] arr) {
        int xor = 0;

        for(int i=0; i<arr.length; i++) {
            xor = xor ^ arr[i];
        }

        return xor;
    }

    // Optimal Approach 
    // Time Complexity = O(logN)
    // Space Complexity = O(1)
    public static int optimalApproach(int[] arr) {
        if(arr.length == 1) return arr[0];

        if(arr[0] != arr[1]) return arr[0];

        if(arr[arr.length - 1] != arr[arr.length - 2]) return arr[arr.length - 1];

        int low = 1;
        int high = arr.length - 2;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            if((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) { // (even, odd) -> element is on right half
                low = mid + 1; // eleminate left half
            } else { // (odd, even) -> element is on left half 
                high = mid - 1; // eleminate right half
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
        
        // Brute Approach 1 
        System.out.println("Single element in array is: " + bruteApproach1(arr));

        // Brute Approach 2
        System.out.println("Single element in array is: " + bruteApproach2(arr));

        // Optimal Approach  
        System.out.println("Single element in array is: " + optimalApproach(arr));

        sc.close();
    }
}