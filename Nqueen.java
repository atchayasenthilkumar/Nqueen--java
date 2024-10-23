import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4; // You can change this value to test with different board sizes
        List<List<String>> solutions = solveNQueens(n);
        System.out.println("Total solutions for " + n + " queens: " + solutions.size());
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        solveNQueensHelper(n, 0, new int[n], results);
        return results;
    }

    private static void solveNQueensHelper(int n, int row, int[] queens, List<List<String>> results) {
        if (row == n) {
            results.add(generateBoard(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col; // Place queen
                solveNQueensHelper(n, row + 1, queens, results);
                // No need to remove the queen; we will overwrite it in the next iteration
            }
        }
    }

    private static boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || 
                queens[i] - i == col - row || 
                queens[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private static List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder(".".repeat(n));
            row.setCharAt(queens[i], 'Q');
            board.add(row.toString());
        }
        return board;
    }
}
