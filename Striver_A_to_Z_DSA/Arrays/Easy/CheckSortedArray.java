package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.Scanner;

public class CheckSortedArray {

    public static boolean isSortedArray(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        if(isSortedArray(arr)) {
            System.out.println("Array is sorted.");
        } else {
            System.out.println("Array is not sorted.");
        }

        sc.close();
    }
}