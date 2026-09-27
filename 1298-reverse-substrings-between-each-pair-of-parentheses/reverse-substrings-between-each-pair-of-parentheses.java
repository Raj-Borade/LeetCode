class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(curr.toString());
                curr.setLength(0);
            }
            else if (ch == ')') {
                curr.reverse();
                curr.insert(0, st.pop());

            }
            else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}




// Firstly, keep the current characters in curr and use a stack to save the string before every (.
// When we get (, push the current string into the stack and start a new substring.
// Keep adding normal characters to curr.
// When we get ), reverse the current substring because the innermost part must be reversed first.
// Then attach the saved outer string from the stack before the reversed substring.
// After processing everything, curr contains the answer without parentheses.

// TC: O(N²) worst case
// SC: O(N)