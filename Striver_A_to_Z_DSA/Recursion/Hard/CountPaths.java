/*
 * Count total paths in a maze from (0, 0) to (n-1, m-1) 
*/

package Striver_A_to_Z_DSA.Recursion.Hard;

public class CountPaths {

    // Time Complexity = O(2 ^ (n + m))
    // Space Complexity = O(n + m) // recursion stack space
    public static int countPaths(int i, int j, int n, int m) {

        if(i == n || j == m) {
            return 0;
        }

        if(i == n - 1 && j == m - 1) {
            return 1;
        }

        // move downwards
        int downwardPaths = countPaths(i+1, j, n, m);

        // move right
        int rightPaths = countPaths(i, j+1, n, m);

        return downwardPaths + rightPaths;
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(countPaths(0, 0, n, m));
    }
}