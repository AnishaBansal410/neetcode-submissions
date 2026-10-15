class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, i, j, directions, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean search(char[][] board, int i, int j,
                          int[][] directions, String word, int idx) {

        if (idx == word.length()) {
            return true;
        }

        // Check boundaries
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length) {
            return false;
        }

        // Character does not match
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        // Mark the cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        for (int[] direction : directions) {
            int nx = i + direction[0];
            int ny = j + direction[1];

            if (search(board, nx, ny, directions, word, idx + 1)) {
                board[i][j] = temp; // Restore before returning
                return true;
            }
        }

        // Backtrack: restore the original character
        board[i][j] = temp;

        return false;
    }
}