class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);

        int moves = 0;
        int min = nums[0];

        for (int num : nums) {
            moves += num - min;
        }

        return moves;
    }
}