/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return root;
        
        if (root.val > p.val) {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        } else {
            return inorderSuccessor(root.right, p);
        }
    }
}