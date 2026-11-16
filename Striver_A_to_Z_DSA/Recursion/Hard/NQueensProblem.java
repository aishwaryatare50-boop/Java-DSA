// Given an N x N chessboard and N queens. Place all queens such that they are safe. Print all possible solutions.

package Striver_A_to_Z_DSA.Recursion.Hard;

import java.util.ArrayList;

public class NQueensProblem {

    // Brute force complexity will ne O(N^N) which will only use simple recursion without backtracking.
    
    // Time Complexity: O(N * N!) upper bound
    // Space Complexity: O(N^2) for the board + O(N) recursion stack
    public static ArrayList<ArrayList<String>> solveNQueens(int N) {
        ArrayList<ArrayList<String>> allBoards = new ArrayList<>();
        char[][] board = new char[N][N];
        helper(0, board, allBoards);

        return allBoards;
    }

    public static void helper(int col, char[][] board, ArrayList<ArrayList<String>> allBoards) {
        if(col == board.length) {
            saveBoard(board, allBoards);
            return;
        }


        for(int i=0; i<board.length; i++) {
            if(isSafe(i, col, board)) {
                board[i][col] = 'Q';
                helper(col + 1, board, allBoards);
                board[i][col] = '.';
            }
        }
    }

    public static boolean isSafe(int row, int col, char[][] board) {
        // horizontal
        for(int i=0; i<board.length; i++) {
            if(board[row][i] == 'Q') return false;
        }

        // vertical
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == 'Q') return false;
        }

        // upper left
        for(int r=row, c=col; r >= 0 && c >= 0; r--, c--) {
            if(board[r][c] == 'Q') return false;
        }

        // lower left
        for(int r=row, c=col; r<board.length && c >= 0; r++, c--) {
            if(board[r][c] == 'Q') return false;
        }

        return true;
    }

    public static void saveBoard(char[][] board, ArrayList<ArrayList<String>> allBoards) {
        ArrayList<String> newBoard = new ArrayList<>();

        for(int i=0; i<board.length; i++) {
            StringBuilder row =  new StringBuilder();

            for(int j=0; j<board.length; j++) {
                if(board[i][j] == 'Q') {
                    row.append('Q');
                } else {
                    row.append('.');
                }
            }

            newBoard.add(row.toString());
        }

        allBoards.add(newBoard);
    }

    
    public static void main(String[] args) {
        int N = 13;
        ArrayList<ArrayList<String>> allBoards = solveNQueens(N);
        System.out.println(allBoards);
    }
}