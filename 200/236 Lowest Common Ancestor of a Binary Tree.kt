/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    
    private var answer: TreeNode? = null
    
    // Time Complexity: O(n) where n is the number of TreeNodes
    // Space Complexity: O(n) for recursive DFS stack of skewed tree like linked list
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        answer = null
        lcaRecursive(root, p, q)
        return answer
    }
    
    private fun lcaRecursive(root: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {
        if (root == null)
            return false
        val current = if (root == p || root == q) 1 else 0
        val left = if (lcaRecursive(root?.left, p, q)) 1 else 0
        val right = if (lcaRecursive(root?.right, p, q)) 1 else 0
        val total = current + left + right
        if (total == 2) {
            answer = root
            return true
        } else if (total == 1) {
            return true
        } else return false
    }
}