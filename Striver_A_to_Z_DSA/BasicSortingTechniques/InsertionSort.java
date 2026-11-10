package Striver_A_to_Z_DSA.BasicSortingTechniques;

import java.util.Scanner;

public class InsertionSort {

    public static void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void insertionSortAscend(int[] arr) {
        int n = arr.length;
        for(int i=1; i<n; i++) {
            int current = arr[i];
            int j = i-1;
            while(j >= 0 && current < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            // placement
            j++;
            arr[j] = current;
        }
    }

    public static void insertionSortDescend(int[] arr) {
        int n = arr.length;
        for(int i=1; i<n; i++) {
            int current = arr[i];
            int j = i-1;
            while(j >= 0 && current > arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            // placement
            j++;
            arr[j] = current;
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

        insertionSortAscend(arr);
        printArray(arr);

        insertionSortDescend(arr);
        printArray(arr);

        sc.close();
    }
}