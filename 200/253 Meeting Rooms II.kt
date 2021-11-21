class Solution {
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        // O(n log n) to sort by start time
        intervals.sortWith(Comparator { t1, t2 ->
            t1[0] - t2[0]
        })
        val minHeap = PriorityQueue<Int>()
        // O(n) to iterate every item in sorted intervals
        intervals.forEach { interval ->
            // Check if current startTime is bigger than the min endTime of the minHeap
            if (minHeap.isNotEmpty() && interval[0] >= minHeap.peek()) {
                // O(log n) to remove min endTime from the minHeap
                minHeap.poll()
            }
            // O(log n) to add endTime to minHeap
            minHeap.add(interval[1])
        }
        
        return minHeap.size
    }
}