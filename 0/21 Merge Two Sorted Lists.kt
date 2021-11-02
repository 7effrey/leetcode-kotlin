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
    // Time Complexity: O(n) where n is the total number of nodes in l1 & l2
    // Space Complexity: O(1)
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var c1 = l1
        var c2 = l2
        var head: ListNode? = null
        var tail: ListNode? = null
        while (c1 != null && c2 != null) {
            var newNode: ListNode? = null
            if (c1.`val` <= c2.`val`) {
                newNode = c1
                c1 = c1?.next
            } else {
                newNode = c2
                c2 = c2?.next
            }
            if (head == null) {
                head = newNode
                tail = head
            } else {
                tail?.next = newNode
                tail = tail?.next
            }
        }
        var newNode = c1 ?: c2
        while (newNode != null) {
            if (head == null) {
                head = newNode
                tail = head
            } else {
                tail?.next = newNode
                tail = tail?.next
            }
            newNode = newNode?.next
        }
        
        return head
    }
}