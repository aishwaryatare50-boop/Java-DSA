package Striver_A_to_Z_DSA.Arrays.Medium;

// Rotate matrix by 90 degrees or Rotate Image
import java.util.Scanner;
public class RotateMatrixBy90 {

    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        System.out.println();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    // brute solution
    // Time Complexity = O(N^2)
    // Space Complexity = O(N^2)
    public static int[][] bruteApproach(int[][] matrix) {
        int n = matrix.length;
        int[][] rotateMat = new int[n][n]; 
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                rotateMat[j][n-i-1] = matrix[i][j];
            }
        }

        return rotateMat;
    }

    // optimal approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1)
    public static int[][] optimalApproach(int[][] matrix) {
        int n = matrix.length;

        // step-1: transpose matrix
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // step-2: reverse each row
        for(int i=0; i<n; i++) {
            reverseArr(matrix[i]);
        }

        return matrix;
    }

    public static void reverseArr(int[] arr) {
        for(int i=0; i<arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter order of square matrix: ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // brute solution
        printMatrix(bruteApproach(matrix));

        // optimal solution
        printMatrix(optimalApproach(matrix));

        sc.close();
    }
}