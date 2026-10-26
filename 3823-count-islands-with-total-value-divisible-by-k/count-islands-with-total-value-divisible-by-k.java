class Solution {
    public int countIslands(int[][] grid, int k) {

        int count = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    long sum = dfs(grid, i , j);

                    if (sum % k == 0)
                        count ++;
                }
            }
        }
    
    return count;
}
    private long dfs(int[][] g, int i, int j) {


        int m = g.length;
        int n = g[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || g[i][j] == 0) return 0;

        long sum = g[i][j];
        g[i][j] = 0;

       sum += dfs(g, i + 1, j);
       sum += dfs(g, i - 1, j);
       sum += dfs(g, i, j + 1);
       sum += dfs(g, i, j - 1);

        return sum;
    }
}