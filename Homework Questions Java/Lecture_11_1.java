/* . 
Print the spiral order matrix as output for a given matrix of numbers. 
[Difficult for Beginners] 
APPROACH :  
Algorithm: (We are given a 2D matrix of n X m ). 
1. We will need 4 variables: 
a. row_start - initialized with 0. 
b. row_end - initialized with n-1. 
c. column_start - initialized with 0. 
d. column_end - initialized with m-1. 
2. First of all, we will traverse in the row row_start from column_start 
to column_end and we will increase the row_start with 1 as we have 
traversed the starting row. 
3. Then we will traverse in the column column_end from row_start to 
row_end and decrease the column_end by 1. 
4. Then we will traverse in the row row_end from column_end to 
column_start and decrease the row_end by 1. 
5. Then we will traverse in the column column_start from row_end to 
row_start and increase the column_start by 1. 
6. We will do the above steps from 2 to 5 until row_start <= row_end 
and column_start <= column_end. 
 */

import java.util.*;

public class Lecture_11_1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows : ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns : ");
        int columns = sc.nextInt();

        int matrix[][] = new int[rows][columns];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int startingRow = 0, startingColumn = 0, endingRow = rows-1, endingColumn = columns -1;

        while(startingRow <= endingRow && startingColumn <= endingColumn) {
            // top boundary 
            for(int j=startingColumn; j<=endingColumn; j++) {
                System.out.print(matrix[startingRow][j] + " ");
            }

            // right boundary
            for(int i=startingRow+1; i<=endingRow; i++) {
                System.out.print(matrix[i][endingColumn] + " ");
            }

            // bottom boundary
            for(int j=endingColumn-1; j>=startingColumn; j--) {
                if(startingRow == endingRow) {
                    break;
                }
                System.out.print(matrix[endingRow][j] + " ");
            } 
            
            // left boundary
            for(int i=endingRow-1; i>= startingRow+1; i--) {
                if(startingColumn == endingColumn) {
                    break;
                }
                System.out.print(matrix[i][startingColumn] + " ");
            }

            startingRow++;
            endingRow--;
            startingColumn++;
            endingColumn--;
        }

        sc.close();
    }
}
