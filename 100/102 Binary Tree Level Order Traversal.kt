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
    // Space Complexity: O(n) specifically O(n/2) because the max TreeNodes at the highest level is n/2
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = arrayListOf<ArrayList<Int>>()
        
        var queue = LinkedList<TreeNode>()
        var tempQueue = LinkedList<TreeNode>()
        root?.let { queue.add(it) }
        var levelResult = arrayListOf<Int>()
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            
            levelResult.add(node.`val`)
            node.left?.let { tempQueue.add(it) }
            node.right?.let { tempQueue.add(it) }
            
            if (queue.isEmpty()) {
                queue = tempQueue
                tempQueue = LinkedList<TreeNode>()
                
                result.add(levelResult)
                levelResult = arrayListOf<Int>()
            }
        }
        
        return result
    }
}