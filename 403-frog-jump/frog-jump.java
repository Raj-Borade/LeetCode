class Solution {
    public boolean canCross(int[] stones) {
        return stones[1] == 1 && solve(1, 1, stones, new Boolean[stones.length][stones.length]);
    }
    boolean solve(int i, int k, int[] stones, Boolean[][] dp) {
        if (i == stones.length - 1) return true;

        if (dp[i][k] != null) return dp[i][k];
        for (int j = i + 1; j < stones.length; j++) {
            int d = stones[j] - stones[i];
            if (d > k+ 1) break;
            if (d >= k - 1 && d > 0 && solve(j, d, stones, dp))
                return dp[i][k] = true;
        }
        return dp[i][k] = false;
        
    }
}