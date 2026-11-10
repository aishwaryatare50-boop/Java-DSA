import java.util.*;

public class Arrays_2_D {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows : ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns : ");
        int columns = sc.nextInt();

        // we can also write
        // int[][] numbers = new int[rows][columns];
        int numbers[][] = new int[rows][columns];

        // loop for input
        // outer loop for rows
        for(int i=0; i<rows; i++) {
            // inners loop for columns 
            for(int j=0; j<columns; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        // loop for output
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
