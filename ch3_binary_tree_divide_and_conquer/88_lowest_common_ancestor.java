/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class ResultType {
    public boolean findLCA;
    public TreeNode LCA;
    public ResultType (boolean findLCA, TreeNode LCA) {
        this.findLCA = findLCA;
        this.LCA = LCA;
    }
}

public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        return helper(root, A, B).LCA;
    }
    
    private ResultType helper (TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) return new ResultType(false, null);
        if (root == A || root == B) return new ResultType(true, root);
        
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        
        if (left.findLCA && right.findLCA) return new ResultType(true, root);
        if (left.findLCA) return new ResultType(true, left.LCA);
        if (right.findLCA) return new ResultType(true, right.LCA);
        return new ResultType(false, null);
    }
}