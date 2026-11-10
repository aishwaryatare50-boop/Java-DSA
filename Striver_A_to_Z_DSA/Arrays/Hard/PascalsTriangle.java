package Striver_A_to_Z_DSA.Arrays.Hard;
/*
Three types of questions are asked:
1. Given R and C print the element.
2. Given N print entire row.
3. Given N print entire Pascal's triangle
*/

import java.util.Scanner;
import java.util.ArrayList;

public class PascalsTriangle {

    static Scanner sc = new Scanner(System.in);

    // Type-1
    // Time Complexity = O(R)
    // Space Complexity = O(1)
    public static void type1() {
        System.out.println("Enter the row and coloumn of the element of the Pascal's Triangle to be printed.");
        System.out.print("Enter row: ");
        int R = sc.nextInt();

        System.out.print("Enter coloumn: ");
        int C = sc.nextInt();

        System.out.println("The element at position (" + R + "," + C + ") is " + nCr(R-1, C-1) + ".\n");
    }

    public static int nCr(int n, int r) {
        int res = 1;

        for(int i=0; i<r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    // Type-2

    // brute solution
    // Time Complexity = O(N * R)
    // Space Complexity = O(1)
    public static void type2Brute() {
        System.out.print("Enter the row of the Pascal's Triangle to be printed: "); 
        int N = sc.nextInt();

        for(int c=1; c<=N; c++) {
            System.out.print(nCr(N-1, c-1) + " ");
        }
        System.out.println();
    }

    // optimal solution
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static void type2Optimal() {
        System.out.print("Enter the row of the Pascal's Triangle to be printed: "); 
        int N = sc.nextInt();

        int ans = 1;

        System.out.print(ans + " ");
        for(int i=1; i<N; i++) {
            ans = ans * (N - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();

    }

    // Type - 3

    // Brute approach
    // Time Complexity = O(R * C * C)
    // Space Complexity = O(1) // O(N * C) for returning answer
    public static void type3Brute() {
        System.out.print("Enter number of rows of Pascal's Triangle to be printed: ");
        int N = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int r=1; r<=N; r++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int c=1; c<=r; c++) {
                temp.add(nCr(r-1,c-1));
            }
            ans.add(temp);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N-i-1; j++) {
                System.out.print(" ");
            }

            ArrayList<Integer> temp = ans.get(i);
            for(int n : temp) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    // optimal approach
    // Time Complexity = O(N * C)
    // Space Complexity = O(1) // O(N * C) for returning answer
    public static void type3Optimal() {
        System.out.print("Enter number of rows of Pascal's Triangle to be printed: ");
        int N = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int r=1; r<=N; r++) {
            ArrayList<Integer> temp = new ArrayList<>();

            long res = 1L;
            temp.add(1);

            for(int i=1; i<r; i++) {
                res = res * (r - i);
                res = res / i;
                temp.add((int)res);
            }

            ans.add(temp);
        }


        for(int i=0; i<N; i++) {
            for(int j=0; j<N-i-1; j++) {
                System.out.print(" ");
            }

            ArrayList<Integer> temp = ans.get(i);
            for(int n : temp) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // type-1
        type1();

        // type-2
        type2Brute();
        type2Optimal();

        // type-3
        type3Brute();
        type3Optimal();
    }
}