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
    // Time Complexity: O(n) where n is the number of TreeNodes
    // Space Complexity: O(n)
    fun isSymmetric(root: TreeNode?): Boolean {
        var queue = LinkedList<TreeNode?>()
        root?.let { queue.add(it) }
        
        var levelNodes = LinkedList<TreeNode?>()
        while (queue.isNotEmpty()) {
            queue.removeFirst()?.let { node ->
                levelNodes.add(node.left)
                levelNodes.add(node.right)
            }
            
            if (queue.isEmpty()) {
                var left = levelNodes.iterator()
                var right = levelNodes.descendingIterator()
                while (left.hasNext() && right.hasNext()) {
                    if (left.next()?.`val` != right.next()?.`val`)
                        return false
                }
                
                queue = levelNodes
                levelNodes = LinkedList<TreeNode?>()
            }
        }
        
        return true
    }
}