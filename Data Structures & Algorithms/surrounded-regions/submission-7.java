class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Top and bottom rows
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O' && !visited[0][col]) {
                dfs(board, directions, visited, 0, col);
            }

            int lastRow = board.length - 1;
            if (board[lastRow][col] == 'O' && !visited[lastRow][col]) {
                dfs(board, directions, visited, lastRow, col);
            }
        }

        // Left and right columns
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O' && !visited[row][0]) {
                dfs(board, directions, visited, row, 0);
            }

            int lastCol = board[0].length - 1;
            if (board[row][lastCol] == 'O' && !visited[row][lastCol]) {
                dfs(board, directions, visited, row, lastCol);
            }
        }

        // Flip surrounded O cells; restore boundary-connected cells.
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int[][] directions,
                     boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        board[row][col] = '#'; // Mark this O as safe.

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (nextRow >= 0 && nextRow < board.length
                    && nextCol >= 0 && nextCol < board[0].length
                    && !visited[nextRow][nextCol]
                    && board[nextRow][nextCol] == 'O') {
                dfs(board, directions, visited, nextRow, nextCol);
            }
        }
    }
}