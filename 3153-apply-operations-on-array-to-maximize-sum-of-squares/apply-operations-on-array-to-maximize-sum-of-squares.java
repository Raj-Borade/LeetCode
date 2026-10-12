class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int mod = (int) 1e9 + 7;
        int[] bits = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) > 0) {
                    bits[i]++;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int j = 0; j < 32; j++) {
            if (bits[j] > 0) {
                num = num | (1L << j);
                bits[j]--;
            }
        }
        sum = (sum + num * num) % mod;
    }
    return (int) sum; 
    }
}