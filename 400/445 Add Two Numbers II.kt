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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        // return addTwoNumbersReverse(l1, l2)
        return addTwoNumbersNoReverse(l1, l2)
    }
    
    // Time Complexity: O(n + m)
    // Space Complexity: O(max(n,m))
    fun addTwoNumbersNoReverse(l1: ListNode?, l2: ListNode?): ListNode? {
        // O(n)
        var length1 = count(l1)
        // O(m)
        var length2 = count(l2)
        var c1 = l1
        var c2 = l2
        var head: ListNode? = null
        // O(max(n,m))
        while (c1 != null || c2 != null) {
            val num1 = c1?.`val` ?: 0
            val num2 = c2?.`val` ?: 0
            var newNode = if (length1 == length2) {
                c1 = c1?.next
                c2 = c2?.next
                length1--
                length2--
                ListNode(num1 + num2)
            } else if (length1 > length2) {
                c1 = c1?.next
                length1--  
                ListNode(num1)
            } else {
                c2 = c2?.next
                length2--
                ListNode(num2)
            }
            
            newNode?.next = head
            head = newNode
        }
        
        c1 = head
        var carry = 0
        var newHead: ListNode? = null
        // O(max(n,m))
        while (c1 != null) {
            c2 = c1
            c1 = c1?.next
            
            var total = (c2?.`val` ?: 0) + carry
            carry = total / 10
            total = total.rem(10)
            c2?.`val` = total
            
            c2?.next = newHead
            newHead = c2
        }
        if (carry > 0) {
            val newNode = ListNode(carry)
            newNode?.next = newHead
            newHead = newNode
        }
        return newHead
    }
    
    private fun count(list: ListNode?): Int {
        var length1 = 0
        var c1 = list
        while (c1 != null) {
            length1++
            c1 = c1?.next
        }
        return length1
    }
    
    // Time Complexity: O(n + m)
    // Space Complexity: O(max(n,m))
    fun addTwoNumbersReverse(l1: ListNode?, l2: ListNode?): ListNode? {
        // O(n)
        var p1 = reverse(l1)
        // O(m)
        var p2 = reverse(l2)
        var head: ListNode? = null
        var tail: ListNode? = null
        var carry = 0
        // O(max(n,m))
        while (p1 != null || p2 != null || carry > 0) {
            var total = (p1?.`val` ?: 0) + (p2?.`val` ?: 0) + carry
            carry = total / 10
            total = total.rem(10)
            
            val newNode = ListNode(total)
            if (head == null) {
                head = newNode
                tail = head
            } else {
                newNode?.next = head
                head = newNode
            }
            
            p1 = p1?.next
            p2 = p2?.next
        }
        return head
    }
    
    private fun reverse(l: ListNode?): ListNode? {
        var head: ListNode? = null
        var tail: ListNode? = null
        var current = l
        while (current != null) {
            val now = current
            current = current?.next
            
            if (head == null) {
                head = now
                tail = head
                tail?.next = null
            } else {
                now?.next = head
                head = now
            }
        }
        return head
    }
}