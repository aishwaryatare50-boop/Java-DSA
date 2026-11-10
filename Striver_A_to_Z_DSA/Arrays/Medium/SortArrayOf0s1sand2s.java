package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.Scanner;
import java.util.Arrays;

public class SortArrayOf0s1sand2s {

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // brute force 
    // Time complexity = O(nlogn)
    // Space Complexity = O(1)
    public static int[] bruteSolution(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    // better solution
    // Time Complexity = O(2N)
    // Space Complexity = O(1)
    public static int[] betterSolution(int[] arr) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                count0++;
            } else if(arr[i] == 1) {
                count1++;
            } else if(arr[i] == 2) {
                count2++;
            }
        }

        for(int i=0; i<arr.length; i++) {
            if(i < count0) {
                arr[i] = 0;
            } else if(i < count0 + count1) {
                arr[i] = 1;
            } else if(i < count0 + count1 + count2) {
                arr[i] = 2;
            }
        }

        return arr;
    }

    // optimal solution
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // Dutch National Flag Algorithm
    public static int[] optimalApproach(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high) {
            if(arr[mid] == 0) {
                // swap
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } 
            else if(arr[mid] == 1) {
                mid++;
            } 
            else if(arr[mid] == 2) {
                // swap
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
        
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        // brute solution
        printArray(bruteSolution(arr));

        // better solution
        printArray(betterSolution(arr));

        // optimal solution 
        // Dutch National Flag Algorithm
        printArray(optimalApproach(arr));

        sc.close();
    }
}