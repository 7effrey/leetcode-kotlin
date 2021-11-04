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
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    fun sumOfLeftLeaves(root: TreeNode?, isLeft: Boolean = false): Int {
        if (root == null)
            return 0
        val left = sumOfLeftLeaves(root?.left, true)
        val right = sumOfLeftLeaves(root?.right)
        val current = if (isLeft && root?.left == null && root?.right == null) root!!.`val` else 0
        return current + left + right
    }
}
/*
[1,2,3,4,5, null, null, null, 8]
*/