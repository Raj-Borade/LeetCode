
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }

        char min = 'z';
        char max = 'a';
        int minCount = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch < min) {
                min = ch;
                minCount = 1;
            } else if (ch == min) {
                minCount++;
            }

            if (ch > max) {
                max = ch;
                maxCount = 1;
            } else if (ch == max) {
                maxCount++;
            }
        }

        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        if (s.charAt(0) == max && maxCount == 1 &&
            s.charAt(n - 1) == min && minCount == 1) {
            return 3;
        }

        return 2;
    }
}
