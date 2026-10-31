class Solution {
    public int uniquePaths(int[][] grid) {
        int MOD = 1000000007;
        int m = grid.length;
        int n = grid[0].length;
        
        long[][] dp = new long[m][n];
        dp[0][0] = 1;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dp[r][c] == 0) continue;
                
                if (c + 1 < n) {
                    int cr = r, cc = c + 1;
                    int dir = 1;
                    while (cr < m && cc < n && grid[cr][cc] == 1) {
                        if (dir == 1) {
                            cr++;
                            dir = 0;
                        } else {
                            cc++;
                            dir = 1;
                        }
                    }
                    if (cr < m && cc < n) {
                        dp[cr][cc] = (dp[cr][cc] + dp[r][c]) % MOD;
                    }
                }
                
                if (r + 1 < m) {
                    int cr = r + 1, cc = c;
                    int dir = 0;
                    while (cr < m && cc < n && grid[cr][cc] == 1) {
                        if (dir == 1) {
                            cr++;
                            dir = 0;
                        } else {
                            cc++;
                            dir = 1;
                        }
                    }
                    if (cr < m && cc < n) {
                        dp[cr][cc] = (dp[cr][cc] + dp[r][c]) % MOD;
                    }
                }
            }
        }
        
        return (int) dp[m - 1][n - 1];
    }
}