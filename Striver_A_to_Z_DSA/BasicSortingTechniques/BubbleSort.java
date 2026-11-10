package Striver_A_to_Z_DSA.BasicSortingTechniques;

import java.util.Scanner;

public class BubbleSort {

    public static void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSortAscend(int[] arr) {
        int n = arr.length;
        boolean didSwap;
        for(int i=0; i<n-1; i++) {
            didSwap = false;
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = true;
                }
            }

            if(!didSwap) {
                break;
            }
        }
    }

    public static void bubbleSortDescend(int[] arr) {
        int n = arr.length;
        boolean didSwap;
        for(int i=0; i<n-1; i++) {
            didSwap = false;
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] < arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = true;
                }
            }

            if(!didSwap) {
                break;
            }
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

        bubbleSortAscend(arr);
        printArray(arr);

        bubbleSortDescend(arr);
        printArray(arr);

        sc.close();
    }
}