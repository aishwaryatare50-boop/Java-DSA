// Count total paths in a maze to move from (0,0) to (n,m).

package Extra_Questions;

public class Extra_Question_26 {
    public static int countPaths(int i, int j, int n, int m) {    

        if(i == n-1 && j == m-1) {
            return 1;
        }

        if(i == n || j == m) {
            return 0;
        }
        // move downwards
        int downPaths = countPaths(i+1, j, n, m);

        // move right
        int rightPaths = countPaths(i, j+1, n, m);

        return downPaths + rightPaths;
    }
    public static void main(String[] args) {
        int n = 3, m = 3;

        System.out.println(countPaths(0, 0, n, m));
    }
}
