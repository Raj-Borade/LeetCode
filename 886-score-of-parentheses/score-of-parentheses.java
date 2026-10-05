class Solution {
    public int scoreOfParentheses(String s) {
        
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                st.push(0);
            }
            else {
                int a = st.pop();
                int b = st.pop();

                if (a == 0)
                    a = 1;
                    else 
                        a = 2 * a;

                        st.push(b + a);
            }
        }
    return st.pop();
    }
}