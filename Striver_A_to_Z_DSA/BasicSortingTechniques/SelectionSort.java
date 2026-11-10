package Striver_A_to_Z_DSA.BasicSortingTechniques;

import java.util.Scanner;

public class SelectionSort {

    public static void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectionSortAscend(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++) {
            int smallest = i;
            for(int j=i+1; j<n; j++) {
                if(arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }

    public static void selectionSortDescend(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++) {
            int largest = i;
            for(int j=i+1; j<n; j++) {
                if(arr[largest] < arr[j]) {
                    largest = j;
                }
            }

            // swap
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp; 
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
        
        selectionSortAscend(arr);
        printArray(arr);

        selectionSortDescend(arr);
        printArray(arr);

        sc.close();;
    }
}