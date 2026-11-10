package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.Scanner;

public class PrintAllSubarrays {

    public static void printSubarray(int[] arr, int i, int j) {
        for(int m=i; m<=j; m++) {
            System.out.print(arr[m] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                printSubarray(arr, i, j);
            }
        }

        sc.close();
    }    
}