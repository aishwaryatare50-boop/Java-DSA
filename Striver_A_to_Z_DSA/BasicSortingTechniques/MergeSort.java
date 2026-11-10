package Striver_A_to_Z_DSA.BasicSortingTechniques;

import java.util.Scanner;

public class MergeSort {

    public static void printArray(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static boolean descend = false;

    public static void mergeSort(int[] arr) {
        divide(arr, 0, arr.length-1);
    }

    public static void mergeSort(int[] arr, boolean descending) {
        descend = descending;
        divide(arr, 0, arr.length-1);
    }

    public static void divide(int[] arr, int si, int ei) {
        if(si < ei) {
            int mid = si + (ei - si) / 2;
            divide(arr, si, mid);
            divide(arr, mid+1, ei);
            conquer(arr, si, mid, ei);
        }
    }

    public static void conquer(int[] arr, int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        while(idx1 <= mid && idx2 <= ei) {
            if(!descend && arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else if(!descend && arr[idx2] < arr[idx1]) {
                merged[x++] = arr[idx2++];
            } else if(descend && arr[idx1] >= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else if(descend && arr[idx2] > arr[idx1]) {
                merged[x++] = arr[idx2++];
            }
        }

        while(idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        while(idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        for(int i=0, j=si; i<merged.length; i++,j++) {
            arr[j] = merged[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        // int[] arr = new int[100_000];
        // for(int i=0; i<arr.length; i++) {
        //     arr[i] = i;
        // }

        mergeSort(arr);
        printArray(arr);

        mergeSort(arr, true);
        printArray(arr);

        sc.close();
    }
}