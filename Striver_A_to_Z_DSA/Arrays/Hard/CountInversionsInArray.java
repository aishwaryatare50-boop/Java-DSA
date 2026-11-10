package Striver_A_to_Z_DSA.Arrays.Hard;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CountInversionsInArray {

    // Brute Solution 
    // Time Complexity = O(N^2)
    // Space Complexity = O(1)
    public static ArrayList<ArrayList<Integer>> bruteSolution(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] > arr[j]) {
                    ans.add(new ArrayList<>(List.of(arr[i], arr[j])));
                }
            }
        }

        return ans;
    }

    // Optimal Solution
    // Time Complexity = O(NlogN)
    // Space Complexity = O(N)
    public static int optimalApproach(int[] arr) {
        int inversionCount = divide(arr, 0, arr.length - 1);

        return inversionCount;
    }

    public static int divide(int[] arr, int start, int end) {
        if(start >= end) return 0;

        int mid = start + (end - start) / 2; 
        int left = divide(arr, start, mid);
        int right = divide(arr, mid+1, end);
        int merge = conquer(arr, start, mid, end);

        return left + right + merge;
    }

    public static int conquer(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];
        int i = 0;
        int idx1 = start;
        int idx2 = mid + 1;
        int count = 0;

        while(idx1 <= mid && idx2 <= end) {
            if(arr[idx1] <= arr[idx2]) {
                merged[i++] = arr[idx1++];
            } else {
                // right is smaller
                count += (mid - idx1 + 1);
                merged[i++] = arr[idx2++];
            }
        }

        while(idx1 <= mid) {
            merged[i++] = arr[idx1++];
        }

        while(idx2 <= end) {
            merged[i++] = arr[idx2++];
        }

        for(int j=0, k=start; j<merged.length && k<=end; j++, k++) {
            arr[k] = merged[j];
        }

        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.err.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        
        // brute solution
        System.out.println("The inversions in array are: " + bruteSolution(arr) + " and the count is: " + bruteSolution(arr).size());

        // optimal solution
        System.out.println("The count of inversions in array are: " + optimalApproach(arr));
        
        sc.close();
    }
}