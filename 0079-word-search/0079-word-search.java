/**
Backtracking using DFS 
We are given a 2D board of characters and a word. Our task is to determine if
the word exists in the grid. The word must be constructed from sequentially adjacent cells
(horizontally or vertically), and the same letter cell may not be used more than once.

Steps:
1. Loop through every cell in the board.
2. Start a DFS from each cell to match the word starting from that cell.
3. During DFS:
   - If the character matches, mark the cell as visited.
   - Recursively explore all 4 directions.
   - Restore the cell's value (backtrack) after the exploration.
4. If any DFS call returns true, the word exists in the board.
*/
class Solution {

    private char[][] board;
    private int ROWS;
    private int COLS;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        // Loop over every cell to try and find the word starting from each position
        for (int row = 0; row < this.ROWS; ++row) {
            for (int col = 0; col < this.COLS; ++col) {
                if (this.backtrack(row, col, word, 0)) return true;
            }
        }

        // If none of the paths returned true, the word does not exist
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
        // ✅ Base case: all characters matched
        if (index == word.length()) return true;

        // ✅ Boundary and mismatch check
        if (row < 0 || row >= this.ROWS || col < 0 || col >= this.COLS ||
            this.board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited by changing the value
        char temp = this.board[row][col];
        this.board[row][col] = '#';

        // Direction vectors: right, down, left, up
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};

        // Explore all 4 directions
        for (int d = 0; d < 4; ++d) {
            int newRow = row + rowOffsets[d];
            int newCol = col + colOffsets[d];

            if (this.backtrack(newRow, newCol, word, index + 1)) {
                return true;
            }
        }

        // Unmark the cell (backtrack)
        this.board[row][col] = temp;

        return false;
    }
}
