package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

/*
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
The test cases are generated so that there will be an answer.

Example 1:
Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 

Example 2:
Input: nums = [44,22,33,11,1], threshold = 5
Output: 44
 
Constraints:
1 <= nums.length <= 5 * 104
1 <= nums[i] <= 106
nums.length <= threshold <= 106
*/

import java.util.Scanner;

public class FindTheSmallestDivisorGivenAThreshold {

    public static int findMax(int[] arr) {
        int max = arr[0];

        for(int n : arr) {
            if(n > max) {
                max = n;
            }
        }

        return max;
    }

    // Brute Approach
    // Time Complexity = O(n * max(arr))
    // Space Complexity = O(1)
    public static int bruteApproach(int[] arr, int threshold) {
        int max = findMax(arr);

        for(int d=1; d<=max; d++) {
            int sum = 0;
            for(int i=0; i<arr.length; i++) {
                sum += Math.ceil((double)arr[i] / d);
            }

            if(sum <= threshold) {
                return d;
            }
        }

        return -1;
    }

    
    // Optimal Approach
    // Time Complexity = O(n * log(max(arr)))
    // Space Complexity = O(1)
    public static int optimalApproach(int[] arr, int threshold) {
        int low = 1;
        int high = findMax(arr);

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int sum = 0;
            for(int i=0; i<arr.length; i++) {
                sum += Math.ceil((double)arr[i] / mid);
            }

            if(sum <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        // Brute Approach
        System.out.println("Smallest Divisor: " + bruteApproach(arr, threshold) + ".");

        // Optimal Approach
        System.out.println("Smallest Divisor: " + optimalApproach(arr, threshold) + ".");

        sc.close();
    }
}