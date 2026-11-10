package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn2DArrays;

/*
You are given an m x n integer matrix matrix with the following two properties:
1.) Each row is sorted in non-decreasing order.
2.) The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
*/

import java.util.Scanner;

public class SearchInA2DMatrix1 {

    public static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                return true;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter the number of columns: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = sc.nextInt();

            }
        }

        System.out.print("Enter element to be searched: ");
        int target = sc.nextInt();

        // Brute approach will be just traversing the matrix and searching for the element. 
        // Time Complexity = O(n * m)
        // Space Complexity = O(1)
        
        // Better Approach - using binary search
        // Time Complexity = O(n) + O(logm) = O(n)
        // Space Complexity = O(1)

        boolean isPresent = false;
        for(int i=0; i<n; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                isPresent = binarySearch(matrix[i], target);
            }
        }

        if(isPresent) {
            System.out.println("Element found in matrix.");
        } else {
            System.out.println("Element is not present in matrix.");
        }

        // Optimal Approach 
        // Time Complexity = O(log(n * m))
        // Space Complexity = O(1)

        // Formula for converting 1D index to matrix index
        // row = index / m(columns)
        // col = index % m(columns)

        int low = 0;
        int high = n * m - 1;
        isPresent = false;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / m;
            int col = mid % m;

            int matrixElement = matrix[row][col];
            if(matrixElement == target) {
                isPresent = true;
                break;
            } else if(matrixElement > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if(isPresent) {
            System.out.println("Element found in matrix.");
        } else {
            System.out.println("Element is not present in matrix.");
        }

        sc.close();
    }
}