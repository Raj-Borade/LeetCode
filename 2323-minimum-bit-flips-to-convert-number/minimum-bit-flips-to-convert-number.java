class Solution {
    public int minBitFlips(int start, int goal) {
        // 1010 -> 0111 ==> 3 flips ... ---0010
        int xor = start ^ goal;

        return Integer.bitCount(xor);
    }
}