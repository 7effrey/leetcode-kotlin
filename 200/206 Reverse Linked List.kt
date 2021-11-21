/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        // return reverseListLoop(head)
        return reverseListRecursive(head, null)
    }
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private fun reverseListLoop(head: ListNode?): ListNode? {
        var cur = head
        var newHead: ListNode? = null
        while (cur != null) {
            val prev = cur
            cur = cur?.next
            
            prev?.next = newHead
            newHead = prev
        }
        return newHead
    }
    
    // Time Complexity: O(n)
    // Space Complexity: O(n) because of recursion memory stack
    private fun reverseListRecursive(head: ListNode?, subHead: ListNode?): ListNode?  {
        if (head == null)
            return subHead
        var next = head?.next
        head?.next = subHead
        return reverseListRecursive(next, head)
    }
}