/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun flatten(root: TreeNode?): Unit {
        flat(root);
    }

    // Time Complexity: O(n) where n is the number of TreeNode
    // Space Complexity: O(1)
    private fun flat(root: TreeNode?): Pair<TreeNode?, TreeNode?> {
        if (root == null)
            return Pair(null, null);

        var (lHead, lTail) = flat(root?.left);
        var (rHead, rTail) = flat(root?.right);

        var r: TreeNode? = null
        root?.left = null;
        if (lHead != null) {
            root?.right = lHead;
            if (lTail != null)
                lTail?.right = rHead;
            else
                lHead?.right = rHead;
            
            r = if (rTail != null) rTail else if (rHead != null ) rHead else if (lTail != null) lTail else lHead;
        } else {
            root?.right = rHead;
            r = if (rTail != null) rTail else rHead;
        }
        return Pair(root, r);
    }
}