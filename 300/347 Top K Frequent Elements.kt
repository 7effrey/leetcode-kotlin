class Solution {
    // Time Complexity: O(n log k)
    // Space Complexity: O(n)
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        // Comparator will compare based on its frequency map values
        val heap = PriorityQueue<Int>({ t1, t2 -> map[t1]!! - map[t2]!! })
        
        // O(n)
        nums.forEach { num ->
            map[num] = (map[num] ?: 0) + 1
        }
        // O(m), ideally m is smaller than n because some of the elements will be duplicated
        map.keys.forEach { num ->
            // O(log k)
            heap.add(num)
            if (heap.size > k) {
                // O(log k)
                heap.poll()
            }
        }
        // O(k)
        return heap.toIntArray()
    }
}