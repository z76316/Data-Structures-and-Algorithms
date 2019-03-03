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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */


public class BSTIterator { 
    private Stack<TreeNode> stack = new Stack<TreeNode>(); 
    /* 
    * @param root: The root of binary tree. 
    */public BSTIterator(TreeNode root) { 
        // find the smallest node in the tree, push all the nodes we met() into stack 
        while (root != null) { 
            stack.push(root); 
            root = root.left; 
        } 
    } 
 
    /* 
     * @return: True if there has next node, or false 
     */ 
    public boolean hasNext() { 
        return !stack.isEmpty(); 
    } 
 
    /* 
     * @return: return next node 
     */ 
    public TreeNode next() { 
        TreeNode node = stack.pop(); 
        TreeNode cur = node; 
        //if cur.right is not null, in-order traverse it 
        if (cur.right != null) { 
            cur = cur.right; 
            while (cur != null) { 
                stack.push(cur); 
                if (cur.left != null) { 
                    cur = cur.left; 
                } else { 
                    break; 
                } 
            } 
        } 
        return node; 
    } 
}