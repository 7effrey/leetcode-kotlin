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
    
    private var diameter = 1
    
    // Time Complexity: O(n) where n is the number of TreeNodes
    // Space Complexity: O(n) for recursive stack
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        diameter = 1
        dfs(root)
        return diameter - 1
    }
    
    private fun dfs(root: TreeNode?): Int {
        if (root == null)
            return 0
        val left = dfs(root?.left)
        val right = dfs(root?.right)
        diameter = Math.max(diameter, left + right + 1)
        return Math.max(left, right) + 1
    }
}