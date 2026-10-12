class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            max = Math.max(max, ele);

        }
        int lo = 1, hi = max, speed = max;

        // for(int arrs : arr) {
        //     hi = Math.max(hi, arrs);

        // }
        // int ans = hi;

        while (lo <= hi) {  // O(n * log(max))   

            int mid = lo + (hi - lo) / 2;
            // long hours = 0;

            
            if (hours(mid, arr) <= h) {
                hi = mid - 1;
                speed = mid;
            }
            else
                lo = mid + 1;
            
        }
        return speed;
    }
    private long hours (int speed, int[] arr) {
        long k = 0;
        for (int ele : arr) {
            k += (ele + (long) speed - 1) / speed;
            
        }
        return k;
    }
}















//   int lo = 1, hi = 0; 

//         for(int arrs : arr) {
//             hi = Math.max(hi, arrs);

//         }
//         int ans = hi;

//         while (lo <= hi) {

//             int mid = lo + (hi - lo)/2;
//             long hours = 0;

//             for (int arrs : arr) {
//                 hours += (arrs + mid - 1)/mid;
//             }
//             if (hours <= h) {
//                 ans = mid;
//                 hi = mid - 1;
//             }
//             else {
//                 lo = mid + 1;
//             }
//         }
//         return ans;
//     }