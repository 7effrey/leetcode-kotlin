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
    // Time Complexity: O(n) where n is the lenght of linked list
    // Space Complexity: O(1)
    fun swapPairs(head: ListNode?): ListNode? {
        var newHead: ListNode? = null;
        var newTail: ListNode? = null;
        var first: ListNode? = null;
        var second: ListNode? = null;

        var t = head;
        while (t != null) {
            if (first == null) {
                first = t;
                t = t?.next;
            } else if (second == null) {
                second = t;
                t = t?.next;

                newTail?.next = second;
                second?.next = first;
                first?.next = null;
                if (newHead == null)
                    newHead = second;
                newTail = first;

                first = null;
                second = null;
            }
        }
        if (first != null) {
            newTail?.next = first;
            if (newHead == null)
                newHead = first;
        }

        return newHead;
    }
}