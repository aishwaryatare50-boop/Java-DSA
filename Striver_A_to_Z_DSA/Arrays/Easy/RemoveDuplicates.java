package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.Scanner;
import java.util.LinkedHashSet;

// Remove duplicates in-place from sorted array.

public class RemoveDuplicates {

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for(int j=low; j<high; j++) {
            if(arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        // pivot positioning
        int temp = pivot;
        arr[high] = arr[i];
        arr[i] = temp;

        return i; // pivot index
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pidx = partition(arr, low, high);

            quickSort(arr, low, pidx-1);
            quickSort(arr, pidx+1, high);
        }
    }

    // Time Complexity = O(NlogN + N) (worst case) in Average case = O(N)  
    // Space Complexity = O(N)
    public static int bruteApproach(int[] arr) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }

        int n = set.size();

        for(int i=0; i<n; i++) {
            arr[i] = set.removeFirst();
        }

        return n;
    }

    // Optimal Approach
    // Time Complexity = O(N)
    // Space Complexity = O(1) 
    public static int optimalApproach(int[] arr) {
        int i = 0;

        for(int j=1; j<arr.length; j++) {
            if(arr[j] != arr[i]) {
                arr[i+1] = arr[j];
                i++;
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
System.out.print("Enter the size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, size-1);

        // brute force approach
        System.out.println("Number of unique elements in array are : " + bruteApproach(arr));
        printArray(arr);

        // optimal approach
        System.out.println("Number of unique elements in array are : " + optimalApproach(arr));
        printArray(arr);

        sc.close();
    }
}