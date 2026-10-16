class Solution {
    int M = 1000000007;
    long[] s, q, l;

    public int sumCounts(int[] a) {
        int n = a.length, last[] = new int[100001];
        s = new long[4*n]; q = new long[4*n]; l = new long[4*n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            upd(1, 0, n-1, last[a[i]], i);
            ans = (ans + q[1]) % M;
            last[a[i]] = i+1;
        }
        return (int) ans;
    }

    void apply(int p, int len, long v) {
        q[p] = (q[p] + 2*v*s[p] + v*v*len) % M;
        s[p] = (s[p] + v*len) % M;
        l[p] += v;
    }

    void upd(int p, int lo, int hi, int x, int y) {
        if (x <= lo && hi <= y) { apply(p, hi-lo+1, 1); return; }
        int m = (lo+hi)/2;
        if (l[p] != 0) {
            apply(p*2, m-lo+1, l[p]);
            apply(p*2+1, hi-m, l[p]);
            l[p] = 0;
        }
        if (x <= m) upd(p*2, lo, m, x, y);
        if (y > m) upd(p*2+1, m+1, hi, x, y);
        s[p] = (s[p*2]+s[p*2+1]) % M;
        q[p] = (q[p*2]+q[p*2+1]) % M;
    }
}


        // TLE 
    //     int n = nums.length;

    //     long ans = 0, mod = 1_000_000_007;

    //     for (int i = 0; i < n; i++) {
    //         HashSet<Integer> set = new HashSet<>();

    //         for (int j = i; j < n; j++) {
    //             set.add(nums[j]);
    //             long count = set.size();
    //             ans = (ans + count * count) % mod;
    //         }
    //     }
    //     return (int) ans;
    // }