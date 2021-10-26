/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    fun copyRandomList(node: Node?): Node? {
        
        val mapping = hashMapOf<Node, Node>()
        
        var copyHead: Node? = null
        var copyTail: Node? = null
        
        var iterator = node
        while (iterator != null) {
            iterator?.let { current ->
                if (mapping[current] == null) {
                    mapping[current] = Node(current.`val`)
                }
                var newNode = mapping[current]!!
                
                if (copyHead == null) {
                    copyHead = newNode
                    copyTail = newNode
                } else {
                    copyTail?.next = newNode
                    copyTail = copyTail?.next
                }
                
                current.random?.let { random ->
                    if (mapping[random] == null) {
                        mapping[random] = Node(random.`val`)
                    }
                    newNode.random = mapping[random]!!
                }
                
                iterator = current.next
            }
        }
        
        
        return copyHead
    }
}