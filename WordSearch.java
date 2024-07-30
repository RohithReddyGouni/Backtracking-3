// Time Complexity: O(N * 3^L), where N is the total number of cells in the board and
// L is the length of the word.
// Space Complexity: O(L), where L is the length of the word, due to the recursion stack.


class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, rows, cols, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int rows, int cols, int k) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(k)) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }

        char originalValue = board[row][col];
        board[row][col] = '$';

        boolean charCheck = dfs(board, word, row, col + 1, rows, cols, k + 1) ||
                dfs(board, word, row, col - 1, rows, cols, k + 1) ||
                dfs(board, word, row + 1, col, rows, cols, k + 1) ||
                dfs(board, word, row - 1, col, rows, cols, k + 1);

        board[row][col] = originalValue;

        return charCheck;
    }
}
