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
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var newHead: ListNode? = null
        var newTail: ListNode? = null
        var subHead: ListNode? = null
        var subTail: ListNode? = null
        
        var current = head
        var counter = 0
        while (current != null) {
            var temp = current
            current = current?.next
            counter++
            
            if (subHead == null) {
                subHead = temp
                subTail = subHead
                subTail?.next = null
            } else {
                temp?.next = subHead
                subHead = temp
            }
            
            if (counter == k) {
                counter = 0
                if (newHead == null) {
                    newHead = subHead
                    newTail = subTail
                } else {
                    newTail?.next = subHead
                    newTail = subTail
                }
                
                subHead = null
                subTail = null
            }
        }
        
        current = subHead
        subHead = null
        while (current != null) {
            var temp = current
            current = current?.next
            
            if (subHead == null) {
                subHead = temp
                subTail = subHead
                subTail?.next = null
            } else {
                temp?.next = subHead
                subHead = temp
            }
        }
        newTail?.next = subHead
        newTail = subTail
        
        return newHead
    }
}