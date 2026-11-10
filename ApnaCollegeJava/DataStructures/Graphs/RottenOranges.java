/* Qs - Rotten Oranges (Amazon/Adobe/Intuit/Uber)
You are given an m x n grid where each cell can have one of three values:
● 0 representing an empty cell,
● 1 representing a fresh orange, or
● 2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange
becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh
orange. If this is impossible, return -1.

Example 1
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1

Explanation: The orange in the bottom left corner (row 2, column 0) is never
rotten, because rotting only happens 4-directionally.
 */

package DataStructures.Graphs;

import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class RottenOranges {

    static class Info {
        int row;
        int col;
        int time;

        public Info(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        boolean[][] visited = new boolean[n][m];
        Queue<Info> q = new ArrayDeque<>();
       
        // pushing all sources in queue
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                   q.add(new Info(i, j, 0));
                   visited[i][j] = true;
                }
            }
        }

        // bfs
        while(!q.isEmpty()) {
            Info currNode = q.remove();
            int i = currNode.row;
            int j = currNode.col;
            int time = currNode.time;

            ans = Math.max(ans, time);

            if(i - 1 >= 0 && !visited[i-1][j] && grid[i-1][j] == 1) { // top
                q.add(new Info(i-1, j, time+1));
                visited[i-1][j] = true;
            }

            if(i + 1 < n && !visited[i+1][j] && grid[i+1][j] == 1) { // bottom
                q.add(new Info(i+1, j, time+1));
                visited[i+1][j] = true;
            }

            if(j - 1 >= 0 && !visited[i][j-1] && grid[i][j-1] == 1) { // left
                q.add(new Info(i, j-1, time+1));
                visited[i][j-1] = true;
            }

            if(j + 1 < m && !visited[i][j+1] && grid[i][j+1] == 1) { // right
                q.add(new Info(i, j+1, time+1));
                visited[i][j+1] = true;
            }
        }

        // check for fresh orange
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }

        return ans;
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

        System.out.println(orangesRotting(grid));

        sc.close();
    }
}