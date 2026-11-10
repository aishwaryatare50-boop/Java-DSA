package Striver_A_to_Z_DSA.BasicSortingTechniques;

import java.util.Scanner;

public class RecursiveSelectionSort {

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void recursiveSelectionSortAscend(int[] arr, int n) {
        if(n == arr.length) {
            return;
        }

        int smallest = n;
        for(int i=n+1; i<arr.length; i++) {
            if(arr[i] < arr[smallest]) {
                smallest = i;
            }
        }

        // swap
        int temp = arr[n];
        arr[n] = arr[smallest];
        arr[smallest] = temp;

        recursiveSelectionSortAscend(arr, n+1);
    }

    public static void recursiveSelectionSortDescend(int[] arr, int n) {
        if(n == arr.length) {
            return;
        }

        int largest = n;
        for(int i=n+1; i<arr.length; i++) {
            if(arr[largest] < arr[i]) {
                largest = i;
            }
        }

        // swap
        int temp = arr[n];
        arr[n] = arr[largest];
        arr[largest] = temp;

        recursiveSelectionSortDescend(arr, n+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        recursiveSelectionSortAscend(arr, 0);
        printArray(arr);

        recursiveSelectionSortDescend(arr, 0);
        printArray(arr);

        sc.close();
    }
}