// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
        
//         ArrayList<Integer> ans = new ArrayList<>();
//         Stack<TreeNode> st = new Stack<>();

//         // if (root == null) return new ArrayList<>();
//         TreeNode curr = root;

//         while (st.size() > 0 || curr != null) {
//             if (curr != null) {
//                 if (curr.left != null) {
//                     st.push(curr);
//                     curr = curr.left;
//                 }
//                 else {
//                     ans.add(curr.val);
//                     curr = curr.right;
//                 }
//             }
//             else {  // curr == null
//                 TreeNode top = st.pop();
//                 ans.add(top.val);
//                 curr = top.right;
//             }
//         }
//         return ans;


//     }
// }


//  Morris Traversal

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {

            if (curr.left != null) {

                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } 
                else {
                    pred.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }

            } 
            else {
                ans.add(curr.val);
                curr = curr.right;
            }
        }

        return ans;
    }
}