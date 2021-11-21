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
    // Time Complexity: O(n) where n is the max of l1.size or l2.size
    // Space Complexity: O(n)
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var p1 = l1
        var p2 = l2
        val head = ListNode(-1)
        var result: ListNode? = head
        var additional = 0
        while (p1 != null || p2 != null || additional > 0) {
            var total = (p1?.`val` ?: 0) + (p2?.`val` ?: 0) + additional
            additional = total / 10
            total = total.rem(10)
            
            result?.next = ListNode(total)
            result = result?.next
            
            p1 = p1?.next
            p2 = p2?.next
        }
        return head.next
    }
}