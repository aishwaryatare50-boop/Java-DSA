// Place Tiles of size 1 X M in a floor of N X M.

package Striver_A_to_Z_DSA.Recursion.Hard;

public class PlaceTiles {

    // Time Complexity = O(2 ^ (n + m))
    // Space Complexity = O(n + m) // recursion stack space
    public static int noOfWaysToPlaceTiles(int n, int m) {
        if(n == m) {
            return 2;
        }

        if(n < m) {
            return 1;
        }

        // vertically
        int verticalPlacements = noOfWaysToPlaceTiles(n - m, m);

        // horizontally
        int horizontalPlacements = noOfWaysToPlaceTiles(n - 1, m);

        return verticalPlacements + horizontalPlacements; // total placements
    }

    public static void main(String[] args) {
        System.out.println(noOfWaysToPlaceTiles(4, 2));
    }
}