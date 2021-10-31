class Solution {
    
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        return kClosestHeap(points, k)
    }
    
    // Time Complexity: O(n log k)
    // Space Complexity: O(k)
    private fun kClosestHeap(points: Array<IntArray>, k: Int): Array<IntArray> {
        val mapping = hashMapOf<IntArray, Int>()
        // O(n)
        points.forEach { point ->
            mapping[point] = point[0] * point[0] + point[1] * point[1] 
        }
        
        val maxHeap = PriorityQueue<IntArray> { t1, t2 -> mapping[t2]!! - mapping[t1]!! }
        // O(n)
        points.forEach { point ->
            // O(log k)
            maxHeap.add(point)
            if (maxHeap.size > k) {
                // O(log k)
                maxHeap.poll()
            }
        }
        // O(n)
        return maxHeap.toTypedArray()
    }
}