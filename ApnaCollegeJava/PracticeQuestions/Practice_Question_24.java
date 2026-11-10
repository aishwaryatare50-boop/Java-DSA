/* Take a matrix as input from the user. Search for a given number x and
 * print the indices at which it occurs.
 */

import java.util.*;

public class Practice_Question_24 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean found = false;

        System.out.print("Enter number of rows : ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns : ");
        int columns = sc.nextInt();

        int numbers[][] = new int[rows][columns];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter number to be searched : ");
        int x = sc.nextInt();

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(numbers[i][j] == x) {
                    System.out.println(x + " is founded at (" + i + "," + j + ") index.");
                    found = true;
                }
            }
        }

        if(!found) {
            System.out.println(x + " does not exist in given matrix.");
        }

        sc.close();
    }
}
