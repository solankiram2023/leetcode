import java.util.*;

class Solution {

    // ✅ Class-level list to store all valid board configurations
    List<List<String>> results = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];      // Empty board initialized with 0s
        placeQueen(board, 0, n);            // Start placing queens from row 0
        return results;                     // Return all valid configurations
    }

    public boolean placeQueen(int[][] board, int r, int n) {
        if (r == n) {
            // \U0001f9e9 Convert board to list of strings
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder a = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    a.append(board[i][j] == 1 ? 'Q' : '.');
                }
                temp.add(a.toString());
            }
            results.add(temp);  // Save this valid configuration
            return false;       // Continue to find more
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, r, i, n)) {
                board[r][i] = 1;              // Place queen
                if (placeQueen(board, r + 1, n)) {
                    return true;
                }
                board[r][i] = 0;              // Backtrack
            }
        }

        return false;
    }

    public boolean isSafe(int[][] board, int i, int j, int n) {
        // Check same column
        for (int r = 0; r < i; r++) {
            if (board[r][j] == 1) return false;
        }

        // Check top-left diagonal ↖
        int x = i - 1, y = j - 1;
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1) return false;
            x--;
            y--;
        }

        // Check top-right diagonal ↗
        x = i - 1;
        y = j + 1;
        while (x >= 0 && y < n) {
            if (board[x][y] == 1) return false;
            x--;
            y++;
        }

        return true;  // No queens threaten this cell
    }
}
