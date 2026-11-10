package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.Scanner;

public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target : ");
        int target = sc.nextInt();

        int index = linearSearch(arr, target);

        if(index == -1) {
            System.out.println("Target not found in given array.");
        } else {
            System.out.println("Target found at index " + index + ".");
        }

        sc.close();
    }
}