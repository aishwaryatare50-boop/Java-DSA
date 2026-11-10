package Striver_A_to_Z_DSA.BasicSortingTechniques;

import java.util.Scanner;

public class QuickSort {

    private static boolean descending;

    public static void printArray(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        if(descending) {
            for(int j=low; j<high; j++) {
                if(arr[j] > pivot) {
                    i++;
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        } else {
            for(int j=low; j<high; j++) {
                if(arr[j] < pivot) {
                    i++;
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i; // pivot index
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pidx = partition(arr, low, high);

            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);
        }
    }

    public static void quickSort(int[] arr, int low, int high, boolean descend) {
        if(low < high) {
            descending = descend;
            int pidx = partition(arr, low, high);

            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);
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

        // int n = 100_00;
        // int[] arr = new int[n];

        // for(int i=0; i<n; i++) {
        //     arr[i] = (int)(Math.random() * n);
        // }


        quickSort(arr, 0, n-1);
        printArray(arr);

        quickSort(arr, 0, n-1, true);
        printArray(arr);

        sc.close();
    }
}