package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.Scanner;

public class SetMatrixZeroes {

    public static void printMatrix(int[][] matrix) {

        System.out.println();
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // brute approach
    // Time Complexity = O{(M X N) X (N + M)} = O(n^3) // for square matrix
    // Space Complexity = O(1)
    public static void bruteSolution(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    helper(matrix, i, j);
                }
            }
        }

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void helper(int[][] matrix, int n, int m) {
        for(int i=0; i<matrix[0].length; i++) {
            if(matrix[n][i] != 0) matrix[n][i] = -1;
        }

        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][m] != 0) matrix[i][m] = -1;
        }
    }

    // better approach
    // Time Complexity = O(2 * N * M)
    // Space Complexity = O(N + M)
    public static void betterSolution(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            } 
        }
    }

    // optimal approach
    // Time Complexity = O(N * M)
    // Space Complexity = O(1)
    public static void optimalSolution(int[][] matrix) {
        // boolean[] rows = new boolean[matrix.length] => matrix[...][0]
        // boolean[] cols = new boolean[matrix[0].length] => matrix[0][...] 
        int col0 = 1;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                        // mark the i th row
                    matrix[i][0] = 0;
                    // mark the j th col
                    if(j != 0)
                        matrix[0][j] = 0;
                    else 
                        col0 = 0;
                }
            }
        }

        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j] != 0) {
                    // check for col and row
                    if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int j=0; j<matrix[0].length; j++) matrix[0][j] = 0;
        }

        if(col0 == 0) {
            for(int i=0; i<matrix.length; i++) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the rows of matrix: ");
        int n = sc.nextInt();

        System.out.print("Enter the columns of matrix: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // // brute approach
        // bruteSolution(matrix);
        // printMatrix(matrix);

        // // better approach
        // betterSolution(matrix);
        // printMatrix(matrix);

        // optimal solution
        optimalSolution(matrix);
        printMatrix(matrix);


        sc.close();
    }    
}