/*  For a given matrix of N x M, print its transpose.  */

import java.util.*;

public class Lecture_11_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numbe of rows : ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns : ");
        int columns = sc.nextInt();

        int matrix[][] = new int[rows][columns];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Transpose 
        for(int i=0; i<columns; i++) {
            for(int j=0; j<rows; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}