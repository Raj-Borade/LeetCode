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

        while (root != null) {

            // No left subtree
            if (root.left == null) {
                ans.add(root.val);
                root = root.right;
            }

            // Left subtree exists
            else {
                TreeNode curr = root.left;

                // Find inorder predecessor
                while (curr.right != null && curr.right != root) {
                    curr = curr.right;
                }

                // First visit: create thread
                if (curr.right == null) {
                    curr.right = root;
                    root = root.left;
                }

                // Second visit: remove thread and process root
                else {
                    curr.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
            }
        }

        return ans;
    }
}