class Solution {
    static int[] dp;

    public int fib(int n) {
        
        dp = new int[n + 1];        // idx from 0 to n 
        return solve(n);


    }
    public int solve(int n) {

        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        int ans = solve(n - 1) + solve(n - 2);
        dp[n] = ans;
        return ans;

    }
}
        // O(2^n) 

        // if (n <= 1) return n;
        // return fib(n - 1) + fib(n - 2);