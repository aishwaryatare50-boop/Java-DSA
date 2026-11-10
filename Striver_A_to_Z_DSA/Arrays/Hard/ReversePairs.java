package Striver_A_to_Z_DSA.Arrays.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReversePairs {

    // Brute Approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1) // O(N) for returning answer
    public static ArrayList<ArrayList<Integer>> bruteApproach(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] > 2 * arr[j]) {
                    ans.add(new ArrayList<>(List.of(arr[i], arr[j])));
                }
            }
        }

        return ans;
    }


    // Optimal Approach
    // Time Complexity = O(NlogN)
    // Space Complexity = O(N)
    public static int optimalApproach(int[] arr) {
        int count = divide(arr, 0, arr.length - 1);

        return count;
    }

    public static int divide(int[] arr, int start, int end) {
        if(start >= end) return 0; 

        int mid = start + (end - start) / 2;

        int left = divide(arr, start, mid);
        int right = divide(arr, mid + 1, end);
        int merged = conquer(arr, start, mid, end);

        return left + right + merged;
    }

    public static int conquer(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];
        int count = 0;
        int idx1 = start; 
        int idx2 = mid + 1; 
        int x = 0;

        while(idx1 <= mid && idx2 <= end) {
            if(arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        count += countPairs(arr, start, mid, end);

        while(idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        while(idx2 <= end) {
            merged[x++] = arr[idx2++];
        }

        for(int i=0, j=start; i<merged.length; i++, j++) {
            arr[j] = merged[i];
        }

        return count;
    }

    public static int countPairs(int[] arr, int start, int mid, int end) {
        int idx2 = mid + 1;
        int count = 0;
        for(int i=start; i<=mid; i++) {
            while(idx2 <= end && arr[i] > 2 * arr[idx2]) idx2++;

            count += (idx2 - (mid + 1));
        }

        return count;
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
        System.out.println("The count of reverse pairs in given array are: " + bruteApproach(arr).size() + " and the reverse pairs are: " + bruteApproach(arr));

        // optimal approach
        System.out.println("The count of reverse pairs in given array are: " + optimalApproach(arr));

        sc.close();
    }
}