class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0)
            return false;

        boolean[][][] dp = new boolean[m][n][m + n];

        int bal = grid[0][0] == '(' ? 1 : -1;

        if (bal < 0)
            return false;

        dp[0][0][bal] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                for (int k = 0; k < m + n; k++) {
                    int nb;

                    if (grid[i][j] == '(')
                        nb = k + 1;
                    else
                        nb = k - 1;

                    if (nb < 0)
                        continue;

                    if (i > 0 && dp[i - 1][j][k])
                        dp[i][j][nb] = true;

                    if (j > 0 && dp[i][j - 1][k])
                        dp[i][j][nb] = true;
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}
