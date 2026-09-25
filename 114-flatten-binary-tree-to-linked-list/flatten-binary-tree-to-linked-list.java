/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode pred = curr.left;
                while (pred.right != null) 
                    pred = pred.right;

                    pred.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                    curr = curr.right;

            }
            else curr = curr.right;
    }
    }
}


//  ................................................................................

        // if (root == null) return;

        // TreeNode lst = root.left;
        // TreeNode rst = root.right;
        // root.left = null;
        // flatten(lst);
        // flatten(rst);
        // root.right = lst;
        // TreeNode last = root;
        // while (last.right != null) last = last.right;
        // last.right = rst;





//.....................................................................

    //     ArrayList<TreeNode> arr = new ArrayList<>();
    //     if (root == null) return;
    //     dfs(root, arr);
    //     for (int i = 0; i < arr.size() - 1; i++) {
    //         TreeNode a = arr.get(i);
    //         TreeNode b = arr.get(i + 1);
    //         a.right = b;
    //         a.left = null;

    //     };

    //     TreeNode last = arr.get(arr.size() - 1);
    //     last.left = null;
    //     last.right = null;
    // }

    // private static void dfs(TreeNode root, ArrayList<TreeNode> arr) {
    //     if (root == null) return;
    //     arr.add(root);
    //     dfs(root.left, arr);
    //     dfs(root.right, arr);




















// ..............................................................................................



//     Morris Inorder Traversal using the inorder predecessor.

// That distinction sounds much stronger in an interview.

// How I would explain it

// Suppose the interviewer asks “Validate a Binary Search Tree.”

// You can say:

// “For a BST, its inorder traversal produces values in strictly increasing order.
// I can perform inorder traversal using Morris Traversal, which avoids both recursion and an explicit stack.
// Morris Traversal uses the inorder predecessor of the current node to create a temporary thread back to the current node.”

// Then explain the two cases.

// Case 1 — No left subtree
// if (curr.left == null)

// The current node is ready to be processed.

// if (curr.val <= prev)
//     return false;

// prev = curr.val;
// curr = curr.right;
// Case 2 — Left subtree exists

// Find the inorder predecessor:

// TreeNode pred = curr.left;

// while (pred.right != null && pred.right != curr) {
//     pred = pred.right;
// }

// Then there are two possibilities.

// Thread doesn't exist:

// if (pred.right == null)

// Create it:

// pred.right = curr;
// curr = curr.left;

// This allows us to return to curr after finishing its left subtree.

// Thread already exists:

// else

// We've finished the left subtree.

// So remove the thread:

// pred.right = null;

// Then process curr:

// if (curr.val <= prev)
//     return false;

// prev = curr.val;
// curr = curr.right;
// TC, SC and AS

// This is where you should be precise.

// Time Complexity

// O(N)

// Even though we have an inner loop to find the predecessor, the total work remains O(N), because the temporary predecessor links cause each relevant edge to be traversed only a constant number of times.

// Auxiliary Space

// O(1)