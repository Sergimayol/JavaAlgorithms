package Backtraking;

/**
 * This class finds the first solution to the NQueen's problem
 *
 * @author Sergi
 */
public class NQueensUS {

    //Board dimension(NxN)
    private final int N;
    //Problem solving board
    private int[][] board;

    /**
     * Initialize the solution board
     *
     * @param N
     */
    public NQueensUS(int N) {
        this.N = N;
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }
    }

    private boolean isSafe(int board[][], int row, int col) {
        int i, j;
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean solveNQUtil(int board[][], int col) {
        if (col >= N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQUtil(board, col + 1) == true) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    /**
     * Solves the NxN Queens problem
     *
     * @return if the NxN board has a solution
     */
    public boolean solveNQ() {
        return solveNQUtil(board, 0) != false;
    }

    /**
     *
     * @return NxN array
     */
    public int[][] getBoard() {
        return board;
    }

}
