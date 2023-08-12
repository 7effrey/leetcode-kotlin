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
    // Time Complexity: O(n) where n is the number of ListNode
    // Space Complexity: O(n) where n is the number of ListNode
    fun hasCycle(head: ListNode?): Boolean {
        val table = hashSetOf<ListNode?>();

        var node = head;
        while (node != null) {
            if (table.contains(node)) {
                return true;
            }
            table.add(node);
            node = node?.next;
        }
        return false;
    }

    // Time Complexity: O(n) where n is the number of ListNode
    // Space Complexity: O(1)
    fun hasCycle2(head: ListNode?): Boolean {
        var node = head?.next;
        var node2 = head?.next?.next;
        while (node != null && node2 != null) {
            if (node == node2)
                return true;
            node = node?.next;
            node2 = node2?.next?.next;
        }
        return false;
    }
}