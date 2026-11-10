package Recursions;

import java.util.*;

public class LinearSearchInArray {
    public static void linearSearch(int arr[], int n, int idx) {
        if(arr.length == idx) {
            System.out.println("Entered element doesn't exist in given array.");
            return;
        }

        if(arr[idx] == n) {
            System.out.println("Entered element exist in given array at " + (idx+1) + " position.");
            return;
        }

        linearSearch(arr, n, idx+1);
        return;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {1, 23, 34, 45, 65, 89, 74, 34};
        System.out.print("Enter element to be searched : ");
        int n = sc.nextInt();

        linearSearch(arr, n, 0);

        sc.close();
    }
}