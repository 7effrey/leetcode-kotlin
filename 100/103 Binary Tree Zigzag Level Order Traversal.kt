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
    // Space Complexity: O(n) specifically O(n/2)
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        
        var list = LinkedList<TreeNode>()
        var tempList = LinkedList<TreeNode>()
        root?.let { list.add(it) }
        var ltr = true
        var levelItems = arrayListOf<Int>()
        
        while (list.isNotEmpty()) {
            val node = if (ltr)
                list.removeFirst()
            else
                list.removeLast()
            
            levelItems.add(node.`val`)
            if (ltr) {
                node.left?.let { tempList.add(it) }
                node.right?.let { tempList.add(it) }
            } else {
                node.right?.let { tempList.addFirst(it) }
                node.left?.let { tempList.addFirst(it) }
            }
            
            if (list.isEmpty()) {
                list = tempList
                tempList = LinkedList<TreeNode>()
                ltr = !ltr
                
                result.add(levelItems)
                levelItems = arrayListOf<Int>()
            }
        }
        
        return result
    }
}