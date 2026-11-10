/* Qs - Number of Islands (Google/Microsoft/Facebook/Apple)

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's
(water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands
horizontally or vertically. You may assume all four edges of the grid are all
surrounded by water.

Example 1
Input: grid = [
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]
]
Output: 1

Example 2
Input: grid = [
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
]
Output: 3
*/

package DataStructures.Graphs;

import java.util.Scanner;

public class NumberOfIslands {

    public static void dfs(int i, int j, boolean[][] visited, int[][] grid, int n, int m) {

        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || grid[i][j] != 1) { // base case
            return; 
        }

        visited[i][j] = true;

        dfs(i-1, j, visited, grid, n, m); // top
        dfs(i+1, j, visited, grid, n, m); // bottom
        dfs(i, j+1, visited, grid, n, m); // right
        dfs(i, j-1, visited, grid, n, m); // left
    }

    public static int numberOfIslands(int[][] grid) {
        int islands = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                visited[i][j] = false;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, visited, grid, n, m); // 1 component visit
                    islands++;
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(numberOfIslands(grid));

        sc.close();
    }
}
