class Solution {
    public boolean checkString(String s) {
        
        boolean A = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                A = true;

            } else if (A) {
                return false;

            }
        }

    return true;
}
}