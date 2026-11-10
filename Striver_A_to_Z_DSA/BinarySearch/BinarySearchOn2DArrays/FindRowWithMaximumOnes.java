package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn2DArrays;

import java.util.Scanner;

public class FindRowWithMaximumOnes {

    // Brute Approach
    // Time Complexity = O(n * m)
    // Space Complexity = O(1)
    public static int bruteApproach(int[][] matrix) {
        int maxOnes = 0;
        int rowIdx = -1;

        for(int i=0; i<matrix.length; i++) {
            int countOnes = 0;
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    countOnes++;
                }
            }

            if(countOnes > maxOnes) {
                maxOnes = countOnes;
                rowIdx = i;
            }
        }

        return rowIdx;
    }


    // Optimal Approach
    // Time Complexity = O(n * Logm)
    // Space Complexity = O(1)
    public static int optimalApproach(int[][] matrix) {
        int maxOnes = 0;
        int rowIdx = -1;

        for(int i=0; i<matrix.length; i++) {
            int idx = firstOccurene(matrix[i], 1);
            int countOnes = matrix[0].length - idx;

            if(countOnes > maxOnes) {
                maxOnes = countOnes;
                rowIdx = i;
            }
        }

        return rowIdx;
    }

    public static int firstOccurene(int[] arr, int target) { // lower bound
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
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


        // Brute Approach
        System.out.println("Row with maximum number of ones is: " + (bruteApproach(matrix) + 1));

        // Optimal Approach
        System.out.println("Row with maximum number of ones is: " + (optimalApproach(matrix) + 1));


        sc.close();
    }
}