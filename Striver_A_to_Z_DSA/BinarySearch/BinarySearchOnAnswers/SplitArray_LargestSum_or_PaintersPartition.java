package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

/*
Split Array - Largest Sum
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
Return the minimized largest sum of the split.


or(since both problems code is same)


Painter's Partition
Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘K’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint. You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.

*/
import java.util.Scanner;

public class SplitArray_LargestSum_or_PaintersPartition {
    public static int findMax(int[] arr) {
        int max = arr[0];

        for(int n : arr) {
            if(n > max) {
                max = n;
            }
        }

        return max;
    }

    public static int sumArr(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        return sum;
    }

    public static boolean helper(int[] arr, int k, int max) {
        int temp = 1;
        int cap = arr[0];

        for(int i=1; i<arr.length; i++) {
            if(arr[i] + cap <= max) {
                cap += arr[i];
            } else {
                temp++;
                cap = arr[i];
            }
        }

        return temp <= k;
    }

    // Brute Approach
    // Time Complexity = O(N * (sum(arr) - max(arr)))
    // Space Complexity = O(1)
    public static int bruteApproach(int[] arr, int k) {
        int low = findMax(arr);
        int high = sumArr(arr);

        for(int i=low; i<=high; i++) {
            if(helper(arr, k, i)) {
                return i;
            }
        }

        return -1;
    }

    
    // Optimal Approach
    // Time Complexity = O(N * Log(sum(arr) - max(arr)))
    // Space Complexity = O(1)
    public static int optimalApproach(int[] arr, int k) {
        int low = findMax(arr);
        int high = sumArr(arr);

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(helper(arr, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements: ");
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // brute approach
        System.out.println("Minimum of maximum is:" + bruteApproach(arr, k));

        // optimal approach
        System.out.println("Minimum of maximum is:" + optimalApproach(arr, k));
        sc.close();
    }
}