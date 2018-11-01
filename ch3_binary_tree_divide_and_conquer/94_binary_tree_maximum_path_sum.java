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
    public int r2a, a2a;
    public ResultType (int r2a, int a2a) {
        this.r2a = r2a;
        this.a2a = a2a;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        System.out.print(helper(root).a2a);
        return helper(root).a2a;
    }
    
    private ResultType helper (TreeNode root) {
        if (root == null) return new ResultType(0, Integer.MIN_VALUE);
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int R2A = Math.max(left.r2a + root.val, right.r2a + root.val);
        R2A = Math.max(0, R2A);
        
        int A2A = Math.max(left.a2a, right.a2a);
        A2A = Math.max(A2A, left.r2a + root.val + right.r2a);
        return new ResultType(R2A, A2A);
    }
}