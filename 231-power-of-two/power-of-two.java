class Solution {
    public boolean isPowerOfTwo(int n) {
        int i;
    
        if (n <= 0) return false;
        if (n == 1) return true;


        if (n % 2 == 1) return false;
        return isPowerOfTwo(n / 2);
        // while (n % 2 == 0) {
        //     n /= 2;
        // }
        // return n == 1;
    }
}       // O(log n)
        // O(1)  