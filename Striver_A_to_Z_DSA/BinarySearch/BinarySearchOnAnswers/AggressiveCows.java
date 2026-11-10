package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

/*
You are given an array 'arr' of size 'n' which denotes the position of stalls. You are also given an integer 'k' which denotes the number of aggressive cows.
You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible. Find the maximum possible minimum distance.
*/

import java.util.Scanner;
import java.util.Arrays;

public class AggressiveCows {

    public static boolean canPlaceCows(int[] arr, int cows, int minDist) {
        int cowCount = 1;
        int lastCow = arr[0];

        for(int i=1; i<arr.length; i++) {
            if(arr[i] - lastCow >= minDist) {
                cowCount++;
                lastCow = arr[i];
                if(cowCount >= cows) {
                    return true;
                }
            }
        }

        return cowCount >= cows;
    }
    
    // Brute Approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1)
    public static int bruteApproach(int[] arr, int k) {
        Arrays.sort(arr);
        int low = 1;
        int high = arr[arr.length - 1] - arr[0];

        for(int i=low; i<=high; i++) {
            if(canPlaceCows(arr, k, i)) {
                continue;
            } else {
                return i - 1;
            }
        }

        return -1;
    }

    
    // Optimal Approach
    // Time Complexity = O(N * logN)
    // Space Complexity = O(1)
    public static int optimalSolution(int[] arr, int k) {
        Arrays.sort(arr);
        // low can be minimum of all consecutive distances
        int low = 1;
        int high = arr[arr.length - 1] - arr[0];

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(canPlaceCows(arr, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the position of " + n + " stalls:");
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of cows: ");
        int k = sc.nextInt();

        // Brute Approach
        System.out.println("Maximum of minimum distance betwwen any two cows is: " + bruteApproach(arr, k) + ".");

        // Optimal Approach
        System.out.println("Maximum of minimum distance betwwen any two cows is: " + optimalSolution(arr, k) + ".");

        sc.close();
    }    
}