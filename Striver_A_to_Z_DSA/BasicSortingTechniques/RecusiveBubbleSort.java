package Striver_A_to_Z_DSA.BasicSortingTechniques;

import java.util.Scanner;

public class RecusiveBubbleSort {

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void recusiveBubbleSortAscend(int[] arr, int n) {
        if(n == 1) {
            return;
        }

        boolean didSwap = false;
        for(int i=0; i<n-1; i++) {
            if(arr[i] > arr[i+1]) {
                // swap
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                didSwap = true;
            }
        }

        if(!didSwap) {
            return;
        }

        recusiveBubbleSortAscend(arr, n-1);
    }

    public static void recusiveBubbleSortDescend(int[] arr, int n) {
        if(n == 1) {
            return;
        }

        boolean didSwap = false;
        for(int i=0; i<n-1; i++) {
            if(arr[i] < arr[i+1]) {
                // swap
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                didSwap = true;
            }
        }

        if(!didSwap) {
            return;
        }

        recusiveBubbleSortDescend(arr, n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        recusiveBubbleSortAscend(arr, n);
        printArray(arr);

        recusiveBubbleSortDescend(arr, n);
        printArray(arr);

        sc.close();
    }
}