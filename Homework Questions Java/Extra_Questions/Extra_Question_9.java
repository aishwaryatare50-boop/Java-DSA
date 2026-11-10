package Extra_Questions;
// WAP to add two matrices

import java.util.*;

public class Extra_Question_9 {
    public static Scanner sc = new Scanner(System.in);

    public static int[][] inputMatrix(int matrix[][], int row, int column) {
        System.out.println("Enter data : ");
        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        return matrix;
    }

    public static void displayMatrix(int matrix[][], int row, int column) {
        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        System.out.print("Enter number of rows of matrix : ");
        int row = sc.nextInt();
        System.out.print("Enter number of columns of matrix : ");
        int column = sc.nextInt();
        int[][] A = new int[row][column];
        int[][] B = new int[row][column];
        int[][] C = new int[row][column];

        inputMatrix(A, row, column);
        inputMatrix(B, row, column);

        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        
        System.out.println("The addition matrix of A+B = C is given by : ");
        displayMatrix(C, row, column);
    }
}