class Solution {
    public int climbStairs(int n) {

            if (n <= 2) return n;

            int a = 1, b = 2;

            for (int i = 3; i <= n; i++) {
                int c = a + b;
                a = b;
                b = c;
            }

            return b;




        //Easiest soln but time limit exceeds due to O(2^n) TIME COMPLEXITY (recursion)
        // if (n == 1) return 1;
        // if (n == 2) return 2;
        // if (n <= 2) return n;
        // return climbStairs(n-1) + climbStairs(n-2);
    }
}