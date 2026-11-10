package Striver_A_to_Z_DSA.Arrays.Easy;

/* 
Given an array arr[] of size n-1 with distinct integers in the range of [1, n]. 
This array represents a permutation of the integers from 1 to n with one element missing. 
Find the missing element in the array.
*/

import java.util.Scanner;

public class FindMissingNumber {

    public static boolean linearSearch(int[] arr, int target) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                return true;
            }
        }

        return false;
    }

    // brute approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1)
    public static int bruteApproach(int[] arr, int N) {
        for(int i=1; i<=N; i++) {
            if(!linearSearch(arr, i)) {
                return i;
            }
        }

        return -1;
    }

    // better approach
    // Time Complexity = O(2N)
    // Space Complexity = O(N)
    public static int betterSolution(int[] arr, int N) {
        int[] map = new int[N];

        for(int i=0; i<arr.length; i++) {
            map[arr[i] - 1] = 1;
        }

        for(int i=0; i<N; i++) {
            if(map[i] == 0) return i+1;
        }

        return -1;
    }

    // optimal approach - 1
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static int optimalSolution1(int[] arr, int N) {
        int sum = (N * (N + 1)) / 2;

        for(int i=0; i<arr.length; i++) {
            sum -= arr[i];
        }

        return sum;
    }

    // optimal approach - 2
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // a ^ a = 0 and a ^ 0 = a
    public static int optimalSolution2(int[] arr, int N) {
        int xor1 = 0;
        int xor2 = 0;

        for(int i=0; i<arr.length; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ arr[i];
        }

        xor1 = xor1 ^ N;

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        int N = arr.length + 1;

        System.out.println("Missing number is: " + bruteApproach(arr, N));

        System.out.println("Missing number is: " + betterSolution(arr, N));

        System.out.println("Missing number is: " + optimalSolution1(arr, N));

        System.out.println("Missing number is: " + optimalSolution2(arr, N));

        sc.close();
    }
}