class Solution {
    public int minimizeSum(int[] nums) {
        // Brute Force

        // int n = nums.length;
        // if (n <= 3) 
        //     return 0;

        //     Arrays.sort(nums);

        //    ans = Math.min(ans, nums[n - 1] - nums[2];
        //    ans = Math.min(ans, nums[n - 3] - nums[0];
        //    ans = Math.min(ans, nums[n - 2] - nums[1];

        // return ans;  O(n log n)

        // return Math.min(case1, Math.min(case2, case3));

        //Greedy on sorted array

        int n = nums.length;

        if (n <= 3) return 0;

        Arrays.sort(nums);

        return Math.min(
            nums[n - 1] - nums[2],
            Math.min(
                nums[n - 2] - nums[1], 
                nums[n - 3] - nums[0]
            )
        );

    }
}