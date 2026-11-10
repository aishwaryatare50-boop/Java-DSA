// Count total paths in a maze to move from (0,0) to (n,m).
// Conditions:
// i) We can only move in right
// ii) We can only move downwards

public class Practice_Question_41 {
    public static int countPaths(int i, int j, int n, int m) {
        if(i == n || j == m) {
            return 0;
        }
        if(i == n-1 && j == m-1) {
            return 1;
        }

        // move downwards
        int downPaths = countPaths(i+1, j, n, m);

        // move right
        int rightPaths = countPaths(i, j+1, n, m);

        return downPaths + rightPaths;
    }
    public static void main(String args[]) {
        int n = 3, m = 3;
        System.out.println("Total number of paths : " + countPaths(0, 0, n, m));
    }
}