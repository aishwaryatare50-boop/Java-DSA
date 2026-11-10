package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOn2DArrays;

import java.util.Scanner;

public class FindAPeakElement2 {

    private static class Coordinates {
        int x;
        int y;

        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void printCoordinates() {
            System.out.println("The peak element is present at coordinate (" + x + ", " + y + ") in matrix.");
        }
    }


    // Brute Approach 1
    // Time Complexity = O(n * m) // in all worst case , O(1) in best case , O(n * m / (n + m)) in average case
    // Space Complexity = O(1)
    public static  Coordinates bruteApproach1(int[][] matrix) { 
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int el = matrix[i][j];
                int left = Integer.MIN_VALUE;
                int right = Integer.MIN_VALUE;
                int top = Integer.MIN_VALUE;
                int bottom = Integer.MIN_VALUE;

                if(j != 0) {
                    left = matrix[i][j-1];
                }

                if(j != m-1) {
                    right = matrix[i][j+1];
                }

                if(i != 0) {
                    top = matrix[i-1][j];
                }

                if(i != n-1) {
                    bottom = matrix[i+1][j];
                }

                if(el > top && el > bottom && el > right && el > left) {
                    return new Coordinates(i, j);
                }
            }
        }

        return  new Coordinates(0, 0);
    }



    // Brute Approach 2
    // Time Complexity = O(n * m) // in all cases
    // Space Complexity = O(1)
    public static  Coordinates bruteApproach2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = matrix[0][0];
        Coordinates c = new Coordinates(0, 0);

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] > max) {
                    max = matrix[i][j];
                    c.x = i;
                    c.y = j;
                }
            }
        }

        return c;
    }


    // Optimal Approach
    // Time Complexity = O(n * logm)
    // Space Complexity = O(1)
    public static Coordinates optimalApproach(int[][] matrix) {
        int m = matrix[0].length;

        int low = 0;
        int high = m - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int rowWithMax = maxEleRow(matrix, mid);

            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
        
            if(mid != 0) {
                left = matrix[rowWithMax][mid - 1];
            }

            if(mid != m-1) {
                right = matrix[rowWithMax][mid + 1];
            }

            if(matrix[rowWithMax][mid] > left && matrix[rowWithMax][mid] > right) {
                return  new Coordinates(rowWithMax, mid);
            } else if(matrix[rowWithMax][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return  new Coordinates(-1, -1);
    }

    public static int maxEleRow(int[][] matrix, int col) {
        int n = matrix.length;
        int max = matrix[0][col];
        int maxRow = 0;

        for(int i=0; i<n; i++) {
            if(matrix[i][col] > max) {
                max = matrix[i][col];
                maxRow = i;
            }
        }

        return maxRow;
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

        Coordinates c = new Coordinates(0, 0);

        // brute approach 1
        c = bruteApproach1(matrix);
        c.printCoordinates();

        // brute approach 2
        c = bruteApproach2(matrix);
        c.printCoordinates();

        // optimal approach
        c = optimalApproach(matrix);
        c.printCoordinates();

        sc.close();
    }
}