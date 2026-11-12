class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incStart = 0;
        int decStart = 0;
        int ans = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1])
                incStart = i;

            if (nums[i] >= nums[i - 1])
                decStart = i;
            ans = Math.max(ans, i - incStart + 1);

            ans = Math.max(ans, i - decStart + 1);
        }
        return ans;
        
    }
}