package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.ArrayList;
import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows in matrix: ");
        int n = sc.nextInt();

        System.out.print("Enter number of rows in matrix: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        
        // Time Complexity = O(N * M)
        // Space Complexity = O(1)

        while(top <= bottom && left <= right) {

            // left - right 
            for(int i=left; i<=right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // top - bottom
            for(int i=top; i<=bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // right - left
            if(top <= bottom) {
                for(int i=right; i>=left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // bottom - top
            if(left <= right) {
                for(int i=bottom; i>= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            
        }

        System.out.println(ans);

        sc.close();
    }    
}