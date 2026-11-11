class Solution {
    public char repeatedCharacter(String s) {
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
            if (s.indexOf(ch) != i) {
                return ch;
            }
        }
        return ' ';
    }
}