class Solution {
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        // Sort array in ascending order: O(n log n)
        intervals.sortWith(object: Comparator<IntArray> {
            override fun compare(t1: IntArray, t2: IntArray): Int {
                return t1[0] - t2[0]
            }
        })
        
        val stack = Stack<IntArray>()
        // O(n)
        intervals.forEach { interval ->
            if (stack.isEmpty()) {
                stack.push(interval)
            } else {
                val lastInterval = stack.peek()
                if (interval[0] <= lastInterval[1]) {
                    if (lastInterval[1] <= interval[1]) {
                        stack.pop()
                        stack.push(intArrayOf(lastInterval[0], interval[1]))
                    }
                } else {
                    stack.push(interval)
                }
            }
        }
        
        // O(n)
        val dummy = intArrayOf()
        val result = Array<IntArray>(stack.size) { i -> dummy }
        for (i in stack.size - 1 downTo 0) {
            result[i] = stack.pop()
        }
        return result
    }
}