package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.ArrayList;
import java.util.Scanner;

public class IntersectionOfTwoSortedArrays {

    static Scanner sc = new Scanner(System.in);

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static int[] inputArray() {
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, size-1);

        return arr;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pidx = partition(arr, low, high);

            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);
        }
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
        // swap
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i; // pivot index
    }

    // brute approach
    // Time Complexity = O(N1*N2)
    // Space Complexity = O(N2)
    public static ArrayList<Integer> bruteApproach(int[] arr1, int[] arr2) {
        ArrayList<Integer> ans = new ArrayList<>();

        int[] visited = new int[arr2.length];

        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr2.length; j++) {
                if(arr1[i] == arr2[j] && visited[j] == 0) {
                    ans.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }

                if(arr2[j] > arr1[i]) break;
            }
        }

        return ans;
    }

    // optimal approach
    // Time complexity = O(N1 + N2)
    // Space complexity = O(1) // O(N1 + N2) for returning ans
    public static ArrayList<Integer> optimalSolution(int[] arr1, int[] arr2) {
        ArrayList<Integer> ans = new ArrayList<>();

        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < arr1.length && idx2 < arr2.length) {
            if(arr1[idx1] == arr2[idx2]) {
                ans.add(arr1[idx1]);
                idx1++;
                idx2++;
            } else if(arr1[idx1] < arr2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = inputArray();
        int[] arr2 = inputArray();

        ArrayList<Integer> intersection = bruteApproach(arr1, arr2);
        System.out.println(intersection);

        intersection = optimalSolution(arr1, arr2);
        System.out.println(intersection);
    }
}