class Solution {
    public int minAddToMakeValid(String s) {

    // Gredy + Counting
    int open = 0;
    int add = 0;

    for (char c : s.toCharArray()) {
        if (c == '(') {
            open++;

        }
        else {
            if (open > 0) {
                open--;

            }
            else {
                add++;
            }
        }
    }
    return add + open;
    }
}