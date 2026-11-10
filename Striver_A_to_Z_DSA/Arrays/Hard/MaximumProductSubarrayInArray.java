package Striver_A_to_Z_DSA.Arrays.Hard;

/*
Given an array that contains both negative and positive integers, find the maximum product subarray.

Examples: 
1) Input: Nums = [1,2,3,4,5,0]
Output: 120
Explanation: 
In the given array, 1×2×3×4×5 gives maximum product value.

2) Input: Nums = [1,2,-3,0,-4,-5]
Output: 20
Explanation: 
In the given array, (-4)×(-5) gives maximum product value.
*/

import java.util.Scanner;

public class MaximumProductSubarrayInArray {

    // Brute Approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1)
    public static long bruteApproach(int[] arr) {
        long maxProduct = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            int product = 1; 
            for(int j=i; j<arr.length; j++) {
                product *= arr[j];
                if(product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        return maxProduct;
    }


    // Optimal approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static long optimalApproach(int[] arr) {
        long maxProd = Integer.MIN_VALUE;

        long prefixMul = 1;
        long suffixMul = 1;

        for(int i=0; i<arr.length; i++) {
            if(prefixMul == 0) prefixMul = 1;
            if(suffixMul == 0) suffixMul = 1;

            prefixMul *= arr[i];
            suffixMul *= arr[arr.length - i - 1];

            maxProd = Math.max(Math.max(prefixMul, suffixMul), maxProd);
        }

        return maxProd;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        // brute approach 
        System.out.println("Maximum Product of elements of a subarray of given array is: " + bruteApproach(arr));

        // optimal approach 1
        System.out.println("Maximum Product of elements of a subarray of given array is: " + optimalApproach(arr));

        sc.close();
    }
}