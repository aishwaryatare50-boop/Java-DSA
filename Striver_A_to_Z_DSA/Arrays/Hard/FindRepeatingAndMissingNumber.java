package Striver_A_to_Z_DSA.Arrays.Hard;

/*
Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.

Note: You are not allowed to modify the original array.

Example:
Input:
 nums = [3, 5, 4, 1, 1]  
Output:
 [1, 2]  
Explanation:
 1 appears twice in the array, and 2 is missing from the array. So the output is [1, 2].
*/

import java.util.Scanner;

public class FindRepeatingAndMissingNumber {

    // Brute Approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1)
    public static int countFreq(int[] arr, int target) {
        int freq = 0;

        for(int n : arr) {
            if(n == target) {
                freq++;
            }
        }

        return freq;
    }

    public static int[] bruteApproach(int[] arr) {
        int repeatingNum = 0;
        int missingNum = 0;

        for(int i=1; i<= arr.length; i++) {
            if(countFreq(arr, i) == 0) {
                missingNum = i;
            } else if(countFreq(arr, i) == 2) {
                repeatingNum = i;
            }
        }

        return new int[] {repeatingNum, missingNum};
    }


    // Better Approach
    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static int[] betterApproach(int[] arr) {
        int repeatingNum = 0;
        int missingNum = 0;
        boolean[] map = new boolean[arr.length];

        for(int i=0; i<arr.length; i++) {
            if(!map[arr[i] - 1]) {
                map[arr[i] - 1] = true;
            } else if(map[arr[i] - 1]) {
                repeatingNum = arr[i];
            }
        }

        for(int i=0; i<map.length; i++) {
            if(!map[i]) {
                missingNum = i + 1;
            }
        }

        return new int[] {repeatingNum, missingNum};
    }


    // Optimal Solution 1
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static int[] optimalApproach1(int[] arr) {
        int repeatingNum = 0; // x
        int missingNum = 0; // y
        int n = arr.length;
        int sum = 0;
        int sqSum = 0;

        int sumN = (n * (n + 1)) / 2;
        int sqSumN = (n * (n + 1) * (2*n + 1)) / 6;

        for(int el : arr) {
            sum += el;
            sqSum += el * el;
        }

        // x - y = sum - sumN -> eq. 1
        // x^2 - y^2 = sqSum- sqSumN
        // (x - y)(x + y) = sqSum - sqSumN
        // x + y = (sqSum - sqSumN) / (x - y) - eq. 2
        // x + y = (sqSum - sqSumN) / (sum - sumN) - eq. 2
        // adding eq. 1 and eq. 2
        // 2x =  sum - sumN  + (sqSum - sqSumN) / (sum - sumN)
        // x = (sum - sumN  + (sqSum - sqSumN) / (sum - sumN)) / 2
        repeatingNum = (sum - sumN + (sqSum - sqSumN) / (sum - sumN)) / 2;

        // y = x - (sum - sumN)
        missingNum = repeatingNum - (sum - sumN); 

        return new int[] {repeatingNum, missingNum};
    }


    // Optimal Solution 2
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static int[] optimalApproach2(int[] arr) {
        int repeatingNum = 0; // x
        int missingNum = 0; // y
        int xor = 0;

        for(int i=0; i<arr.length; i++) {
            xor = xor ^ arr[i];
            xor = xor ^ (i + 1);
        }

        // x ^ y = xor

        int bitNo = 0;

        while(true) {
            int bitMask = 1 << bitNo;
            if((xor & bitMask) != 0) { 
                break;
            }
            bitNo++;
        }

        int zeroBit = 0;
        int oneBit = 0;

        int bitMask = 1 << bitNo;
        for(int i=0; i<arr.length; i++) {
            // part of zero bit club
            if((arr[i] & bitMask) == 0) {
                zeroBit = zeroBit ^ arr[i];
            } else {
                // part of one bit club
                oneBit = oneBit ^ arr[i];
            }

            // part of zero bit club
            if(((i + 1) & bitMask) == 0) {
                zeroBit = zeroBit ^ (i + 1);
            } else {
                // part of one bit club
                oneBit = oneBit ^ (i + 1);
            }
        }

        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == zeroBit) count++;
        }

        if(count == 2) {
            repeatingNum = zeroBit;
            missingNum = oneBit;
        } else {
            repeatingNum = oneBit;
            missingNum = zeroBit;
        }

        return new int[] {repeatingNum, missingNum};
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int repeatingNum = 0;
        int missingNum = 0;

        // brute approach
        repeatingNum = bruteApproach(arr)[0];
        missingNum = bruteApproach(arr)[1];

        System.out.println("Repeating Number in array: " + repeatingNum);
        System.out.println("Missing Number in array: " + missingNum);

        // better approach
        repeatingNum = betterApproach(arr)[0];
        missingNum = betterApproach(arr)[1];

        System.out.println("Repeating Number in array: " + repeatingNum);
        System.out.println("Missing Number in array: " + missingNum);


        // optimal approach 1
        repeatingNum = optimalApproach1(arr)[0];
        missingNum = optimalApproach1(arr)[1];

        System.out.println("Repeating Number in array: " + repeatingNum);
        System.out.println("Missing Number in array: " + missingNum);


        // optimal approach 2
        repeatingNum = optimalApproach2(arr)[0];
        missingNum = optimalApproach2(arr)[1];

        System.out.println("Repeating Number in array: " + repeatingNum);
        System.out.println("Missing Number in array: " + missingNum);

        sc.close();
    }
}