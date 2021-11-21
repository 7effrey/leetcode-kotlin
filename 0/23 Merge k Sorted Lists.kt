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
    // Time Complexity: O(n log k)
    // Space Complexity: O(k) for minHeap
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val minHeap = PriorityQueue<ListNode>(Comparator { t1, t2 ->
            t1.`val` - t2.`val`
        })
        // O(k)
        lists.forEach { node -> 
            node?.let {
                // O(log k)
                minHeap.add(it)
            }
        }
        
        val dummyHead = ListNode(-1)
        var tail = dummyHead
        // O(n)
        while (minHeap.isNotEmpty()) {
            // O(log k)
            val current = minHeap.poll()
            val next = current?.next
            next?.let {
                // O(log k)
                minHeap.add(it)
            }
            tail?.next = current
            tail = current
        }
        tail?.next = null
        return dummyHead.next
    }
}