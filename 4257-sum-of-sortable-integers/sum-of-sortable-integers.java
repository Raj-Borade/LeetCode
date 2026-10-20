class Solution {
public int sortableIntegers(int[] nums)   {     
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

            for (int i = 0; i < n; i += k) {
                if (!check(nums, arr, i, k)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int[] arr, int start, int k) {
        int[] lps = new int[k];

        for (int i = 1, len = 0; i < k;) {
            if (arr[start + i] == arr[start + len]) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        for (int i = 0, j = 0; i < 2 * k - 1; i++) {
            int val = nums[start + i % k];

            while (j > 0 && val != arr[start + j]) {
                j = lps[j - 1];
            }

            if (val == arr[start + j]) {
                j++;
            }

            if (j == k) {
                return true;
            }
        }

        return false;
    }
}
