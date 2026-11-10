package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn2DArrays;

/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
*/

import java.util.Scanner;

public class SearchInA2DMatrix2 {

    private static class Coordinates {
        int x;
        int y;

        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void printCoordinates() {
            System.out.println("The element is present at coordinate (" + x + ", " + y + ") in matrix.");
        }
    }

    // Better Approach - using binary search
    // Time Complexity = O(nlogm)
    // Space Complexity = O(1)
    public static Coordinates betterApproach(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][matrix[0].length - 1]) {
                int index = binarySearch(matrix[i], target);

                if(index != -1) {
                    return new Coordinates(i, index);
                }
            }
        }

        return new Coordinates(-1, -1);
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


    // Optimal Approach
    // Time Complexity = O(n + m)
    // Space Complexity = O(1)
    public static Coordinates optimalApproach(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;

        while(row < n && col >= 0) {
            int element = matrix[row][col];
            if(element == target) {
                return new Coordinates(row, col);
            } else if(element < target) {
                row++;
            } else {
                col--;
            }
        }

        return new Coordinates(-1, -1);
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
    
    
        // Better Approach
        Coordinates c = betterApproach(matrix, target);
        c.printCoordinates();

        // Optimal Approach
        c = optimalApproach(matrix, target);
        c.printCoordinates();

        sc.close();
    }
}