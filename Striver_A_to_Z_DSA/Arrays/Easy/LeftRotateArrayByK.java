package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.Scanner;

public class LeftRotateArrayByK {

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Time Complexity = O(N^2) Space Complexity = O(1)
    public static void bruteApproach1(int[] arr, int k) {
        k = k % arr.length;
        for(int i=0; i<k; i++) {
            int temp = arr[0];
            for(int j=0; j<arr.length-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[arr.length - 1] = temp;
        }
    }

    // Time Complexity = O(N + K) , Space Complexity = O(K)
    public static void bruteApproach2(int[] arr, int k) {
        k = k % arr.length;
        int[] temp = new int[k];

        for(int i=0; i<k; i++) {
            temp[i] = arr[i];
        }

        for(int i=0; i<arr.length-k; i++) {
            arr[i] = arr[i + k];
        }

        for(int i=arr.length-k, j=0; i<arr.length && j<k; i++, j++) {
            arr[i] = temp[j];// arr[i] = temp[i - (arr.length - k)];
        }
    }

    // Optimal Solution
    // Time Complexity = O(2N), Space Complexity = O(1)
    public static void optimalSolution(int[] arr, int k) {
        k = k % arr.length;
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, arr.length-1);
        reverseArray(arr, 0, arr.length-1);
    }

    public static void reverseArray(int[] arr, int si, int ei) {
        while(si <= ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // // brute approach - 1
        // bruteApproach1(arr, k);
        // printArray(arr);

        // // brute approach - 2
        // bruteApproach2(arr, k);
        // printArray(arr);

        // optimal approach
        optimalSolution(arr, k);
        printArray(arr);

        sc.close();
    }
}