class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++)
                if (path(i, j, 0, board, word, visited))
                    return true;

            return false;
    }

    private boolean path(int r, int c, int idx, char[][] board, String word, boolean[][] visited) {
        if (idx == word.length()) return true;

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] || board[r][c] != word.charAt(idx))
            return false;

            visited[r][c] = true;

            boolean found = path(r, c - 1, idx + 1, board, word, visited) ||
            path(r - 1, c, idx + 1, board, word, visited) ||
            path(r, c + 1, idx + 1, board, word, visited) ||
            path(r + 1, c, idx + 1, board, word, visited);


            visited[r][c] = false;
            return found;
    }
}