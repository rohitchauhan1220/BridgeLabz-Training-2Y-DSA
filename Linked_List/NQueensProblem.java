import java.util.*;

public class NQueensProblem {

    public static boolean isSafe(int[][] board, int row, int col, int N) {
        // Check this row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueensUtil(int[][] board, int col, int N) {
        // Base case: If all queens are placed
        if (col >= N) {
            return true;
        }

        // Consider this column and try placing queen in all rows
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                // Place queen
                board[i][col] = 1;

                // Recur to place rest of the queens
                if (solveNQueensUtil(board, col + 1, N)) {
                    return true;
                }

                // If placing queen in board[i][col] doesn't lead to a solution,
                // then remove queen from board[i][col]
                board[i][col] = 0; // BACKTRACK
            }
        }

        // If queen cannot be placed in any row in this column, return false
        return false;
    }

    public static void solveNQueens(int N) {
        int[][] board = new int[N][N];

        if (solveNQueensUtil(board, 0, N)) {
            printBoard(board, N);
        } else {
            System.out.println("Solution does not exist");
        }
    }

    public static void printBoard(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 4;
        System.out.println("N-Queens solution for N = " + N + ":");
        solveNQueens(N);

        System.out.println("\nN-Queens solution for N = 8:");
        solveNQueens(8);
    }
}