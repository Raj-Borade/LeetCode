
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (path(i, j, m-1, n-1, new boolean[m][n], board, "", word))
                    return true;

        return false;
    }

    private boolean path(int r, int c, int er, int ec,
                         boolean[][] visited, char[][] board,
                         String s, String word) {
        if (r < 0 || c < 0 || r > er || c > ec ||
            visited[r][c] || s.length() >= word.length() ||
            board[r][c] != word.charAt(s.length()))
            return false;

        s += board[r][c];

        if (s.equals(word)) return true;

        visited[r][c] = true;

        boolean found = path(r, c-1, er, ec, visited, board, s, word) ||
                        path(r-1, c, er, ec, visited, board, s, word) ||
                        path(r, c+1, er, ec, visited, board, s, word) ||
                        path(r+1, c, er, ec, visited, board, s, word);

        visited[r][c] = false;
        return found;
    }
}
