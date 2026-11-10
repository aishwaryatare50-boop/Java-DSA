package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn2DArrays;

/*
Given a row-wise sorted matrix of size M*N, where M is no. of rows and N is no. of columns, find the median in the given matrix.
Note: M*N is odd.
*/

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class MatrixMedian {

    // Brute Approach
    // Time Complexity = O(n * m) + O((n*m)log(n*m))
    // Space Complexity = O(n * m)
    public static int bruteApproach(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = matrix.length; 
        int m = matrix[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                list.add(matrix[i][j]);
            }
        }

        Collections.sort(list);

        return list.get(n*m / 2);
    }

    // Optimal Approach
    // Time Complexity = O(log(max(matrix) - min(matrix)) * n * logm)
    // Space Complexity = O(1)
    public static int optimalApproach(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int req = (n * m) / 2;

        int low = minEleInCol(matrix, 0);
        int high = maxEleInCol(matrix, m - 1);

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int smallerEquals = eleSmallerThanX(matrix, mid);

            if(smallerEquals <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;

    }

    public static int minEleInCol(int[][] matrix, int col) {
        int min = matrix[0][col];
        int n = matrix.length;

        for(int i=0; i<n; i++) {
            if(matrix[i][col] < min) {
                min = matrix[i][col];
            }
        }

        return min;
    }

    public static int maxEleInCol(int[][] matrix, int col) {
        int max = matrix[0][col];
        int n = matrix.length;

        for(int i=0; i<n; i++) {
            if(matrix[i][col] > max) {
                max = matrix[i][col];
            }
        }

        return max;
    }

    public static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int eleSmallerThanX(int[][] matrix, int target) {
        int count = 0;
        int n = matrix.length;

        for(int i=0; i<n; i++) {
            count += upperBound(matrix[i], target);
        }

        return count;
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

        // brute approach
        System.out.println("Median of matrix elements is: " + bruteApproach(matrix));


        // optimal approach
        System.out.println("Median of matrix elements is: " + optimalApproach(matrix));

        sc.close();
    }
}