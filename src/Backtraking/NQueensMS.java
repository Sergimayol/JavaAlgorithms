package Backtraking;

import java.util.ArrayList;

/**
 * This class finds all solutions for the NQueen's problem
 *
 * @author Sergi
 */
public class NQueensMS {

    //Solution counter
    private static int account = 0;
    //List with all the problem solutions 
    private ArrayList solutions;
    //Problem solving board
    private int board[][];
    //Board dimension(NxN)
    private final int n;

    /**
     * Initialize the solution board
     *
     * @param n
     */
    public NQueensMS(int n) {
        this.n = n;
        this.solutions = new ArrayList();
        this.board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
    }

    /**
     * Solves the NxN Queens problem
     */
    public void solveNQMS() {
        dfs(board, n, 0);
        System.out.println("\nTotal number of solutions: " + account + "\n");
    }

    private void dfs(int board[][], int n, int row) {
        if (row == n) {
            account++;
            System.out.println("\nSolution: " + account);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    this.solutions.add(board[i][j]);
                }
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(board, i, row)) {
                board[i][row] = 1;
                dfs(board, n, row + 1);
                board[i][row] = 0;
            }
        }
    }

    private boolean check(int board[][], int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == 1) {
                return false;
            }
            if (board[i][y] == 1) {
                return false;
            }
            for (int j = 0; j < board.length; j++) {
                if (i + j == x + y && board[i][j] == 1) {
                    return false;
                }
                if (i - j == x - y && board[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @return total number of solutions
     */
    public static int getAccount() {
        return account;
    }

    /**
     *
     * @return list of all solutions
     */
    public ArrayList getSolutions() {
        return solutions;
    }

}
