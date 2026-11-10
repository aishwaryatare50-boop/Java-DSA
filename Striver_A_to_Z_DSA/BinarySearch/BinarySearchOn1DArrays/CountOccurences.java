package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn1DArrays;

import java.util.Scanner;

public class CountOccurences {

    public static int lowerBound(int[] arr, int target) {
        int lb = arr.length;
        int low = 0; 
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] >= target) {
                lb = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lb;
    }

    public static int upperBound(int[] arr, int target) {
        int ub = arr.length;
        int low = 0; 
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] > target) {
                ub = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ub;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        System.out.println("Enter " + size + " elements: ");
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element whose occurence is to be found: ");
        int target = sc.nextInt();

        int first = lowerBound(arr, target);
        int last = upperBound(arr, target) - 1;

        int count = last - first + 1;

        System.err.println("The count of occurence of " + target + " is: " + count);

        sc.close();
    }
}