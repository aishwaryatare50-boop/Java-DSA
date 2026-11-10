package Recursions;

import java.util.*;

public class MaxAndMinInArray {
    //helper function-1
    public static int maxInArray(int arr[], int idx, int max) {
        // base case
        if(idx == arr.length) {
            return max;
        }
        
        if(max < arr[idx]) {
            max = arr[idx];
        }
        return maxInArray(arr, idx+1, max);   
    } 

    // helper function-2
    public static int minInArray(int arr[], int idx, int min) {
        // base case
        if(idx == arr.length) {
            return min;
        }

        if(min > arr[idx]) {
            min = arr[idx];
        }
        return minInArray(arr, idx+1, min);
    }
    // wrapping
    public static void maxAndMinInArray(int arr[]) {
        System.out.println("Max element in array is : " + maxInArray(arr, 0, Integer.MIN_VALUE));
        System.out.println("Min element in array is : " + minInArray(arr, 0, Integer.MAX_VALUE));
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // input size
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        // array declaration
        int arr[] = new int[size];

        // input array
        System.out.println("Enter " + size + " elements : ");
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        // output array
        for(int i=0; i<size; i++) {
            System.out.print(arr[i] + "   ");
        }
        System.out.println();

        // function call
        maxAndMinInArray(arr);

        sc.close();
    }
}