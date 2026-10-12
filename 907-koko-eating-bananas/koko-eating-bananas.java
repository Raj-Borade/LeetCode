class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int lo = 1, hi = 0;

        for(int arrs : arr) {
            hi = Math.max(hi, arrs);

        }
        int ans = hi;

        while (lo <= hi) {

            int mid = lo + (hi - lo)/2;
            long hours = 0;

            for (int arrs : arr) {
                hours += (arrs + mid - 1)/mid;
            }
            if (hours <= h) {
                ans = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}

