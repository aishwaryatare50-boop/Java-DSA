package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class FindKthMissingPositiveNumber {

    // Brute Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static int bruteApproach(int[] arr, int k) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > k) {
                return k;
            } else {
                k++;
            }
        }

        return k;
    }


    // Optimal Approach
    // Time Complexity = O(logN)
    // Space Complexity = O(1)
    public static int optimalApproach(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // missing = arr[high] - (high + 1)
        // more = k - missing
        // ans = arr[high] + more
        // ans = arr[high] + k - misssing
        // ans = arr[high] + k - (arr[high] - (high + 1))
        // ans = arr[high] + k - arr[high] + (high + 1)
        // ans = high + 1 + k
        // ans = low + k

        return low + k;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter elements of array: ");
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter missing number to be found: ");
        int k = sc.nextInt();

        // Brute Approach
        System.out.println(k + "th missing number in array is: " + bruteApproach(arr, k));

        // Optimal Approach
        System.out.println(k + "th missing number in array is: " + optimalApproach(arr, k));

        sc.close();
    }    
}