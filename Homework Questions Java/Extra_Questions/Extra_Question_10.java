package Extra_Questions;
// WAP for multiplication of two matrices 

import java.util.*;

public class Extra_Question_10 {
    public static Scanner sc = new Scanner(System.in);

    public static int[][] inputMatrix(int matrix[][], int rows, int columns) {
        System.out.println("Enter data : ");
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static void displayMatrix(int matrix[][], int rows, int columns) {
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        System.out.print("Enter number of rows for first matrix : ");
        int rowsA = sc.nextInt();
        
        System.out.print("Enter number of columns for first matrix : ");
        int columnsA = sc.nextInt();

        System.out.print("Enter number of rows for second matrix : ");
        int rowsB = sc.nextInt();
        
        System.out.print("Enter number of columns for second matrix : ");
        int columnsB = sc.nextInt();

        int[][] A = new int[rowsA][columnsA];
        int[][] B = new int[rowsB][columnsB];
        
        if(columnsA != rowsB) {
            System.out.println("Multiplication not possible");
        } else {
            inputMatrix(A, rowsA, columnsA);
            inputMatrix(B, rowsB, columnsB);

            int[][] C = new int[rowsA][columnsB];

            for(int i=0; i<rowsA; i++) {
                for(int j=0; j<columnsA; j++) {
                    C[i][j] = 0;
                    for(int k=0; k<columnsB; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }

            displayMatrix(C, rowsA, columnsB);
        }
    }
}
