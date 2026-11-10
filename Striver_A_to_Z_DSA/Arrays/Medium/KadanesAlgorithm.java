package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.Scanner;

public class KadanesAlgorithm {

    static class MaxSubarray {
        int sum;
        int[] arr;

        public MaxSubarray(int sum, int[] arr) {
            this.sum = sum;
            this.arr = arr;
        }

        public void printSubarray() {
            for(int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

        public void printMaxSum() {
            System.out.println("The maximum sum which can be obtained from subarray is " + sum + ".");
        }
    }

    // brute force approach and better approach
    // Time complexity = O(N^2) // if we do sum separately O(N^3)
    // Space Complexity = O(1)
    public static MaxSubarray bruteSolution(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int si = 0, ei = 0;
        int i = -1, j = -1;

        for(i=0; i<arr.length; i++) {
            int sum = 0;
            for(j=i; j<arr.length; j++) {
                sum += arr[j];
                if(sum > maxSum) {
                    maxSum = sum;
                    si = i;
                    ei = j;
                }
            }
        }

        int[] subArr = new int[ei - si + 1];
        for(int m=0, n=si; m<subArr.length && n <= ei; m++, n++) {
            subArr[m] = arr[n];
        }

        return new MaxSubarray(maxSum, subArr);
    }

    //optimal approach
    // Kadane's Algorithm
    // Time complexity = O(N)
    // Space Complexity = O(1)
    public static MaxSubarray kadanesAlgo(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int si = -1, ei = -1; 
        int sum = 0;
        int tempsi = 0;
        
        for(int i=0; i<arr.length; i++) {
            if(sum == 0) {
                tempsi = i;
            }

            sum += arr[i];

            if(sum > maxSum) {
                maxSum = sum;
                ei = i;
                si = tempsi;
            }
            
            if(sum < 0) {
                sum = 0;
            }
        }

        // // if array contains all negatives
        // if(maxSum < 0) {
        //     return new MaxSubarray(0, new int[0]);
        // }

        int[] newSubarray = new int[ei - si + 1];
        for(int j=si, k=0; j<=ei; j++, k++) {
            newSubarray[k] = arr[j];
        }

        return new MaxSubarray(maxSum, newSubarray);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        MaxSubarray ans;

        // brute solution
        ans = bruteSolution(arr);
        ans.printSubarray();
        ans.printMaxSum();

        // optimal solution
        // Kadane's Algorithm
        ans = kadanesAlgo(arr);
        ans.printSubarray();
        ans.printMaxSum();

        sc.close();
    }    
}